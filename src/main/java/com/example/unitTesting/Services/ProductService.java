package com.example.unitTesting.Services;
import org.springframework.stereotype.Service;

import com.example.unitTesting.Entities.Product;
import com.example.unitTesting.Repositories.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public Product addProduct(Product product){
     if(product.getPrice()<1|| product.getName().isEmpty()){
         throw new IllegalArgumentException("Invalid Product Data");
     }
        productRepo.save(product);
    return product;
    }
   public Product getProduct(int id){
        return productRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Product Not Found"));
    }
}
