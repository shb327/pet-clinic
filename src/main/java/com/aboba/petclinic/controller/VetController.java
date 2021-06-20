package com.aboba.petclinic.controller;

import com.aboba.petclinic.model.Appointment;
import com.aboba.petclinic.service.AppointmentService;
import com.aboba.petclinic.service.CustomerService;
import com.aboba.petclinic.service.PetService;
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
    private final CustomerService customerService;
    private final PetService petService;
    private final AppointmentService appointmentService;

    public VetController(VetService vetService, CustomerService customerService,
                         PetService petService, AppointmentService appointmentService) {
        this.customerService = customerService;
        this.vetService = vetService;
        this.petService = petService;
        this.appointmentService = appointmentService;
    }

    /**
     *
     *  Mapping for Vet Home Page
     */
    @GetMapping
    public String home(Model model) {
        model.addAttribute("vet", vetService.getCurrentVet());
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "vet";
    }

    /**
     * Mapping for Showing List of Customers.
     *
     * @return String with the model attributes for the view
     */
    @GetMapping("customers")
    public String showCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    /**
     * Mapping for Showing Customer's List of Pets.
     *
     * @return String with the model attributes for the view
     */
    @GetMapping("vetpets")
    public String showPets(Model model) {
        model.addAttribute("vetpets", petService.getAllPets());
        return "vetpets";
    }
}
