package com.boostmedia.patientinformationsystem.address;

import com.boostmedia.patientinformationsystem.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AddressRepository extends CrudRepository<Address, Long> {
}
