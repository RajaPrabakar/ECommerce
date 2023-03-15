package com.ecommerce.Ecommerce.Service;
import com.ecommerce.Ecommerce.DTO.LoginRequestDTO;
import com.ecommerce.Ecommerce.JPA.CustomerRepository;

import com.ecommerce.Ecommerce.JPA.LoginRepository;
import com.ecommerce.Ecommerce.Model.Customer;
import com.ecommerce.Ecommerce.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoginRepository loginRepository;

    public Object loginCustomer(LoginRequestDTO loginRequestDTO)
    {
        if(loginRequestDTO.getUserName()!=null && loginRequestDTO.getPassword()!=null)
        {
           List<Customer> customerList =customerRepository.findByUserNameAndPassword(loginRequestDTO.getUserName(), loginRequestDTO.getPassword());
            for(Customer customer:customerList)
            {
                Login login = new Login();
                login.setUserName(customer.getUserName());
                login.setPassword(customer.getPassword());
                login=loginRepository.save(login);
                if(login.getUserName().equals(loginRequestDTO.getUserName()) && login.getPassword().equals(loginRequestDTO.getPassword()))
                {
                    return "Login Successful go to product purchasing page";
                }
            }
        }
        return "Add your account first";
    }

}
