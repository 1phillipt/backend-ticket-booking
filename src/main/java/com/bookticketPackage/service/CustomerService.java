package com.bookticketPackage.service;

import com.bookticketPackage.dto.CustomerDto;
import com.bookticketPackage.mapper.CustomerMapper;
import com.bookticketPackage.model.Customer;
import com.bookticketPackage.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //saves new customer
    public String save(CustomerDto customerDto) {
       Optional<Customer> customerOptional = customerRepository.findByEmailOrPhone(customerDto.getEmail(),customerDto.getPhoneNumber());
       if(customerOptional.isPresent()){
           return "user already exist";
       }else {
           customerRepository.save(CustomerMapper.customerDtoToCustomer(customerDto));
           return "User create";
       }

    }

    //returns customer by id
    public CustomerDto customerById(long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if (customerOptional.isPresent()) {
            return CustomerMapper.customerToCustomerDto(customerOptional.get());
        } else {
            throw new RuntimeException("cannot find the userId " + id);
        }
    }

    //deletes customer by id
    public String  deleteById(long id) {
        Optional<Customer> findByid = customerRepository.findById(id);
            if (findByid.isPresent()) {
                customerRepository.deleteById(id);
                return "customer deleted";
            } else {
                return "customer not found";
        }
    }
    // captures update made in customer
    public String updateCustomer(long customerId, CustomerDto customerDto) {
        Customer customerInfo = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("user not found"));

        customerInfo.setFname(customerDto.getFname() != null? customerDto.getFname() : customerInfo.getFname());
        customerInfo.setLname(customerDto.getLname() != null? customerDto.getLname() : customerInfo.getLname());
        customerInfo.setEmail(customerDto.getEmail() != null? customerDto.getEmail() : customerInfo.getEmail());
        customerInfo.setPassword(customerDto.getPassword() != null? customerDto.getPassword():customerInfo.getPassword());

        customerRepository.save(customerInfo);

        return "infomation are updated";
    }

    public String saveCustomers(List<CustomerDto> listOfCustomers) {
        List<Customer> customerList = listOfCustomers.stream().map(Customer-> CustomerMapper.customerDtoToCustomer(Customer)).collect(Collectors.toList());
        customerRepository.saveAll(customerList);
        return "saved";
    }
}
