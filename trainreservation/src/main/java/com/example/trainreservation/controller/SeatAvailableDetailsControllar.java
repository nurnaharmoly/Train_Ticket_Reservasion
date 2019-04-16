package com.example.trainreservation.controller;

import com.example.trainreservation.entity.SeatAvailableDetails;
import com.example.trainreservation.entity.SeatDetails;
import com.example.trainreservation.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/seatAvailableDetails/")
public class SeatAvailableDetailsControllar {



    @Autowired
    private SeatAvailableDetailsRepo repo;


    @Autowired
    private TrainRepo trainRepo;


    @Autowired
    private CompartmentRepo compartmentRepo;


    @Autowired
    private SeatOrCabinRepo seatOrCabinRepo;

    @Autowired
    private SeatDetailsRepo seatDetailsRepo;


    @GetMapping(value = "add")
    public String viewAdd(Model model){
        model.addAttribute("seatAvailableDetails",new SeatAvailableDetails());
        model.addAttribute("trainlist", trainRepo.findAll());
//        model.addAttribute("compartmentlist", compartmentRepo.findAll());
//        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        return "seatAvailableDetails/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid SeatAvailableDetails seatAvailableDetails, BindingResult result, Model model) {


            List<SeatDetails> detailsList = seatDetailsRepo.findAllByTrain(seatAvailableDetails.getTrain());
            System.out.println("Size of seatsDetails: "+seatDetailsRepo.findAllByTrain(seatAvailableDetails.getTrain()).size());
            for(SeatDetails sd : detailsList){
                SeatAvailableDetails sad=new SeatAvailableDetails();
                sad.setTrain(sd.getTrain());
                sad.setCompartment(sd.getCompartment());
                sad.setSeatOrCabin(sd.getSeatOrCabin());
                sad.setStatus(sd.getStatus());
                sad.setJournyDate(seatAvailableDetails.getJournyDate());
               this.repo.save(sad);
            }



            model.addAttribute("seatAvailableDetails",new SeatAvailableDetails());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("trainlist", trainRepo.findAll());
//            model.addAttribute("compartmentlist", compartmentRepo.findAll());
//            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());


        return "seatAvailableDetails/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("seatAvailableDetails",repo.getOne(id));
        model.addAttribute("trainlist", trainRepo.findAll());
//        model.addAttribute("compartmentlist", compartmentRepo.findAll());
//        model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
        return "seatAvailableDetails/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid SeatAvailableDetails seatAvailableDetails, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("trainlist", trainRepo.findAll());
//            model.addAttribute("compartmentlist", compartmentRepo.findAll());
//            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            return "seatAvailableDetails/edit";
        } else {
            seatAvailableDetails.setId(id);
            this.repo.save(seatAvailableDetails);
            model.addAttribute("trainlist", trainRepo.findAll());
//            model.addAttribute("compartmentlist", compartmentRepo.findAll());
//            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
            return "redirect:/seatAvailableDetails/list";
        }
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id){
        if(id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/seatAvailableDetails/list";
    }


    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "seatAvailableDetails/list";
    }

    @GetMapping(value = "seatV")
    public String seat(){
        return "seatAvailableDetails/seatView";
    }











//    @GetMapping(value = "create.jsf")
//    public String displaySeatDetails(Model model){
//        model.addAttribute("obj", new SeatDetails());
//        return "seatDetails/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "seatDetails/list";
//
//    }

/////////////////////////////SAles ///////////////////
//@PostMapping(value = "sell")
//public String sellTicket(@Valid SeatAvailableDetails seatAvailableDetails, BindingResult result, Model model) {
//
//
//    List<SeatDetails> detailsList = seatDetailsRepo.findAllByTrain(seatAvailableDetails.getTrain());
//    System.out.println("Size of seatsDetails: "+seatDetailsRepo.findAllByTrain(seatAvailableDetails.getTrain()).size());
//    for(SeatDetails sd : detailsList){
//        SeatAvailableDetails sad=new SeatAvailableDetails();
//        sad.setTrain(sd.getTrain());
//        sad.setCompartment(sd.getCompartment());
//        sad.setSeatOrCabin(sd.getSeatOrCabin());
//        sad.setStatus(sd.getStatus());
//        sad.setJournyDate(seatAvailableDetails.getJournyDate());
//        this.repo.save(sad);
//    }
//
//
//
//    model.addAttribute("seatAvailableDetails",new SeatAvailableDetails());
//    model.addAttribute("successMsg", "Successfully Saved!");
//    model.addAttribute("trainlist", trainRepo.findAll());
////            model.addAttribute("compartmentlist", compartmentRepo.findAll());
////            model.addAttribute("seatOrCabinlist", seatOrCabinRepo.findAll());
//
//
//    return "seatAvailableDetails/add";
//}


}
