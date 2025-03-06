package com.boostmedia.patientinformationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address", schema = "medical_facility_information_system_schema")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "country", nullable = false, length = 20)
    private String country;

    @Column(name = "city", nullable = false, length = 20)
    private String city;

    @Column(name = "street", nullable = false, length = 20)
    private String street;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "building_nr", nullable = false, length = 5)
    private String buildingNr;

    private Long medicalFacilityId;

    public Long getMedicalFacilityId() {
        return medicalFacilityId;
    }

    public void setMedicalFacilityId(Long medicalFacilityId) {
        this.medicalFacilityId = medicalFacilityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getBuildingNr() {
        return buildingNr;
    }

    public void setBuildingNr(String buildingNr) {
        this.buildingNr = buildingNr;
    }

}
