package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object representing a specialization of the veterinarian
 *
 * @author Bohdan Shkamarida
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer yearsToQualify;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "specialization_degree",
            joinColumns = {@JoinColumn(name = "specialization_id")},
            inverseJoinColumns = {@JoinColumn(name = "degree_id")})
    private List<Degree> degrees;

    @ManyToMany(mappedBy = "specializations")
    private List<Vet> vets;
}
