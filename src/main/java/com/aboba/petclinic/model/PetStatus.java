package com.aboba.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class PetStatus extends Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_status_id")
    private Long id;
    private Boolean underTreatment;

    @OneToMany(mappedBy = "petStatus", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Pet> pets;
}
