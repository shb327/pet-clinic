package com.aboba.petclinic.service;

import com.aboba.petclinic.model.Appointment;
import com.aboba.petclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean domain object representing a service for appointment
 *
 * @author Bohdan Shkamarida
 */

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    AppointmentRepository repository;

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }
}
