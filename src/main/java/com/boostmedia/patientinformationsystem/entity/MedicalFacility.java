package com.boostmedia.patientinformationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_facility", schema = "medical_facility_information_system_schema")
public class MedicalFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medical_facility_seq")
    @SequenceGenerator(name = "medical_facility_seq", sequenceName = "medical_facility_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
