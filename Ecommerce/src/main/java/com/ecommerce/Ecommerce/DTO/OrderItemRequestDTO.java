package com.ecommerce.Ecommerce.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderItemRequestDTO
{
    @NotNull(message = "Enter the order Id")
    private int orderItemId;

    @NotNull(message = "Enter the customer Id")
    private int customerId;

    @NotNull(message = "Enter the orders Id")
    private int ordersId;

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
