package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private Long id;

    @OneToOne(mappedBy = "address")
    private MedicalFacility medicalFacilities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String Country;
    private String city;
    private String street;
    private String zipCode;
    private String buildingNr;

    public MedicalFacility getMedicalFacilities() {
        return medicalFacilities;
    }

    public void setMedicalFacilities(MedicalFacility medicalFacilities) {
        this.medicalFacilities = medicalFacilities;
    }

}
