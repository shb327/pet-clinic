package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.PetDTO;

import java.util.List;

public interface IPetService {
    List<PetDTO> getAllPets();
}
