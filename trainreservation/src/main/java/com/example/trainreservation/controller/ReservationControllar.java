package com.example.trainreservation.controller;

import com.example.trainreservation.entity.*;
import com.example.trainreservation.jasper.MediaUtils;
import com.example.trainreservation.jasper.ReserveService;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/reservation/")
public class ReservationControllar {


    @Autowired
    private ReservationRepo repo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private CompartmentRepo compartmentRepo;

    @Autowired
    private TrainRepo trainRepo;

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private ReserveService reserveService;

    @Autowired
    ServletContext context;


//    @Autowired
//    private SummaryRepo summaryRepo;


    @Autowired
    private SeatDetailsRepo seatDetailsRepo;

    @Autowired
    private AvailableTrainScheduleRepo availableTrainScheduleRepo;
    @Autowired
    private SeatAvailableDetailsRepo seatAvailableDetailsRepo;

    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("reservation",new Reservation());
            model.addAttribute("availableTrainSchedule",new AvailableTrainSchedule());
//        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
            model.addAttribute("sad",this.seatAvailableDetailsRepo.findByTrain(new Train(10L)).get(0));
            model.addAttribute("trainlist",this.trainRepo.findAll());
        model.addAttribute("ticketlist",this.ticketRepo.findAll());
//        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());

        return "reservation/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Reservation reservation, BindingResult result, Model model) {

        System.out.println("Size of seatsDetails: "+seatDetailsRepo.findAllByTrain(reservation.getTrain()).size());
        reservation.setCompartment(new Compartment(2L));
        reservation.setTicket(new Ticket(1L));
       repo.save(reservation);
        model.addAttribute("sad",this.seatAvailableDetailsRepo.findByTrain(new Train(10L)).get(0));

//        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        User user=this.userRepo.findByUserName(auth.getName());
//        reservation.setPasenger(user);
//        reservation.setJournyDate(new Date());
//            this.repo.save(reservation);
            model.addAttribute("reservation", new Reservation());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("ticketlist", this.ticketRepo.findAll());
//            model.addAttribute("compartmentlist", this.comparmentRepo.findAll());
            model.addAttribute("trainlist", this.trainRepo.findAll());
//            model.addAttribute("userlist", this.userRepo.findAll());
        model.addAttribute("seatDetailslist", this.seatDetailsRepo.findAll());
        model.addAttribute("availableTrainSchedulelist", this.availableTrainScheduleRepo.findAll());



        return "reservation/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("reservation",repo.getOne(id));
        model.addAttribute("availableTrainSchedule",new AvailableTrainSchedule());
//        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
        model.addAttribute("sad",this.seatAvailableDetailsRepo.findByTrain(new Train(10L)).get(0));
        model.addAttribute("trainlist",this.trainRepo.findAll());
        model.addAttribute("ticketlist",this.ticketRepo.findAll());
//        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());
        return "reservation/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Reservation reservation, BindingResult result, Model model,@PathVariable("id") Long id){
//        if(result.hasErrors()){
//            model.addAttribute("ticketlist", ticketRepo.findAll());
//            model.addAttribute("compartmentlist", compartmentRepo.findAll());
//            model.addAttribute("trainlist", trainRepo.findAll());
//
//            model.addAttribute("userlist", userRepo.findAll());
//            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
//            model.addAttribute("availableTrainSchedulelist", availableTrainScheduleRepo.findAll());
//            return "reservation/edit";
//        } else {
            reservation.setId(id);
            this.repo.save(reservation);
        model.addAttribute("successMsg", "Successfully Saved!");
        model.addAttribute("ticketlist", this.ticketRepo.findAll());
//            model.addAttribute("compartmentlist", this.comparmentRepo.findAll());
        model.addAttribute("trainlist", this.trainRepo.findAll());
//            model.addAttribute("userlist", this.userRepo.findAll());
        model.addAttribute("seatDetailslist", this.seatDetailsRepo.findAll());
        model.addAttribute("availableTrainSchedulelist", this.availableTrainScheduleRepo.findAll());

        return "redirect:/reservation/list";
        }


    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/reservation/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "reservation/list";
    }



    @RequestMapping(value = "reservereport", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reserveService.reservetionreport());
        InputStream inputStream = this.getClass().getResourceAsStream("/resevereport.jrxml");
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
//        String source = "src\\main\\resources\\resevereport.jrxml";
//        try {
//            JasperCompileManager.compileReportToFile(source);
//        } catch (JRException e) {
//            e.printStackTrace();
//        }
        String sourceFileName = "src\\main\\resources\\resevereport.jasper";
        String printFileName = null;
        String destFileName = "src\\main\\resources\\resevereport.pdf";
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reserveService.reservetionreport());
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
        String fileName="src\\\\main\\\\resources\\\\resevereport.pdf";
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
