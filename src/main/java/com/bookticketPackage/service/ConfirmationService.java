package com.bookticketPackage.service;

import com.bookticketPackage.dto.ConfirmationDto;
import com.bookticketPackage.mapper.ConfirmationMapper;
import com.bookticketPackage.model.Confirmation;
import org.springframework.stereotype.Service;
import com.bookticketPackage.repository.ConfirmationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConfirmationService {
    private final ConfirmationRepository confirmationRepository;

    public ConfirmationService(ConfirmationRepository confirmationRepository){
        this.confirmationRepository = confirmationRepository;
    }

    //save confirmation
   public String save(ConfirmationDto confirmationDto){
    if(confirmationRepository.existsById(confirmationDto.getConfirmationId())){
        return "user already Exist";
    }else{
        confirmationRepository.save(ConfirmationMapper.confirmationDtoToConfirmation(confirmationDto));
        return "confirmation saved";
        }
    }

    public List<ConfirmationDto> getAllConfirmation() {
        return confirmationRepository.findAll()
                .stream()
                .map(confirmation -> ConfirmationMapper.confirmationToConfirmationDto(confirmation))
                .collect(Collectors.toList());
    }

    public ConfirmationDto getConfirmationByConfirmationId(long confirmationId) {
        Confirmation confirmationById = confirmationRepository.getById(confirmationId);

        if(confirmationById != null) {
            return ConfirmationMapper.confirmationToConfirmationDto(confirmationById);
        }else{
            throw new RuntimeException( confirmationById + "not found");
        }
    }

//    public Object[] collectConfirmationInfo(long confirmationId) {
//        return confirmationRepository.collectConfirmationInfo(confirmationId);
//    }


    //delete confirmation by id

    public String deleteConfirmationById(long confirmationid) {
        if(confirmationRepository.existsById(confirmationid)){
            confirmationRepository.deleteById(confirmationid);
            return "confirmation deleted";
        }else {
            return confirmationid + " id not found";
        }
    }
//    private long confirmationId;
//    private Date confirmationDate;
//    private String methodOfPayment;
//    private String confirmationCode;
//    private long customerId;

}
