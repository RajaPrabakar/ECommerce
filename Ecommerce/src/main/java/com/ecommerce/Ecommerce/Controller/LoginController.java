package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.LoginRequestDTO;
import com.ecommerce.Ecommerce.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Validated
@RestController
public class LoginController
{
   @Autowired
   private LoginService loginService;

   @PostMapping(value = "/create-login")
    public ResponseEntity<Object> postLoginCustomer(@Valid @RequestBody LoginRequestDTO loginRequestDTO)
   {
       Object login = loginService.loginCustomer(loginRequestDTO);
       return ResponseEntity.ok(login);
   }


}
