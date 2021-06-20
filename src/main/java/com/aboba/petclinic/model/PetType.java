package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Simple JavaBean domain object representing a type of the pet (Dog/Cat/Bird/...)
 *
 * @author Bohdan Shkamarida
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer averageLifeSpan;
}
