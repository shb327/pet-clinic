package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;
import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.PetType;
import com.aboba.petclinic.model.Vet;
import com.aboba.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    public List<PetDTO> getAllPets(){
        List<PetDTO> dtos = new ArrayList<>();
        for (Pet pet : petRepository.findAll()) {
            dtos.add(new PetDTO(pet));
        }
        return dtos;
    }
}
