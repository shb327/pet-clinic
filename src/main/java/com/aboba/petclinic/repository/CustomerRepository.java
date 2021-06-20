package com.aboba.petclinic.repository;


import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class for <code>Customer</code> domain objects
 *
 * @author Bohdan Shkamarida
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUser(User user);


    /**
     * Retrieve an {@link Customer} from the data store by id.
     * @param userId the id to search for
     * @return the {@link Customer} if found
     */
    @Query("FROM Vet WHERE user.id = :userId")
    Optional<Customer> findByUserId(@Param("userId") Long userId);
}
