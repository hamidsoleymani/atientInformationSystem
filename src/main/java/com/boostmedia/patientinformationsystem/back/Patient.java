package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Patient {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthday;

    @OneToOne
    private Address address;
    private Sex sex;

    @OneToMany
    private Set<Doctor> doctors;
    @OneToMany
    private Set<PatientIncidentFile> patientIncidentFilesSet;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
