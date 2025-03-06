package com.boostmedia.patientinformationsystem.address;

import com.boostmedia.patientinformationsystem.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(Address address);
    Address toEntity(AddressDto dto);
}
