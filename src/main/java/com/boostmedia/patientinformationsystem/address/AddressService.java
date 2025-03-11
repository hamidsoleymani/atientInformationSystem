package com.boostmedia.patientinformationsystem.address;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Address save(AddressDto dto) {
        Address entity = this.mapper.toEntity(dto);
        return this.repository.save(entity);
    }

    public AddressDto toDto(Address address) {
        return this.mapper.toDto(address);
    }

    public AddressDto getAddressById(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toDto)
                .orElseThrow(() -> new ResourceAccessException("Address not found with id: " + id));
    }
}
