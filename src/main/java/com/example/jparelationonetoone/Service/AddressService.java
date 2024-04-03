package com.example.jparelationonetoone.Service;

import com.example.jparelationonetoone.Api.ApiException;
import com.example.jparelationonetoone.DTO.AddressDTO;
import com.example.jparelationonetoone.Model.Address;
import com.example.jparelationonetoone.Model.Teacher;
import com.example.jparelationonetoone.Repository.AddressRepository;
import com.example.jparelationonetoone.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("teacher does not exists");
        }
        Address address = new Address(null, addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public void updateAddress(AddressDTO addressDTO){
        Address address = addressRepository.findAddressByTeacher_id(addressDTO.getTeacher_id());
        if(address==null){
            throw new ApiException("address does not exists");
        }
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void removeAddress(Integer address_id){
        Address address = addressRepository.findAddressByTeacher_id(address_id);
        if(address == null){
            throw new ApiException("address does npt exists");
        }
        addressRepository.delete(address);
    }
}
