package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.ResourceNotFoundException;
import com.boostmedia.patientinformationsystem.address.Address;
import com.boostmedia.patientinformationsystem.address.AddressDto;
import com.boostmedia.patientinformationsystem.address.AddressMapper;
import com.boostmedia.patientinformationsystem.address.AddressService;
import org.springframework.stereotype.Service;

@Service
public class MedicalFacilityService {
    private final MedicalFacilityMapper medicalFacilityMapper;
    private final MedicalFacilityRepository repository;
    private final AddressService addressService;

    public MedicalFacilityService(MedicalFacilityMapper medicalFacilityMapper,
                                  MedicalFacilityRepository repository,
                                  AddressService addressService) {
        this.medicalFacilityMapper = medicalFacilityMapper;
        this.repository = repository;
        this.addressService = addressService;
    }

    public void save(MedicalFacilityDto dto) {
        MedicalFacility entity = this.medicalFacilityMapper.toEntity(dto);
        Address address = this.addressService.save(dto.addressDto());
        entity.setAddress(address);
        this.repository.save(entity);
    }

    public MedicalFacilityDto get(Long id) {
        return this.repository.findById(id)
                .map(this.medicalFacilityMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalFacility not found with id: " + id));
    }
}
