package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Cart;
import com.ecommerce.Ecommerce.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer>
{
    List<CartItem> findByCustomer_CustomerId(int customerId);
}
