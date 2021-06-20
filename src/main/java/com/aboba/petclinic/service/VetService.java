package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.VetDTO;
import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import com.aboba.petclinic.repository.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VetService implements IVetService {
    @Autowired
    VetRepository vetRepository;

    @Autowired
    UserService userService;

    @Override
    public VetDTO getCurrentVet() {
        Vet vet = vetRepository.findByUser(userService.getCurrentUser())
                .orElseThrow(() -> new IllegalArgumentException("username not found"));
        return new VetDTO(vet);
    }

    public Vet save(Vet vet) {
        if (vet.getUser() == null) {
            vet.setUser(userService.getCurrentUser());
        }
        return vetRepository.save(vet);
    }

    @Override
    public List<VetDTO> getAllVets(){
        List<VetDTO> dtos = new ArrayList<>();
        for (Vet pet : vetRepository.findAll()) {
            dtos.add(new VetDTO(pet));
        }
        return dtos;
    }
}
