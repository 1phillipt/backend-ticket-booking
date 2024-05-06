package com.bookticketPackage.controller;

import com.bookticketPackage.dto.PaymentInfoDto;
import com.bookticketPackage.service.PaymentInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/paymentinfo")
public class PaymentInfoController {
    private PaymentInfoService paymentInfoService;

    public PaymentInfoController(PaymentInfoService paymentInfoService){
        this.paymentInfoService = paymentInfoService;
    }
    //Saves the payment info
    @PostMapping
    public ResponseEntity<String> save(@RequestBody PaymentInfoDto paymentInfoDto){

        return ResponseEntity.ok().body(paymentInfoService.save(paymentInfoDto));

    }
    @PostMapping("/paymentinfos")
    public ResponseEntity<String> saveaPaymentInfos(@RequestBody List<PaymentInfoDto> paymentInfoDto){
        return ResponseEntity.ok().body(paymentInfoService.savePaymentInfos(paymentInfoDto));
    }

    @GetMapping
    public ResponseEntity<List<PaymentInfoDto>>  getAllPaymentInfo(){
        return ResponseEntity.ok().body(paymentInfoService.getAllPaymentInfo());
    }

    //get payment info by customer Id
    @GetMapping("/{customerId}")
    public ResponseEntity<List<PaymentInfoDto>> listOfPaymentInfoByCustomerId(@PathVariable("customerId") long cusId){
        //System.out.println(paymentInfoService.listOfPaymentInfoByCustomerId(customerId));
        return ResponseEntity.ok().body(paymentInfoService.listOfPaymentInfoByCustomerId(cusId));
    }

    //delete payment info by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaymentInfoById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(paymentInfoService.deletePaymentInfoById(id));
    }

    //updatest the paymentinfo

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePaymentInfoById(@PathVariable("id") long id, @RequestBody PaymentInfoDto paymentInfoDto){
        return ResponseEntity.ok().body(paymentInfoService.updatePaymentInfoById(id, paymentInfoDto));
    }

}
