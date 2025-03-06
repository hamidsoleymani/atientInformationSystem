package com.boostmedia.patientinformationsystem.medicalfacility;

import com.boostmedia.patientinformationsystem.entity.MedicalFacility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalFacilityRepository extends CrudRepository<MedicalFacility, Long> {
}
