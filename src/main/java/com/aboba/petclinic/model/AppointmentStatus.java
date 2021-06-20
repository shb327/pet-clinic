package com.aboba.petclinic.model;

import lombok.*;

import javax.persistence.*;

/**
 * Simple JavaBean domain object representing a status for the appointment
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
public class AppointmentStatus extends Status {
    private String status;
}
