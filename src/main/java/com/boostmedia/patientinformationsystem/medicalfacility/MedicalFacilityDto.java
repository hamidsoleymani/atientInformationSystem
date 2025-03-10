package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.address.AddressDto;

import java.io.Serializable;

/**
 * DTO for {@link MedicalFacility}
 */
public record MedicalFacilityDto(Long id, String name, AddressDto addressDto) implements Serializable {
}
