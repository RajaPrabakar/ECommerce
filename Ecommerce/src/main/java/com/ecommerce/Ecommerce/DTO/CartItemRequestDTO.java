package com.ecommerce.Ecommerce.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartItemRequestDTO
{

    @NotNull(message = "Enter the cart Id")
    private int cartId;

    @NotNull(message = "Enter the customer Id")
    private int customerId;

    @NotNull(message = "Enter the Product Id")
    private int productId;

    @NotNull(message = "Enter the CartItem Quantity")
    private int cartItemQuantity;

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
