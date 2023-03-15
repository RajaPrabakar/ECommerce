package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.OrdersRequestDTO;
import com.ecommerce.Ecommerce.DTO.ShippingRequestDTO;
import com.ecommerce.Ecommerce.JPA.*;
import com.ecommerce.Ecommerce.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ShippingRepository shippingRepository;


    public Object placeOrder(OrdersRequestDTO ordersRequestDTO) {
        Map<String, String> mp = new HashMap<>();
        List<CartItem> cartItemList = cartItemRepository.findByCustomer_CustomerId(ordersRequestDTO.getCustomerId());

        double overallTotal = 0.0;

        for (CartItem cartItem : cartItemList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(cartItem.getProduct().getProductName());
            orderItem.setPrice(cartItem.getProduct().getProductPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotal(cartItem.getItemPrice());
            orderItem = orderItemRepository.save(orderItem);
            Product product = productRepository.findById(cartItem.getCartId()).orElse(null);
            if (product.getProductAvailableQuantity() >= 0)
            {
                product.setProductAvailableQuantity(product.getProductAvailableQuantity() - orderItem.getQuantity());
            } else
            {
                return "not enough stocks";
            }
            overallTotal = overallTotal + orderItem.getTotal();
            productRepository.save(product);
        }
        Orders orders = new Orders();
        orders.setStatus("Ordered");
        orders.setExpectedDate(orders.getExpectedDate());
        orders.setOverallTotal(overallTotal);
        orders = ordersRepository.save(orders);
        mp.put("Message:","Order completed");
        return mp;
    }
    public List<OrderItem> getAllOrderItem()
    {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems;
    }
    public Object getSingleOrder(int id)
    {
      OrderItem orderItem=orderItemRepository.findById(id).orElse(null);
      return orderItem;
    }

    public Object createShipping(ShippingRequestDTO shippingRequestDTO)
    {
        Map<String, String> mp = new HashMap<>();
        Orders orders=ordersRepository.findById(shippingRequestDTO.getOrdersId()).orElse(null);
        Shipping shipping=new Shipping();
        shipping.setShippingAddress(shippingRequestDTO.getShippingAddress());
        shipping.setStatus(shippingRequestDTO.getStatus());
        shipping.setOrders(orders);
        shipping=shippingRepository.save(shipping);
        mp.put("Message","Shipment done");
        return mp;
    }

    public Object updateShippingStatus(ShippingRequestDTO shippingRequestDTO)
    {
        Map<String, String> mp = new HashMap<>();
        Shipping shipping=shippingRepository.findById(shippingRequestDTO.getShippingId()).orElse(null);
        shipping.setStatus(shippingRequestDTO.getStatus());
        shipping.setShippingAddress(shipping.getShippingAddress());
        shipping=shippingRepository.save(shipping);
        if(shippingRequestDTO.getStatus().equals("Delivered"))
        {
            Orders orders=ordersRepository.findById(shippingRequestDTO.getShippingId()).orElse(null);
            orders.setStatus(shippingRequestDTO.getStatus());
            orders=ordersRepository.save(orders);
        }
        mp.put("Message","Shipment status changed");
        return mp;
    }
}
