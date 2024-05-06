package com.bookticketPackage.repository;

import com.bookticketPackage.dto.PaymentInfoDto;
import com.bookticketPackage.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    @Query(value = "select * from ticket_booking.payment_info where card_number =:cardNumber and customer_id =:customerId", nativeQuery = true)
    Optional<PaymentInfo> findBycardNumberAndCustomerId(String cardNumber, long customerId);

    @Query(value = "select * from ticket_booking.payment_info where customer_id =:customerId", nativeQuery = true)
    List<PaymentInfo> listOfPaymentInfoByCustomerId(long customerId);
}
