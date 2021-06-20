package com.aboba.petclinic.service;

import com.aboba.petclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    AppointmentRepository repository;
}
