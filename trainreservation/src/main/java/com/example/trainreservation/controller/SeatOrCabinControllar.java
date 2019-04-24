package com.example.trainreservation.controller;

import com.example.trainreservation.entity.*;
import com.example.trainreservation.jasper.MediaUtils;
import com.example.trainreservation.jasper.TaskService;
import com.example.trainreservation.repo.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.HtmlExporter;
//import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.export.PdfExporterConfiguration;
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimpleHtmlExporterOutput;


@Controller
@RequestMapping(value = "/seatOrCabin/")
public class SeatOrCabinControllar {


    @Autowired
    private SeatOrCabinRepo repo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @Autowired
    private TrainClassRepo trainClassRepo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private SeatDetailsRepo seatDetailsRepo;

    @Autowired
    private TaskService taskService;

    @Autowired
    ServletContext context;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("seatOrCabin",new SeatOrCabin());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainClasslist", trainClassRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());

        return "seatOrCabin/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid SeatOrCabin seatOrCabin, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "seatOrCabin/add";
        }else{
            this.repo.save(seatOrCabin);

            SeatDetails sd=new SeatDetails();
            sd.setStatus(true);
            sd.setCompartment(seatOrCabin.getCompartment());
            sd.setTrain(seatOrCabin.getTrain());
            sd.setSeatOrCabin(seatOrCabin);
            this.seatDetailsRepo.save(sd);

            model.addAttribute("seatOrCabin", new SeatOrCabin());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
        }

        return "seatOrCabin/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("seatOrCabin",repo.getOne(id));
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainClasslist", trainClassRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());
        return "seatOrCabin/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid SeatOrCabin seatOrCabin, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "seatOrCabin/edit";
        } else {
             seatOrCabin.setId(id);
            this.repo.save(seatOrCabin);
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainClasslist", trainClassRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            return "redirect:/seatOrCabin/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/seatOrCabin/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "seatOrCabin/list";
    }



//    @RequestMapping(value = "report", method = RequestMethod.GET)
//    public void report(HttpServletResponse response) throws Exception {
//        response.setContentType("text/html");
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(taskService.report());
//        InputStream inputStream = this.getClass().getResourceAsStream("/report.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
//        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
//        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
//        exporter.exportReport();
//    }



    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(taskService.seatreport());
        InputStream inputStream = this.getClass().getResourceAsStream("/report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
    }

    ////////////////pdf//////////////////////


    //    @RequestMapping(value = "/pdf", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_PDF_VALUE)
    public void reportPdf() throws Exception {
        String source = "src\\main\\resources\\report.jrxml";
        try {
            JasperCompileManager.compileReportToFile(source);
        } catch (JRException e) {
            e.printStackTrace();
        }
        String sourceFileName = "src\\main\\resources\\report1.jasper";
        String printFileName = null;
        String destFileName = "src\\main\\resources\\report.pdf";
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(taskService.seatreport());
        Map parameters = new HashMap();
        try {
            printFileName = JasperFillManager.fillReportToFile(sourceFileName,
                    parameters, dataSource);
            if (printFileName != null) {
                JasperExportManager.exportReportToPdfFile(printFileName,
                        destFileName);
            }
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/pdf")
    public ResponseEntity<InputStreamResource> downloadFile1() throws IOException {
        try {
            reportPdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileName="src\\\\main\\\\resources\\\\report.pdf";
        MediaType mediaType = MediaUtils.getMediaTypeForFileName(this.context, fileName);

        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }



}
