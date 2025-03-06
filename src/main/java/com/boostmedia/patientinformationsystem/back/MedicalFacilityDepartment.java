package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class MedicalFacilityDepartment {
    @Id
    private Long id;
    private String name;

    @OneToOne
    private Address address;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
