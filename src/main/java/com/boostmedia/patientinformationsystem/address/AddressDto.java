package com.boostmedia.patientinformationsystem.address;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link Address}
 */
public record AddressDto(Long id,
                         String country,
                         String city,
                         String street,
                         @NotBlank(message="The zip code must be defined")
                         String zipCode,
                         String buildingNr) implements Serializable {
}
