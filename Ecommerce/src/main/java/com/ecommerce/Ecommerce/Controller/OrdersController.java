package com.ecommerce.Ecommerce.Controller;

import com.ecommerce.Ecommerce.DTO.OrderItemRequestDTO;
import com.ecommerce.Ecommerce.DTO.OrdersRequestDTO;
import com.ecommerce.Ecommerce.DTO.ShippingRequestDTO;
import com.ecommerce.Ecommerce.Model.OrderItem;
import com.ecommerce.Ecommerce.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
public class OrdersController
{
    @Autowired
    private OrdersService ordersService;


    @PostMapping(value = "/place-order")
    public ResponseEntity<Object> createOrder(@Valid @RequestBody OrdersRequestDTO ordersRequestDTO)
    {
        Object obj = ordersService.placeOrder(ordersRequestDTO);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(value = "/get-all-orderItems")
    public ResponseEntity<Object> getAllOrderItem()
    {
        List<OrderItem> orderItems=ordersService.getAllOrderItem();
        return ResponseEntity.ok(orderItems);
    }
    @PostMapping(value = "/get-0ne-orderItem/{id}")
    public ResponseEntity<Object> getOneOrderItem(@Valid @PathVariable int id)
    {
        Object obj = ordersService.getSingleOrder(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping(value = "/create-shipment")
    public ResponseEntity<Object> postShipment(@Valid @RequestBody ShippingRequestDTO shippingRequestDTO)
    {
        Object obj = ordersService.createShipping(shippingRequestDTO);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(value = "/update-shipment-status")
    public ResponseEntity<Object> putShipmentStatus(@Valid @RequestBody ShippingRequestDTO shippingRequestDTO)
    {
        Object obj = ordersService.updateShippingStatus(shippingRequestDTO);
        return ResponseEntity.ok(obj);
    }
}
