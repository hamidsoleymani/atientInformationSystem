package com.boostmedia.patientinformationsystem.address;

import com.boostmedia.patientinformationsystem.entity.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository respository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository respository, AddressMapper mapper) {
        this.respository = respository;
        this.mapper = mapper;
    }

    public AddressDto save(AddressDto dto) {
        Address address = this.respository.save(this.mapper.toEntity(dto));
        return this.mapper.toDto(address);
    }
}
