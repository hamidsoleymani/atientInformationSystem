package com.boostmedia.patientinformationsystem.address;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String id) {
        super("The address with id: " + id + "was not found");
    }
}
