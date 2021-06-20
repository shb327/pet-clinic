package com.aboba.petclinic.repository;

import com.aboba.petclinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class for <code>Appointment</code> domain objects
 *
 * @author Bohdan Shkamarida
 */

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{ }
