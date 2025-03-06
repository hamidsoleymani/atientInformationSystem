package com.boostmedia.patientinformationsystem.medicalfacility;


import com.boostmedia.patientinformationsystem.entity.MedicalFacility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalFacilityMapper {
    MedicalFacilityDto toDto(MedicalFacility medicalFacility);
    MedicalFacility toEntity(MedicalFacilityDto dto);
}
