package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.VetDTO;

import java.util.List;

public interface IVetService {
    VetDTO getCurrentVet();

    List<VetDTO> getAllVets();
}
