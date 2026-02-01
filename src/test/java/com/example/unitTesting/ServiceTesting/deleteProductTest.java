package com.example.unitTesting.ServiceTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class deleteProductTest {
    @Mock
    private ProductRepo repo ; 
    @InjectMocks
    ProductService productService ;
    @Test
    void delete_Product_Success() {
        // Test implementation for successful product deletion
        Product existingProduct = new Product(1 ,"Laptop", 1000);
        when(repo.findById(1)).thenReturn(Optional.of(existingProduct));
        when(repo.delete(existingProduct)).thenReturn(existingProduct);
        Product result = productService.deleteProduct(1);
        assertTrue(result!=null);
        verify(repo).findById(1);
        verify(repo).delete(existingProduct);
    }
    @Test
    void delete_Product_Failure_NotFound() {
        // Test implementation for product deletion failure due to product not found
        when(repo.findById(1)).thenReturn(Optional.empty());
        try {
            productService.deleteProduct(1);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Product Not Found"));
        }
        verify(repo).findById(1);
    }
}
