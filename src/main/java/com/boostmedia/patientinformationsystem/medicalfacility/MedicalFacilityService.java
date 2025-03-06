package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.ResourceNotFoundException;
import com.boostmedia.patientinformationsystem.entity.MedicalFacility;
import org.springframework.stereotype.Service;

@Service
public class MedicalFacilityService {
    private final MedicalFacilityMapper medicalFacilityMapper;
    private final MedicalFacilityRepository repository;

    public MedicalFacilityService(MedicalFacilityRepository repository,
                                  MedicalFacilityMapper medicalFacilityMapper) {
        this.repository = repository;
        this.medicalFacilityMapper = medicalFacilityMapper;
    }

    public void save(MedicalFacilityDto dto) {
        MedicalFacility entity = this.medicalFacilityMapper.toEntity(dto);
        this.repository.save(entity);
    }

    public MedicalFacilityDto get(Long id) {
        return this.repository.findById(id)
                .map(this.medicalFacilityMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("MedicalFacility not found with id: " + id));
    }
}
