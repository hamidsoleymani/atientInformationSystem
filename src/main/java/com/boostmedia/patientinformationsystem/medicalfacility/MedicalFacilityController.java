package com.boostmedia.patientinformationsystem.medicalfacility;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-facilities")
public class MedicalFacilityController {

    private final MedicalFacilityService service;

    public MedicalFacilityController(MedicalFacilityService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void createMedicalFacility(@RequestBody MedicalFacilityDto dto){
        this.service.save(dto);

    }

    @GetMapping("/by-id/{id}")
    public MedicalFacilityDto getMedicalFacility(@PathVariable Long id){
       return this.service.get(id);
    }
}
