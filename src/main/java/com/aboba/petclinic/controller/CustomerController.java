package com.aboba.petclinic.controller;

import com.aboba.petclinic.DTOs.PetDTO;
import com.aboba.petclinic.service.IPetService;
import com.aboba.petclinic.service.IVetService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.NoSuchElementException;

/**
 * @author Bohdan Shkamarida
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final IVetService vetService;
    private final IPetService petService;

    public CustomerController(IVetService vetService, IPetService petService) {
        this.vetService = vetService;
        this.petService = petService;
    }

    /**
     * Mapping for Customer Home Page
     *
     * @return String with the model attributes for the view
     */
    @GetMapping
    public String home() {
        return "customer";
    }

    /**
     * Mapping for Showing List of Veterinarians (Together with the list of Vet's specializations).
     *
     * @return String with the model attributes for the view
     */
    @GetMapping("vets")
    public String showVets(Model model) {
        model.addAttribute("vets", vetService.getAllVets());
        return "vets";
    }

    /**
     * Mapping for Showing Customer's List of Pets.
     *
     * @return String with the model attributes for the view
     */
    @GetMapping("pets")
    public String showPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }

    /**
     * Mapping for Showing Appointment Request Form.
     *
     * @return String with the model attributes for the view
     */
    @GetMapping("petchoose")
    public String showAppointmentFirst(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "petchoose";
    }

    /**
     * Post Mapping for adding appointment record to the database
     *
     * @param date        field for the appointment record
     * @param petId       field for the appointment record
     * @param description field for the appointment record
     * @return String with the model attributes for the view
     */
    @PostMapping("petchoose")
    public String createAppointment(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                    @RequestParam("pet_id") Long petId,
                                    @RequestParam("description") String description) {
        PetDTO pet = petService.findPetById(petId).orElseThrow(NoSuchElementException::new);
        petService.newAppointment(date, description, pet);
        petService.setPetUnderTreatment(pet, date);
        return "success";
    }

    /**
     * Post Mapping for adding appointment record to the database
     *
     * @return String with the model attributes for the view
     */
    @PostMapping("/fininfo/{appointment_id}")
    public String showFinalInfo(@PathVariable Long pet_id) {
        return "fininfo";
    }
}
