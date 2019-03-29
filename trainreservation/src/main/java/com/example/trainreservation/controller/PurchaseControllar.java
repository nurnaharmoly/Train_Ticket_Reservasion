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

@Controller
@RequestMapping(value = "/purchase")
public class PurchaseControllar {

//    @Autowired
//    private TicketRepo ticketRepo;
//    @Autowired
//    private PurchaseRepo purchaseRepo;
//
//    @Autowired
//    private SummaryRepo summaryRepo;
//
//@Autowired
//private UserRepo userRepo;
//
//    @GetMapping(value = "/add")
//    public String addShow(Purchase purchase, Model model) {
//        model.addAttribute("purchase", new Purchase());
//
//        model.addAttribute("ticketlist", this.ticketRepo.findAll());
//        return "purchase/purchase";
//
//    }
//
//    @PostMapping(value = "/add")
//    public String purchaseSave(@Valid Purchase purchase, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("ticketlist", this.ticketRepo.findAll());
//            return "purchase/purchase";
//        }
//        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        User user=this.userRepo.findByUserName(auth.getName());
//        purchase.setPasenger(user);
//        purchase.setPurchasedate(new Date());
//        this.purchaseRepo.save(purchase);
//        model.addAttribute("purchase", new Purchase());
//        model.addAttribute("success", "Congratulations! Data save sucessfully");
//        model.addAttribute("ticketlist", this.ticketRepo.findAll());
//        //Summar save
//        try {
//
//            Summary summary = this.summaryRepo.findByTicket(purchase.getTicket());
//            int avialQty = summary.getAvailableQty() + purchase.getQty();
//            summary.setAvailableQty(avialQty);
//            summary.setLastUpdate(new Date());
//            summary.setTotalQty(summary.getTotalQty() + purchase.getQty());
//            summaryRepo.save(summary);
//
//        } catch (NullPointerException ne) {
//            Summary summary1 = new Summary();
////            summary1.setTicketNo(purchase.getTicket().getTicketNo();
//
//            summary1.setTotalQty(purchase.getQty());
//            summary1.setSoldQty(0);
//            summary1.setAvailableQty(purchase.getQty());
//            summary1.setLastUpdate(new Date());
//            summary1.setTicket(purchase.getTicket());
//            summaryRepo.save(summary1);
//
//        }
//
//
//        return "redirect:/pur/list";
//    }
//
//
//    @GetMapping(value = "/list")
//    public String purchaseIndex(Model model) {
//        model.addAttribute("purchaselist", this.purchaseRepo.findAll());
//        return "purchase/list";
//    }
//
//
//    @GetMapping(value = "/del/{id}")
//    public String purchasedel(@PathVariable("id") Long id) {
//        if (id != null) {
//            this.purchaseRepo.deleteById(id);
//
//        }
//        return "redirect:/pur/list";
//
//    }
//
}
