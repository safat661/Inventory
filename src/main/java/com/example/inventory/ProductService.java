package com.example.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
//        return List.of("Drinks", "Pepsi", "12.31", "37");
    }

    public void addNewProduct(Product aInProduct) {
        productRepository.save(aInProduct);
    }

    public void deleteProduct(Product aInProduct){
        String lBrandName = aInProduct.getBrandName();
        boolean lFoundProductByBrandName = productRepository.findProductByBrandName(lBrandName);
        if (!lFoundProductByBrandName) {
            return;
        } else {
            productRepository.delete(aInProduct);
        }
    }
}
