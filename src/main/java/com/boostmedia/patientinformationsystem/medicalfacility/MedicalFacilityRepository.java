package com.boostmedia.patientinformationsystem.medicalfacility;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalFacilityRepository extends CrudRepository<MedicalFacility, Long> {
}
