package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>
{
//OrderItem findByCustomer_CustomerId(int customerId);
}
