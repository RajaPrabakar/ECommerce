package com.ecommerce.Ecommerce.Service;

import com.ecommerce.Ecommerce.DTO.ProductRequestDTO;
import com.ecommerce.Ecommerce.JPA.ProductRepository;
import com.ecommerce.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    Map<String,String> mp = new HashMap<>();

    public Object postProducts(ProductRequestDTO productRequestDTO)
    {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductSpecification(productRequestDTO.getProductSpecification());
        product.setProductDiscount(productRequestDTO.getProductDiscount());
        product.setProductAvailableQuantity(productRequestDTO.getProductAvailableQuantity());
        product=productRepository.save(product);
        mp.put("Message:","Product is added");
        return mp;
    }

    public Object updateProduct(ProductRequestDTO productRequestDTO,int id)
    {
        Product products = productRepository.findById(id).orElse(null);
//        products.setProductAvailableQuantity(productRequestDTO.getProductAvailableQuantity()+products.getProductAvailableQuantity());
        products.setProductName(productRequestDTO.getProductName());
        products=productRepository.save(products);
        mp.put("Message:","Product Name is Changed");
        return mp;
    }
}
