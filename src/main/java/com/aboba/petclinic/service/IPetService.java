package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;

import java.util.List;
import java.util.Optional;

public interface IPetService {
    List<PetDTO> getAllPets();

    Optional<PetDTO> findPetById(Long petId);
}
