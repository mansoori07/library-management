package com.example.library.repository;

import com.example.library.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface IAddressRepository extends JpaRepository<Address, Long> {

    Optional<List<Address>> findByCity(String city);

    Optional<List<Address>> findByState(String state);

    Optional<List<Address>> findByCountry(String country);

    Optional<List<Address>> findByPinCode(int pinCode);

}
