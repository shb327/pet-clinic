package com.aboba.petclinic.controller;

import com.aboba.petclinic.DTOs.PetDTO;
import com.aboba.petclinic.model.Appointment;
import com.aboba.petclinic.repository.AppointmentRepository;
import com.aboba.petclinic.service.PetService;
import com.aboba.petclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    final
    VetService vetService;

    final
    PetService petService;

    final
    AppointmentRepository appointmentRepository;

    public CustomerController(VetService vetService, PetService petService, AppointmentRepository appointmentRepository) {
        this.vetService = vetService;
        this.petService = petService;
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping
    public String home() {
        return "customer";
    }

    /**
     * Show vets
     * @param model - object for pasrdwq
     * @return html template name
     */
    @GetMapping("vets")
    public String showVets(Model model) {
        model.addAttribute("vets", vetService.getAllVets());
        return "vets";
    }

    @GetMapping("pets")
    public String showPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }

    @GetMapping("petchoose")
    public String showAppointmentFirst(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "petchoose";
    }

    @PostMapping("petchoose")
    public String createAppointment(@RequestParam("date") String date,
                                    @RequestParam("pet_id") Long petId,
                                    @RequestParam("description") String description,
                                    Model model) {
        PetDTO pet = petService.findPetById(petId).orElseThrow(NoSuchElementException::new);
        Appointment appointment = new Appointment(0L, date, description, pet.toPet(), null);
        appointmentRepository.save(appointment);
        return "success";
    }

//    @GetMapping("/fininfo/{pet_id}")
//    public String showFinalInfo(@PathVariable Long pet_id){
//        return "fininfo";
//    }

    @PostMapping("/fininfo/{appointment_id}")
    public String showFinalInfo(@PathVariable Long pet_id) {
        return "fininfo";
    }
}
