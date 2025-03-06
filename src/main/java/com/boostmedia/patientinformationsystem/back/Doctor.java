package com.boostmedia.patientinformationsystem.back;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Doctor extends MedicalFacilityStaff {

    private DoctorType doctorType;
    @OneToMany
    private Set<Patient> patientSet;


}
