package com.example.trainreservation.controller;

import com.example.trainreservation.entity.Sales;
import com.example.trainreservation.entity.Summary;
import com.example.trainreservation.entity.TrainClass;
import com.example.trainreservation.repo.SalesRepo;
import com.example.trainreservation.repo.SummaryRepo;
import com.example.trainreservation.repo.TicketRepo;
import com.example.trainreservation.repo.TrainClassRepo;
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

@Controller
@RequestMapping(value = "/sales")
public class SalesControllar {

//    @Autowired
//    private TicketRepo ticketRepo;
//
//    @Autowired
//    private SalesRepo salesRepo;
//
//    @Autowired
//    private SummaryRepo summaryRepo;
//
//
//    @GetMapping(value = "/add")
//    public String addShow(Sales sales, Model model) {
//        model.addAttribute("sales", new Sales());
//
//        model.addAttribute("ticketlist", this.ticketRepo.findAll());
//        return "saless/sal";
//
//    }
//
//    @PostMapping(value = "/add")
//    public String salesSave(@Valid Sales sales, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("ticketlist", this.ticketRepo.findAll());
//            return "saless/sal";
//        }
//        try {
//            Summary summary = this.summaryRepo.findByTicket(sales.getTicket());
//            if(sales.getQty() <= summary.getAvailableQty()) {
//                this.salesRepo.save(sales);
//                model.addAttribute("sales", new Sales());
//                model.addAttribute("success", "Congratulations! Data save sucessfully");
//                model.addAttribute("ticketlist", this.ticketRepo.findAll());
//                //Summar save
//
//
//                int avialQty = summary.getAvailableQty() - sales.getQty();
//                summary.setAvailableQty(avialQty);
//                int totalSold = summary.getSoldQty() + sales.getQty();
//                summary.setSoldQty(totalSold);
//                summary.setLastUpdate(new Date());
//                summaryRepo.save(summary);
//            }else{
//                model.addAttribute("rejectMsg", "You don't have sufficient Qty");
//                model.addAttribute("tioketlist", this.ticketRepo.findAll());
//
//            }
//
//        } catch (NullPointerException ne) {
//            ne.printStackTrace();
//        }
//
//
//        return "saless/sal";
//    }
//
//
//    @GetMapping(value = "/list")
//    public String salesIndex(Model model) {
//        model.addAttribute("saleslist", this.salesRepo.findAll());
//        return "saless/list";
//    }
//
//
//
//    @GetMapping(value = "/del/{id}")
//    public String salesDel(@PathVariable("id") Long id) {
//        if (id != null) {
//            this.salesRepo.deleteById(id);
//
//        }
//        return "redirect:/sales/list";
//
    }

