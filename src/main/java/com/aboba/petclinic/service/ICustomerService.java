package com.aboba.petclinic.service;

import com.aboba.petclinic.model.Customer;

/**
 * Simple JavaBean domain interface representing a service for customer
 *
 * @author Bohdan Shkamarida
 */

public interface ICustomerService {

    Customer getCurrentCustomer();
}
