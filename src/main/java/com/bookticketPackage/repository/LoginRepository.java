package com.bookticketPackage.repository;

import com.bookticketPackage.model.Login;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {

//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO login (email, password) " +
//            "SELECT c.email, c.password " +
//            "FROM Customer c " +
//            "WHERE c.email IS NOT NULL AND c.password IS NOT NULL")
//   public abstract void insertCustomerEmailPasswordToLogin();

}

