package com.aboba.petclinic.repository;

import com.aboba.petclinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository class for <code>User</code> domain objects
 *
 * @author Bohdan Shkamarida
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieve an {@link User} from the data stored by username.
     * @return the username if found
     */
    Optional<User> findByUsername(String username);
}
