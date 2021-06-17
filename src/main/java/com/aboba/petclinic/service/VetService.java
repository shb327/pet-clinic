package com.aboba.petclinic.service;

import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import com.aboba.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetService {
    private final VetRepository vetRepository;
    private final UserService userService;

    public VetService(VetRepository vetRepository, UserService userService) {
        this.vetRepository = vetRepository;
        this.userService = userService;
    }

    public Vet getCurrentVet() {
        return vetRepository.findByUser(userService.getCurrentUser())
                .orElseThrow(() -> new IllegalArgumentException("username not found"));
    }

    public Vet save(Vet vet) {
        if (vet.getUser() == null) {
            vet.setUser(userService.getCurrentUser());
        }
        return vetRepository.save(vet);
    }
}
