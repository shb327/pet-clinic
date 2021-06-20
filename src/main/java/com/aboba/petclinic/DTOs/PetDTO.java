package com.aboba.petclinic.DTOs;

import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.PetStatus;
import com.aboba.petclinic.model.PetType;
import lombok.Getter;

import java.util.Set;

@Getter
public class PetDTO {
    private Long id;
    private String name;
    private PetType type;
    private Integer weight;
    private Integer age;
    private PetStatus status;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.type = pet.getPetType();
        this.weight = pet.getWeight();
        this.age = pet.getAge();
        this.status = pet.getPetStatus();
    }


    public Pet toPet() {
        return new Pet(getId(), getName(), getAge(), getWeight(), getType(), getStatus(), Set.of());
    }
}
