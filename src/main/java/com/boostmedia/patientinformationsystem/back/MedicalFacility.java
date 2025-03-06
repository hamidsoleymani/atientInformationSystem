package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class MedicalFacility {
    @Id
    private Long id;

    private String name;
    private MedicalFacilityType medicalFacilityType;
    @OneToOne
    private Address address;

    @OneToMany
    private Set<MedicalFacilityStaff> medicalFacilityStaffSet;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
