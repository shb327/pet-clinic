package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;
import com.aboba.petclinic.model.*;
import com.aboba.petclinic.repository.AppointmentRepository;
import com.aboba.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Simple JavaBean domain object representing a service for pet
 *
 * @author Bohdan Shkamarida
 */

@Service
public class PetService implements  IPetService{
    final
    PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;

    public PetService(PetRepository petRepository, AppointmentRepository appointmentRepository) {
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public Pet createPet(String name, Integer age, Integer weight, PetType petType) {
        return petRepository.save(Pet.builder()
                .name(name)
                .age(age)
                .weight(weight)
                .petType(petType)
                .build());
    }

    @Override
    public List<PetDTO> getAllPets() {
        List<PetDTO> dtos = new ArrayList<>();
        for (Pet pet : petRepository.findAll()) {
            dtos.add(new PetDTO(pet));
        }
        return dtos;
    }

    @Override
    public Optional<PetDTO> findPetById(Long petId) {
        return petRepository.findById(petId)
                .map(PetDTO::new);
    }

    @Override
    public void newAppointment(Date date, String description, PetDTO pet) {
        Appointment appointment = new Appointment(0L,
                date,
                description,
                pet.toPet(),
                null,
                createAppointmentStatus("scheduled", date));
        appointmentRepository.save(appointment);
    }

    @Override
    public void setPetUnderTreatment(PetDTO petDto, Date start) {
        Pet pet = petDto.toPet();
        PetStatus petStatus = new PetStatus(true);
        petStatus.setPeriodStart(new Timestamp(start.getTime()));
        pet.setPetStatus(petStatus);
        petRepository.save(pet);
    }

    private AppointmentStatus createAppointmentStatus(String status, Date date) {
        AppointmentStatus appointmentStatus = new AppointmentStatus(status);
        appointmentStatus.setPeriodStart(new Timestamp(date.getTime()));
        return appointmentStatus;
    }
}
