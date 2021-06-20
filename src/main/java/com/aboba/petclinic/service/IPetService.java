package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;

import java.util.List;
import java.util.Optional;

/**
 * Simple JavaBean domain interface representing a service for pet
 *
 * @author Bohdan Shkamarida
 */

public interface IPetService {
    List<PetDTO> getAllPets();

    Optional<PetDTO> findPetById(Long petId);
}
