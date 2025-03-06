package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class MedicalFacilityStaff {

    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private Sex sex;
    private JobType jobType;
    @OneToOne
    private Address address;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
