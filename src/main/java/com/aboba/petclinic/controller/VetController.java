package com.aboba.petclinic.controller;

import com.aboba.petclinic.service.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bohdan Shkamarida
 */
@Slf4j
@Controller
@RequestMapping("/vet")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    /**
     *
     *  Mapping for Vet Home Page
     */
    @GetMapping
    public String home(Model model) {
        model.addAttribute("vet", vetService.getCurrentVet());
        return "vet";
    }
}
