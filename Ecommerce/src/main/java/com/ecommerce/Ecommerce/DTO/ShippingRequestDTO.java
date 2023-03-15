package com.ecommerce.Ecommerce.DTO;

import javax.validation.constraints.NotBlank;

public class ShippingRequestDTO
{

    private String shippingAddress;

    @NotBlank(message = "Enter the shipping Status")
    private String status;

    private int ordersId;

    private int shippingId;

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
