package com.example.unitTesting.ServiceTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unitTesting.Entities.Product;
import com.example.unitTesting.Repositories.ProductRepo;
import com.example.unitTesting.Services.ProductService;

@ExtendWith(MockitoExtension.class)
public class getProductTesting {
    
    @Mock
    ProductRepo repo;
    @InjectMocks
    ProductService productService; 
    @Test
    public void getProductTest(){
        Product product = new Product(1 ,"Laptop", 1000);
        when(repo.findById(1)).thenReturn(Optional.of(product));
        Product result = productService.getProduct(1);
        assertNotNull(result);
        assert(result.getPrice()>0);
        assertEquals("Laptop", result.getName());
        verify(repo).findById(1);
        
    }
}
