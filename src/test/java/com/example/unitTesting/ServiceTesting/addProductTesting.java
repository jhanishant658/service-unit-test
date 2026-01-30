package com.example.unitTesting.ServiceTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unitTesting.Entities.Product;
import com.example.unitTesting.Repositories.ProductRepo;
import com.example.unitTesting.Services.ProductService;
@ExtendWith(MockitoExtension.class)
public class addProductTesting {
    @Mock
    ProductRepo repo;
    @InjectMocks
    ProductService productService ; 
    @Test
    public void addProductTest(){
      Product product = new Product(1 , "Laptop" , 10000);
      
      when(repo.save(product)).thenReturn(product);
     Product result = productService.addProduct(product);
     assertNotNull(result);
     assertEquals("Laptop", result.getName());
     verify(repo).save(product);
    }
}
