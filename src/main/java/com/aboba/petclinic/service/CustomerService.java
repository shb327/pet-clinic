package com.aboba.petclinic.service;

import com.aboba.petclinic.DTOs.VetDTO;
import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import com.aboba.petclinic.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple JavaBean domain object representing a service for customer
 *
 * @author Bohdan Shkamarida
 */

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    UserService userService;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCurrentCustomer() {
        User user = userService.getCurrentUser();
        return customerRepository.findByUser(user)
                .orElseThrow(() -> new AccessDeniedException("Looks like, user is not a customer!"));
    }

    public List<Customer> getAllCustomers(){
        return new ArrayList<>(customerRepository.findAll());
    }

    @Transactional
    public void registerNewPet(Pet pet) {
        getCurrentCustomer().getPets().add(pet);
    }
}
