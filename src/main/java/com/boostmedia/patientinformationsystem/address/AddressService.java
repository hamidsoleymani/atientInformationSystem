package com.boostmedia.patientinformationsystem.address;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class AddressService {
    private final AddressRepository respository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        this.respository = repository;
        this.mapper = mapper;
    }

    public Address save(AddressDto dto) {
        Address entity = this.mapper.toEntity(dto);
        Address address = this.respository.save(entity);
        return address;
    }

    public AddressDto toDto(Address address) {
        AddressDto entityDto = this.mapper.toDto(address);
        return entityDto;
    }

    public AddressDto getAddressById(Long id) {
        return this.respository.findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ResourceAccessException("Address not found with id: " + id));
    }
}
