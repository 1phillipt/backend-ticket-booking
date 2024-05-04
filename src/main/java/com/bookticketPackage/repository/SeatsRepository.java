package com.bookticketPackage.repository;

import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.model.Seat;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seat,Long> {

    @Query(value = "select isAvailable from Seat where seatId =:id", nativeQuery = true)
    public Boolean isSeatAvailable (long id);


    @Query(value = "select * from Seat where available != 1" ,nativeQuery = true)
    public List<Seat> getAllAvailableSeats();


    @Query(value = "select * from Seat where available = 1 and event_id =:id" ,nativeQuery = true)
    public List<Seat> getAllSeatsByEventId(long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Seat s WHERE s.seatNumber = :seatNumber")
    public void deleteBySeatNumber(@Param("seatNumber") String seatNumber);


}
