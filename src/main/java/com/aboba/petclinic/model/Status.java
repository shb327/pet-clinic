package com.aboba.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Simple JavaBean domain object representing an abstract status
 *
 * @author Bohdan Shkamarida
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Status {
    protected Timestamp periodStart;
    protected Timestamp periodEnd;
}
