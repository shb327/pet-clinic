package com.aboba.petclinic.repository;


import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUser(User user);

    @Query("FROM Vet WHERE user.id = :userId")
    Optional<Customer> findByUserId(@Param("userId") Long userId);
}
