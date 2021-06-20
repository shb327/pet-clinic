package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object representing a degree of the specialization
 *
 * @author Bohdan Shkamarida
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer complexity;

    @ManyToMany(mappedBy = "degrees")
    private List<Specialization> specializations;
}
