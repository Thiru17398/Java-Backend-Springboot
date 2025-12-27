package com.example.InventoryApplication.exception;


import com.example.InventoryApplication.exception.baseExceptions.NotFoundException;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
