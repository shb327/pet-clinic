package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.VetDTO;

import java.util.List;

/**
 * Simple JavaBean domain interface representing a service for vet
 *
 * @author Bohdan Shkamarida
 */

public interface IVetService {
    VetDTO getCurrentVet();

    List<VetDTO> getAllVets();
}
