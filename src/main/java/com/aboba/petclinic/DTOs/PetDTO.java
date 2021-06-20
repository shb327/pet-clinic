package com.aboba.petclinic.DTOs;

import com.aboba.petclinic.model.Pet;
import lombok.Getter;

@Getter
public class PetDTO {
    private Long id;
    private String name;
    private String type;
    private Integer weight;
    private Integer age;
    private String status;

    public PetDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.type = pet.getPetType().getName();
        this.weight = pet.getWeight();
        this.age = pet.getAge();
        if(pet.getPetStatus().getUnderTreatment()) this.status = "Healthy";
        else this.status = "Treated";
    }

    public String getPetType() {
        return type;
    }

    public String getPetStatus() {
        return status;
    }
}
