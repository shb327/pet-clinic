package com.aboba.petclinic.DTOs;

import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.Specialization;
import com.aboba.petclinic.model.Vet;
import lombok.Getter;

import java.util.List;


/**
 * Simple JavaBean domain object representing a veterinarian class
 * Was implemented in order to transfer pet object to the view
 *
 * @author Bohdan Shkamarida
 * */

@Getter
public class VetDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String specializations;

    public VetDTO(Vet vet) {
        this.firstName = vet.getUser().getFirstName();
        this.lastName = vet.getUser().getLastName();
        this.age = vet.getUser().getAge();
        this.email = vet.getUser().getEmail();
        this.specializations = getSpecializations(vet.getSpecializations());
    }

    private String getSpecializations(List<Specialization> specializations) {
        StringBuilder str = new StringBuilder();
        for (Specialization s: specializations){
            str.append(s.getName());
            str.append(", ");
        }
        str.deleteCharAt(str.length()-1);
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }
}
