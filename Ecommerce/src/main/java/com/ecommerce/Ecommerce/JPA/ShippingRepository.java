package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Integer>
{

}
