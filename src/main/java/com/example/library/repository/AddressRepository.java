package com.example.library.repository;

import com.example.library.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCity(String city);

    List<Address> findByState(String state);

    List<Address> findByCountry(String country);

    List<Address> findByPinCode(int pinCode);

    int deleteByCity(String city);

    int deleteByState(String state);

    int deleteByCountry(String country);

    int deleteByPinCode(int pinCode);
}
