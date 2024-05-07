package com.bookticketPackage.service;

import com.bookticketPackage.dto.PaymentInfoDto;
import com.bookticketPackage.mapper.PaymentInfoMapper;
import com.bookticketPackage.model.PaymentInfo;
import com.bookticketPackage.repository.PaymentInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentInfoService {
    private PaymentInfoRepository paymentInfoRepository;

    public PaymentInfoService(PaymentInfoRepository paymentInfoRepository){
        this.paymentInfoRepository = paymentInfoRepository;
    }

    //save paymentInfo
    public String save(PaymentInfoDto paymentInfoDto) {

        if(paymentInfoRepository.findBycardNumberAndCustomerId(paymentInfoDto.getCardNumber(),paymentInfoDto.getCustomerId()).isPresent()){
            return "paymentInfo already exist";
        }else{
            paymentInfoRepository.save(PaymentInfoMapper.paymentInfoDtoToPaymentInfo(paymentInfoDto));
            return "payment info saved";
        }
    }
    //returns all the payment info in the table
    public List<PaymentInfoDto> getAllPaymentInfo() {
        return paymentInfoRepository.findAll()
                .stream()
                .map(paymentInfo -> PaymentInfoMapper.paymentInfoToPaymentInfoDto(paymentInfo))
                .collect(Collectors.toList());
    }


    public String deletePaymentInfoById(long id) {
        if(paymentInfoRepository.existsById(id)){
            paymentInfoRepository.deleteById(id);
            return "deleted";
        }else {
            return "could not delete, id could not be located";
        }
    }


    public String updatePaymentInfoById(long id, PaymentInfoDto paymentInfoDto) {
        PaymentInfo paymentInfo = paymentInfoRepository.getById(id);
        if (paymentInfo != null) {
            if (Double.isNaN(paymentInfoDto.getPaymentInfoId())) {
                paymentInfo.setPaymentInfoId(paymentInfoDto.getPaymentInfoId());
            }
            if(paymentInfoDto.getPaymentType() != null){
                paymentInfo.setPaymentType(paymentInfoDto.getPaymentType());
            }
            if(paymentInfoDto.getCardNumber() != null){
                paymentInfo.setCardNumber(paymentInfoDto.getCardNumber());
            }
            paymentInfoRepository.save(paymentInfo);
                return "payment info is now updated";
        } else{
            return "paymentinfo could not be updated, payment info id not found";
        }


    }

    public String savePaymentInfos(List<PaymentInfoDto> paymentInfoDto) {
        List<PaymentInfo> paymentInfoList = paymentInfoDto.stream()
                .map(paymentInfoDto1 -> PaymentInfoMapper.paymentInfoDtoToPaymentInfo(paymentInfoDto1))
                .collect(Collectors.toList());

        paymentInfoRepository.saveAll(paymentInfoList);
        return "saved";
    }

    public List<PaymentInfoDto> listOfPaymentInfoByCustomerId(long customerId) {
        List<PaymentInfo> paymentInfoList = paymentInfoRepository.listOfPaymentInfoByCustomerId(customerId);
         return paymentInfoList.stream().map(paymentInfo -> PaymentInfoMapper.paymentInfoToPaymentInfoDto(paymentInfo)).collect(Collectors.toList());
    }

    public String deletePaymentInfoByCustomerIdAndCardNumber(long customerId, String cardNumber) {
        paymentInfoRepository.deletePaymentInfoByCustomerIdAndCardNumber(customerId, cardNumber);
        return "deleted";

    }
}
