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

/**
 *
 * @author Bohdan Shkamarida
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final VetService vetService;
    private final PetService petService;
    private final AppointmentRepository appointmentRepository;

    public CustomerController(VetService vetService, PetService petService, AppointmentRepository appointmentRepository) {
        this.vetService = vetService;
        this.petService = petService;
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Mapping for Customer Home Page
     * @return String with the model attributes for the view
     */
    @GetMapping
    public String home() {
        return "customer";
    }

    /**
     *  Mapping for Showing List of Veterinarians (Together with the list of Vet's specializations).
     *  @return String with the model attributes for the view
     */
    @GetMapping("vets")
    public String showVets(Model model) {
        model.addAttribute("vets", vetService.getAllVets());
        return "vets";
    }

    /**
     *  Mapping for Showing Customer's List of Pets.
     *  @return String with the model attributes for the view
     */
    @GetMapping("pets")
    public String showPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets";
    }

    /**
     *  Mapping for Showing Appointment Request Form.
     *  @return String with the model attributes for the view
     */
    @GetMapping("petchoose")
    public String showAppointmentFirst(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "petchoose";
    }

    /**
     *  Post Mapping for adding appointment record to the database
     *  @param date field for the appointment record
     *  @param petId field for the appointment record
     *  @param description field for the appointment record
     *  @return String with the model attributes for the view
     */
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

    /**
     *  Post Mapping for adding appointment record to the database
     *  @return String with the model attributes for the view
     */
    @PostMapping("/fininfo/{appointment_id}")
    public String showFinalInfo(@PathVariable Long pet_id) {
        return "fininfo";
    }
}
