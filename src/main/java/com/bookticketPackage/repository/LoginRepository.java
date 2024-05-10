package com.bookticketPackage.repository;

import com.bookticketPackage.model.Login;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {

    @Query(value = "SELECT * FROM ticket_booking.login where email =:email", nativeQuery = true)
    Optional<Login> findByEmail(String email);


    @Transactional
    @Modifying
    @Query(value = "UPDATE ticket_booking.login SET password =:password, email =:email WHERE customer_id =:customerId", nativeQuery = true)
    void saveUpdatesByCustomerId(@Param("customerId") long customerId, @Param("email") String email, @Param("password") String password);


//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO login (email, password) " +
//            "SELECT c.email, c.password " +
//            "FROM Customer c " +
//            "WHERE c.email IS NOT NULL AND c.password IS NOT NULL")
//   public abstract void insertCustomerEmailPasswordToLogin();

}

