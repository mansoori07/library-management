package com.example.library.repository;

import com.example.library.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final IAddressRepository addressRepository;

    //retrieve operation started
    public Address findById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not Found"));
    }

    public List<Address> findByCity(String city){
        return addressRepository.findByCity(city)
                .orElseThrow(() -> new RuntimeException("Address not found for city : "+city));
    }

    public List<Address> findByState(String state){
        return addressRepository.findByState(state)
                .orElseThrow(() -> new RuntimeException("Address not found for state : "+state));
    }

    public List<Address> findByCountry(String country){
        return addressRepository.findByCountry(country)
                .orElseThrow(() -> new RuntimeException("Address not found for country : "+country));
    }

    public List<Address> findByPinCode(int pinCode){
        return addressRepository.findByPinCode(pinCode)
                .orElseThrow(() -> new RuntimeException("Address not found for pinCode : "+pinCode));
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }
    //retrieve operation ended

    //save operation started
    public Address save(Address address){
        return addressRepository.save(address);
    }

    public List<Address> saveAll(List<Address> address){
        return addressRepository.saveAll(address);
    }
    //save operation ended

    //delete operation started
    public int deleteById(Long id){
        return addressRepository.findById(id).map(
                address -> {
                    addressRepository.delete(address);
                    return 1;
                }).orElse(0);
    }

    public int deleteByCity(String city){
        List<Address> address = findByCity(city);

        if(address.isEmpty())
            return 0;

        addressRepository.deleteAll(address);
        return address.size();
    }

    public int deleteByState(String state){
        List<Address> address = findByState(state);
        if(address.isEmpty())
            return 0;

        addressRepository.deleteAll(address);
        return address.size();
    }

    public int deleteByCountry(String country){
        List<Address> address = findByCountry(country);
        if(address.isEmpty())
            return 0;

        addressRepository.deleteAll(address);
        return address.size();
    }

    public int deleteByPinCode(int pinCode){
        List<Address> address = findByPinCode(pinCode);
        if(address.isEmpty())
            return 0;

        addressRepository.deleteAll(address);
        return address.size();
    }
    //delete operation ended
}
