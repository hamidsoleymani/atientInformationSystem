package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class PatientIncidentFile {
    @Id
    private Long id;

    private LocalDateTime incidentTime;
    @OneToOne
    private Address incidentLocation;
    private String personsInvolved;
    private String incidentDescription;
    private String incidentInvoleved;
    private boolean policeInformed;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
