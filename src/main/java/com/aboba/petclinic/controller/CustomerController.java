package com.aboba.petclinic.controller;

import com.aboba.petclinic.service.PetService;
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
    VetService vetService;

    @Autowired
    PetService petService;


    @GetMapping
    public String home() {
        return "customer";
    }

    @GetMapping("vets")
    public String showVets(Model model){
        model.addAttribute("vets", vetService.getAllVets());
        return "vets";
    }

    @GetMapping("pets")
    public String showPets(Model model){
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }
}
