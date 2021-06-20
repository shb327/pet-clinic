package com.aboba.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object representing a status for the pet
 * Instance of the class status
 *
 * @author Bohdan Shkamarida
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class PetStatus extends Status {
    private Boolean underTreatment;
}
