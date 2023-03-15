package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer>
{
Cart findByCustomer_CustomerId(int customerId);

}
