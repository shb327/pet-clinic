package com.aboba.petclinic.service;

import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.model.Pet;
import com.aboba.petclinic.model.User;
import com.aboba.petclinic.repository.CustomerRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final UserService userService;
    private final CustomerRepository customerRepository;

    public CustomerService(UserService userService, CustomerRepository customerRepository) {
        this.userService = userService;
        this.customerRepository = customerRepository;
    }

    public Customer getCurrentCustomer() {
        User user = userService.getCurrentUser();
        return customerRepository.findByUser(user).orElseThrow(() -> new AccessDeniedException("user is not a customer"));
    }

    @Transactional
    public void registerNewPet(Pet pet) {
        getCurrentCustomer().getPets().add(pet);
    }
}
