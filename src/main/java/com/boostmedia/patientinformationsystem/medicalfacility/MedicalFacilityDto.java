package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.entity.MedicalFacility;

import java.io.Serializable;

/**
 * DTO for {@link MedicalFacility}
 */
public record MedicalFacilityDto(Long id, String name) implements Serializable {
}
