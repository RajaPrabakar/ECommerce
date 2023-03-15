package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.CustomerRequestDTO;
import com.ecommerce.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Validated
@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;



    @PostMapping(value = "/create-customer")
    public ResponseEntity<Object> createCustomers(@Valid @RequestBody CustomerRequestDTO customerRequestDTO)
    {
        Object customer = customerService.postCustomer(customerRequestDTO);
        return ResponseEntity.ok(customer);
    }


    @GetMapping(value = "/get-customer-firstName")
    public ResponseEntity<Object> getCustomerFirstName(@RequestBody CustomerRequestDTO customerRequestDTO)
    {
        Object obj = customerService.getFirstName(customerRequestDTO);
        return ResponseEntity.ok(obj);
    }
}
