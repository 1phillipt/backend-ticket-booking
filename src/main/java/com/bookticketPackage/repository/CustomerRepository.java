package com.bookticketPackage.repository;

import com.bookticketPackage.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


    @Query(value = "select * from customer where email =:email or phone_number =:phoneNumber", nativeQuery = true)
    Optional<Customer> findByEmailOrPhone(String email, String phoneNumber);
}
