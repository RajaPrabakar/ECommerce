package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.CartItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.CartRequestDTO;
import com.ecommerce.Ecommerce.Model.CartItem;
import com.ecommerce.Ecommerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class CartController
{
    @Autowired
    private CartService cartService;


    @PostMapping(value = "/create-cart")
    public ResponseEntity<Object> createCart(@Valid @RequestBody CartRequestDTO cartRequestDTO)
    {
        Object obj = cartService.postCart(cartRequestDTO);
        return ResponseEntity.ok(obj);
    }


    @PostMapping(value = "/create-cart-item")
    public ResponseEntity<Object> createCartItem(@Valid @RequestBody CartItemRequestDTO cartItemRequestDTO)
    {
        Object obj = cartService.postCartItem(cartItemRequestDTO);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/get-cart-items")
    public ResponseEntity<Object> getAllCartItems()
    {
        List<CartItem> cartItems=cartService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping(value ="/get-one-item/{id}")
    public ResponseEntity<Object> getOneCartItem(@Valid @PathVariable int id )
    {
        Object cartItem=cartService.getSingleCartItem(id);
        return ResponseEntity.ok(cartItem);
    }
}
