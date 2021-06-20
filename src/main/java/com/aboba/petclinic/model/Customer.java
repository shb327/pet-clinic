package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object representing a regular application customer.
 * This class is an instance of the class User.
 *
 * @author Bohdan Shkamarida
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer discount;

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerType customerType;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pet> pets;

    @OneToOne
    private User user;
}
