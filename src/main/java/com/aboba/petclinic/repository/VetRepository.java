package com.aboba.petclinic.repository;

import com.aboba.petclinic.model.Customer;
import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class for <code>Vet</code> domain objects
 *
 * @author Bohdan Shkamarida
 */

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

    /**
     * Retrieve an {@link Vet} from the data stored by username.
     * @return the username if found
     */

    Optional<Vet> findByUser(User user);

    /**
     * Retrieve an {@link Vet} from the data store by id.
     * @param userId the id to search for
     * @return the {@link Vet} if found
     */
    @Query("FROM Vet WHERE user.id = :userId")
    Optional<Vet> findByUserId(@Param("userId") Long userId);
}
