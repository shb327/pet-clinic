package com.aboba.petclinic.controller;

import com.aboba.petclinic.model.Appointment;
import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.repository.AppointmentRepository;
import com.aboba.petclinic.service.PetService;
import com.aboba.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    VetService vetService;

    @Autowired
    PetService petService;

    @Autowired
    AppointmentRepository appointmentRepository;

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

    @GetMapping("petchoose")
    public String showAppointmentFirst(Model model){
        model.addAttribute("pets", petService.getAllPets());
        return "petchoose";
    }

    @PostMapping("petchoose")
    public String createAppointment(@RequestBody Appointment appointment, Model model){
        appointmentRepository.save(appointment);
        return "petchoose";
    }

//    @GetMapping("/fininfo/{pet_id}")
//    public String showFinalInfo(@PathVariable Long pet_id){
//        return "fininfo";
//    }

    @PostMapping("/fininfo/{appointment_id}")
    public String showFinalInfo(@PathVariable Long pet_id){
        return "fininfo";
    }
}
