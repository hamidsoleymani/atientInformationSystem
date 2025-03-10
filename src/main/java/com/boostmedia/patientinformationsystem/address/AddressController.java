package com.boostmedia.patientinformationsystem.address;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/address")
@RestController
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public AddressDto save(@Valid @RequestBody AddressDto dto) {
        return this.service.toDto(this.service.save(dto));
    }

    @GetMapping("/{id}")
    public AddressDto get(@PathVariable Long id) {
        return this.service.getAddressById(id);
    }
}
