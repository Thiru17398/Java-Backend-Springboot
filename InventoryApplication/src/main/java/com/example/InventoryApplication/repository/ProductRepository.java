package com.example.InventoryApplication.repository;

import com.example.InventoryApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
