package com.boostmedia.patientinformationsystem.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AddressRepository extends CrudRepository<Address, Long> {
}
