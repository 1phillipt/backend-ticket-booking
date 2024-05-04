package com.bookticketPackage.repository;

import com.bookticketPackage.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {

        @Query(value = "select cu.fname, cu.lname, cu.gets_discount, p.payment_type, s.seat_id as seats " +
                "from Customer cu " +
                "join Confirmation c on cu.customer_id = c.customer_id " +
                "join Ticket t on c.ticket_id = t.ticket_id " +
                "join Seat s on t.ticket_id = s.ticket_id " +
                "join Payment_info p on p.customer_id = cu.customer_id " +
                "where c.confirmation_id = :confirmationId", nativeQuery = true)
        Object[] collectConfirmationInfo(long confirmationId);
    }


