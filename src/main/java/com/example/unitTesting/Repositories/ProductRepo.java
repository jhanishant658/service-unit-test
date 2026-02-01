package com.example.unitTesting.Repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.unitTesting.Entities.Product;

@Repository
public interface ProductRepo {
 Optional<Product> findById(int id);
 Product save(Product product);
 Product delete(Product existingProduct);
}
