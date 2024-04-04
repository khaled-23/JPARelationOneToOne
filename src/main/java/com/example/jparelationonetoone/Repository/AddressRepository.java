package com.example.jparelationonetoone.Repository;

import com.example.jparelationonetoone.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findAddressByTeacher_id(Integer teacher_id);
}
