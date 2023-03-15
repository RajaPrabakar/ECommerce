package com.ecommerce.Ecommerce.DTO;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class CustomerRequestDTO
{

    private int customerId;

    @NotBlank(message = "Enter the First name")
    private String firstName;

    @NotBlank(message = "Enter the Last name")
    private String lastName;

    @NotBlank(message = "Enter the Username")
    private String userName;

    @NotBlank(message = "Enter the  Password")
    private String password;

    @NotBlank(message = "Enter the Gender")
    private String gender;

    @Range(min = 1000,max = 1000000000)
    private long mobileNumber;

    @NotBlank(message = "Enter the EmailId")
    @Email
    private String emailId;

    @NotBlank(message = "Enter the Address")
    private String address;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
