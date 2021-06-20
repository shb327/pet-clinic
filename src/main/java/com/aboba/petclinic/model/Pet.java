package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object representing a pet
 *
 * @author Bohdan Shkamarida
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Integer weight;

    @OneToOne(cascade = CascadeType.ALL)
    private PetType petType;

    @Embedded
    private PetStatus petStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Appointment> appointments;
}
