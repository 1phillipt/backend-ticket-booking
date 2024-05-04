package com.bookticketPackage.controller;

import com.bookticketPackage.dto.CustomerDto;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.service.CustomerService;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ToString
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(com.bookticketPackage.service.CustomerService customerService ){
        this.customerService = customerService;
    }

    //save customer info
    //http://localhost:8081/api/v1/customer
    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.save(customerDto));
    }
    //save customer infos
    //http://localhost:8081/api/v1/customer
    @PostMapping("/customers")
    public ResponseEntity<String> saveCustomers(@RequestBody List<CustomerDto> listOfCustomers) {
        return ResponseEntity.ok(customerService.saveCustomers(listOfCustomers));
    }

    //get customer by id
   // http://localhost:8081/api/v1/customer/
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> customerById(@PathVariable("id") long id){
        return ResponseEntity.ok(customerService.customerById(id));
    }
    // http://localhost:8081/api/v1/customer/?
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        return ResponseEntity.ok(customerService.deleteById(id));
    }

    // http://localhost:8081/api/v1/customer/?
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDto));
    }

}
