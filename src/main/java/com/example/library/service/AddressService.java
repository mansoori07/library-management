package com.example.library.service;

import com.example.library.model.Address;
import com.example.library.repository.AddressRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address findById(Long id){
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> findByCity(String city){
        return addressRepository.findByCity(city);
    }

    public List<Address> findByState(String state){
        return addressRepository.findByState(state);
    }

    public List<Address> findByCountry(String country){
        return addressRepository.findByCountry(country);
    }

    public List<Address> findByPinCode(int pinCode){
        return addressRepository.findByPinCode(pinCode);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public List<Address> saveAll(List<Address> address){
        return addressRepository.saveAll(address);
    }

    public int deleteById(Long id){
        Address address = addressRepository.findById(id).orElse(null);
        if(address == null) {
            throw new RuntimeException("Address not Found");
        }
        addressRepository.deleteById(id);
        return 1;
    }

    public int deleteByCity(String city){
        return addressRepository.deleteByCity(city);
    }

    public int deleteByState(String state){
        return addressRepository.deleteByState(state);
    }

    public int deleteByCountry(String country){
        return addressRepository.deleteByCountry(country);
    }

    public int deleteByPinCode(int pinCode){
        return addressRepository.deleteByPinCode(pinCode);
    }

}
