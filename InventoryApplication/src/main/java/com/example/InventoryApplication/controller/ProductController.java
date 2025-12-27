package com.example.InventoryApplication.controller;

import com.example.InventoryApplication.entity.Product;
import com.example.InventoryApplication.exception.ProductNotFoundException;
import com.example.InventoryApplication.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/allProducts")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Map<String, Object>> getAllProducts(){
        List<Product> result = productService.getAllProducts();
        Map<String,Object> response = new HashMap<>();
        response.put("status" , 200);
        response.put("size" , result.size());
        response.put("products" , result.isEmpty() ? "No Products Found" : result);
        return ResponseEntity.ofNullable(response);
    }

    @GetMapping("/getProduct/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product getProduct(@PathVariable long id) throws ProductNotFoundException {
        return productService.getProduct(id);
    }

}
