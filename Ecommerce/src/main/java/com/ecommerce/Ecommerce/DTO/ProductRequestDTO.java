package com.ecommerce.Ecommerce.DTO;

import javax.validation.constraints.*;

public class ProductRequestDTO
{

    private int productId;

    @NotBlank(message = "Enter the Product name")
    private String productName;

    @NotBlank(message = "Enter the Product specification")
    private String productSpecification;


    @DecimalMax(value = "100000.00",message = "maximum value is 100000.00")
    @DecimalMin(value = "10.00",message = "minimum value is 10.00")
    private double productPrice;

    @Max(value = 100,message = "maximum discount is 100")
    @Min(value = 1)
    private int productDiscount;

    @Max(value = 100)
    @Min(value = 1)
    private int productAvailableQuantity;

    public int getProductAvailableQuantity() {
        return productAvailableQuantity;
    }

    public void setProductAvailableQuantity(int productAvailableQuantity) {
        this.productAvailableQuantity = productAvailableQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }
}
