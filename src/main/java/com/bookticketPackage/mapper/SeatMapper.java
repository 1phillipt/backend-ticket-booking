package com.bookticketPackage.mapper;

import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.model.Event;
import com.bookticketPackage.model.Seat;

public class SeatMapper {

    public static SeatDto seatToSeatDto(Seat seat){
        return SeatDto.builder()
                .seatID(seat.getSeatId())
                .price(seat.getPrice())
                .seatNumber(seat.getSeatNumber())
                .available(seat.getAvailable())
                .eventId(seat.getEvent().getEventId())
                .build();
    }

    public static Seat seatDtoToSeat(SeatDto seatDto){
        return Seat.builder()
                .seatId(seatDto.getSeatID())
                .price(seatDto.getPrice())
                .seatNumber(seatDto.getSeatNumber())
                .available(seatDto.getAvailable())
                .event(Event.builder().eventId(seatDto.getEventId()).build())
                .build();
    }
}
