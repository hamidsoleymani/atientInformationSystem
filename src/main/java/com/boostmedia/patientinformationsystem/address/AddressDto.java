package com.boostmedia.patientinformationsystem.address;

import java.io.Serializable;

/**
 * DTO for {@link com.boostmedia.patientinformationsystem.entity.Address}
 */
public record AddressDto(Long id,
                         String country,
                         String city,
                         String street,
                         String zipCode,
                         String buildingNr,
                         Long medicalFacilityId) implements Serializable {
}
