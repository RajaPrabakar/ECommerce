package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>
{

}
