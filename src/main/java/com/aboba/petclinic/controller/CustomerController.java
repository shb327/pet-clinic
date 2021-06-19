package com.aboba.petclinic.controller;

import com.aboba.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private VetService vetService;

    @GetMapping
    public String home() {
        return "customer";
    }

    @GetMapping("vets")
    public String showVets(Model model){
        model.addAttribute("vets", vetService.getAllVets());
        return "vets";
    }
}
