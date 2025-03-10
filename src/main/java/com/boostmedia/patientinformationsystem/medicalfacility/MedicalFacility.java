package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.address.Address;
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

    @OneToOne
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
