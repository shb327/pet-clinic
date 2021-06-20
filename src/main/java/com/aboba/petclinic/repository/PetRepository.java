package com.aboba.petclinic.repository;


import com.aboba.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class for <code>Pet</code> domain objects
 *
 * @author Bohdan Shkamarida
 */

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> { }
