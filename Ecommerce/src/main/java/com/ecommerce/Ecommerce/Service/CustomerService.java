package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.CustomerRequestDTO;
import com.ecommerce.Ecommerce.JPA.CustomerRepository;
import com.ecommerce.Ecommerce.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    Map<String,String> mp = new HashMap<>();

    public Object postCustomer(CustomerRequestDTO customerRequestDTO)
    {
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setUserName(customerRequestDTO.getUserName());
        customer.setPassword(customerRequestDTO.getPassword());
        customer.setGender(customerRequestDTO.getGender());
        customer.setMobileNumber(customerRequestDTO.getMobileNumber());
        customer.setEmailId(customerRequestDTO.getEmailId());
        customer.setAddress(customerRequestDTO.getAddress());
        customer=customerRepository.save(customer);
        mp.put("Message:","Customer added");
        return mp;
    }

public Object getFirstName(CustomerRequestDTO customerRequestDTO)
{
    List<Object[]> customer=customerRepository.getFirstNameAndLastNameByCustomerId(customerRequestDTO.getCustomerId());

    return customer;

}







}
