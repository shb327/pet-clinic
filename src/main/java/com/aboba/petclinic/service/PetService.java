package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;
import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.PetType;
import com.aboba.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Simple JavaBean domain object representing a service for pet
 *
 * @author Bohdan Shkamarida
 */

@Service
public class PetService implements  IPetService{
    @Autowired
    PetRepository petRepository;

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
}
