package com.ecommerce.Ecommerce.DTO;

import com.ecommerce.Ecommerce.Model.Customer;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrdersRequestDTO
{

    @NotNull(message = "Enter the order Id")
    private int orderId;

    @NotNull(message = "Enter the customer Id")
    private int customerId;

    private Customer customer;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


}
