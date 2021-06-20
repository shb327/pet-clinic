package com.aboba.petclinic.repository;

import com.aboba.petclinic.model.User;
import com.aboba.petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    Optional<Vet> findByUser(User user);
    @Query("FROM Vet WHERE user.id = :userId")
    Optional<Vet> findByUserId(@Param("userId") Long userId);
}
