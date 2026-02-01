package com.example.unitTesting.ServiceTesting;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
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
public class UpdateProductTest {
    @Mock
    ProductRepo repo ; 
    @InjectMocks
    ProductService productService ;
    @Test
    public void Update_Product_Success(){
        Product existingProduct = new Product(1, "Smartphone", 500);
        Product updatedProduct = new Product(1, "Smartphone Pro", 700);
         when(repo.findById(1)).thenReturn(Optional.of(existingProduct));
        when(repo.save(existingProduct)).thenReturn(existingProduct);
        Product result = productService.updateProduct( updatedProduct);
        assertEquals(updatedProduct.getPrice(), result.getPrice());
        verify(repo).findById(anyInt());
        verify(repo).save(existingProduct);
    }
    @Test
    public void Update_Product_Failure_InvalidData(){
        Product existingProduct = new Product(1, "Smartphone", 500);
        Product updatedProduct = new Product(1, "", -100);
        assertThrows(IllegalArgumentException.class, ()-> productService.updateProduct(updatedProduct));
        verify(repo , never()).findById(anyInt());
        verify(repo , never()).save(existingProduct);
    }
    
}
