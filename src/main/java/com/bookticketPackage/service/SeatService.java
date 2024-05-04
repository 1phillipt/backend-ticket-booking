package com.bookticketPackage.service;


import com.bookticketPackage.dto.SeatDto;
import com.bookticketPackage.mapper.SeatMapper;
import com.bookticketPackage.model.Seat;
import com.bookticketPackage.repository.SeatsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatService {

    private SeatsRepository seatsRepository;

    public SeatService(SeatsRepository seatsRepository){
        this.seatsRepository = seatsRepository;
    }

    public String save(SeatDto seatDto) {
        if(seatsRepository.existsById(seatDto.getSeatID())){
            return "seat already exist";
        } else {
            seatsRepository.save(SeatMapper.seatDtoToSeat(seatDto));
            return "saved";
        }
    }

    public List<SeatDto> getAllSeats() {
        return seatsRepository.findAll().stream().map(Seat -> SeatMapper.seatToSeatDto(Seat)).collect(Collectors.toList());
    }


    public SeatDto seatById(long id) {
        Optional<Seat> seatOptional = seatsRepository.findById(id);

        if(seatOptional.isPresent()){
            return SeatMapper.seatToSeatDto(seatOptional.get());
        }else {
            throw new RuntimeException("seat not found");
        }
    }
    //returns seatAvailableById
    public Boolean isSeatAvailable( long id) {
        Optional<Seat> seatOptional = seatsRepository.findById(id);

        if(seatOptional.isPresent()){
            return seatsRepository.isSeatAvailable(id);
        }else{
            return false;
        }
    }
    //returns seatsAvailable
    public List<SeatDto> getAllAvailableSeats() {
        return seatsRepository.getAllAvailableSeats().stream().map(seat -> SeatMapper.seatToSeatDto(seat)).collect(Collectors.toList());
    }

    public String deleteSeatById(long id) {
        if(seatsRepository.existsById(id)){
            seatsRepository.deleteById(id);
            return "seat deleted";
        }{
            return "seatid not available";
        }
    }
    public String deleteSeatBySeatNumber(String seatNumber) {

        seatsRepository.deleteBySeatNumber(seatNumber);
        return "seat deleted";
    }

    public String saveSeats(List<SeatDto> seatDto) {
        List<Seat> listOfSeats = seatDto.stream().map(seatDto1->SeatMapper.seatDtoToSeat(seatDto1)).collect(Collectors.toList());
        seatsRepository.saveAll(listOfSeats);
        return "saved";
    }

    public List<SeatDto> getAllSeatsByEventId(Long eventId) {
        return seatsRepository.getAllSeatsByEventId(eventId).stream().map(seat -> SeatMapper.seatToSeatDto(seat)).collect(Collectors.toList());

    }
}
