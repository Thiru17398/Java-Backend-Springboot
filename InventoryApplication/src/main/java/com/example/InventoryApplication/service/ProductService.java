package com.example.InventoryApplication.service;

import com.example.InventoryApplication.entity.Product;
import com.example.InventoryApplication.exception.ProductNotFoundException;
import com.example.InventoryApplication.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product){
        log.info("Creating a Product : {}" , product );
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        log.info("Retrieving all Products...");
        List<Product> result = productRepository.findAll();
        log.info("Found : {} Products", result.size());
        return result;
    }

    public Product getProduct(long id) throws ProductNotFoundException {
        log.info("Searching Product with id : {}", id);
        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty())
            throw new ProductNotFoundException("Product id : "+ id + " not found");

        return product.get();
    }
}
