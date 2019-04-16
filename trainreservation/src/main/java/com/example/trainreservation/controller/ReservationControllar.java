package com.example.trainreservation.controller;

import com.example.trainreservation.entity.*;
import com.example.trainreservation.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
//        model.addAttribute("compartmentlist",this.compartmentRepo.findAll());

        return "reservation/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Reservation reservation, BindingResult result, Model model) {
        List<SeatDetails> detailsList = seatDetailsRepo.findAllByTrain(reservation.getTrain());
        System.out.println("Size of seatsDetails: "+seatDetailsRepo.findAllByTrain(reservation.getTrain()).size());
        for(SeatDetails sd : detailsList){
            Reservation rv=new Reservation();
            rv.setTrain(sd.getTrain());
            rv.setCompartment(sd.getCompartment());
            rv.setTotalPrice(reservation.getTotalPrice());
            rv.setNoOffSeats(reservation.getNoOffSeats());
            rv.setUnitPrice(reservation.getUnitPrice());
            rv.setTicket(reservation.getTicket());
            rv.setJournyDate(reservation.getJournyDate());
            this.repo.save(rv);
        }
//        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        User user=this.userRepo.findByUserName(auth.getName());
//        reservation.setPasenger(user);
//        reservation.setJournyDate(new Date());
//            this.repo.save(reservation);
            model.addAttribute("reservation", new Reservation());
            model.addAttribute("successMsg", "Successfully Saved!");
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
        model.addAttribute("availableTrainSchedulelist", availableTrainScheduleRepo.findAll());

//        try {
//
//            Summary summary = this.summaryRepo.findByTicket(reservation.getTicket());
//            AvailableSeats availableSeat = new AvailableSeats();
//
////            int avialseat = summary.getAvailableSeat(availableSeat)+ reservation.getNoOffSeats();
////            summary.setAvailableSeat(avialseat);
////            summary.setLastUpdate(new Date());
////            summary.setTotalQty(summary.getTotalQty() + reservation.getNoOffSeats().);
//            summaryRepo.save(summary);
//
//        } catch (NullPointerException ne) {
//            Summary summary1 = new Summary();
////            summary1.setTicketNo(purchase.getTicket().getTicketNo();
//
////            summary1.setTotalQty(reservation.getNoOffSeats());
////            summary1.setSoldQty(0);
////            summary1.setAvailableSeat(reservation.getNoOffSeats());
//            summary1.setLastUpdate(new Date());
//            summary1.setTicket(reservation.getTicket());
//            summaryRepo.save(summary1);
//
//        }

        return "reservation/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("reservation",repo.getOne(id));
        model.addAttribute("ticketlist", ticketRepo.findAll());
        model.addAttribute("compartmentlist", compartmentRepo.findAll());
        model.addAttribute("trainlist", trainRepo.findAll());
        model.addAttribute("userlist", userRepo.findAll());
        model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
        model.addAttribute("availableTrainSchedulelist", availableTrainScheduleRepo.findAll());
        return "reservation/edit";
    }
    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Reservation reservation, BindingResult result, Model model,@PathVariable("id") Long id){
        if(result.hasErrors()){
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
            model.addAttribute("availableTrainSchedulelist", availableTrainScheduleRepo.findAll());
            return "reservation/edit";
        } else {
            reservation.setId(id);
            this.repo.save(reservation);
            model.addAttribute("ticketlist", ticketRepo.findAll());
            model.addAttribute("compartmentlist", compartmentRepo.findAll());
            model.addAttribute("trainlist", trainRepo.findAll());
            model.addAttribute("userlist", userRepo.findAll());
            model.addAttribute("seatDetailslist", seatDetailsRepo.findAll());
            model.addAttribute("availableTrainSchedulelist", availableTrainScheduleRepo.findAll());
            return "redirect:/reservation/list";
        }
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





//    @GetMapping(value = "create.jsf")
//    public String displayReservation(Model model){
//        model.addAttribute("obj", new Reservation());
//        return "reservation/create";
//
//    }
//
//    @GetMapping(value = "list.jsf")
//    public String getList(){
//        return "reservation/list";
//
//    }
}
