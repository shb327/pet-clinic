package com.aboba.petclinic.service;

import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.PetType;
import com.aboba.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public Pet createPet(String name, Integer age, Integer weight, PetType petType) {
        return petRepository.save(Pet.builder()
                .name(name)
                .age(age)
                .weight(weight)
                .petType(petType)
                .build());
    }
}
