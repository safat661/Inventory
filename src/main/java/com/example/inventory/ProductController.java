package com.example.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/inventory")
public class ProductController {

    private ProductService productService;

    @Autowired
    public  ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public void registerNewProduct(@RequestBody Product aInProduct){
        productService.addNewProduct(aInProduct);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product aInProduct){
        productService.deleteProduct(aInProduct);
    }
}
