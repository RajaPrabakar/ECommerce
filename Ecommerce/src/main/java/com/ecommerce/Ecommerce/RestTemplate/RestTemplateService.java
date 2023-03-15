package com.ecommerce.Ecommerce.RestTemplate;


import com.ecommerce.Ecommerce.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

@RestController
public class RestTemplateService
{

    @Autowired
   RestTemplate restTemplate;



    @RequestMapping(value = "/add-products",method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        String response=restTemplate.exchange("http://localhost:8080/add-product", HttpMethod.POST,entity,String.class).getBody();
        return response;
    }
    @GetMapping(value = "/get")
    public String getAllItems()
    {
        String uri="http://localhost:8080/get-cart-items";
        HttpRequest httpRequest=HttpRequest.newBuilder().GET().uri(URI.create(uri)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse;
        try {
            httpResponse= client.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return httpResponse.body();
    }
    @GetMapping(value = "/update-product")
    public Object getItem()
    {
        WebClient webClient;
        String response=WebClient.builder()
                .build()
                .get()
                .uri("http://localhost:8080/get-cart-items")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    @PutMapping(value = "/update-product/{id}")
    public Object updateProduct(@RequestBody Product product,@PathVariable int id)
    {
        WebClient webClient;
        String response=WebClient.builder()
                .build()
                .put()
                .uri("http://localhost:8080/update-product-quantity/"+id)
                .bodyValue(product)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }
}

