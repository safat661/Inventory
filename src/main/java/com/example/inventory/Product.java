package com.example.inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName ="product_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String category;
    private String brandName;
    private int price;
    private int aisleNumber;

    public Product(String category, String brandName, int price, int aisleNumber) {
        category = category;
        brandName = brandName;
        this.price = price;
        aisleNumber = aisleNumber;
    }

    public Product() {
    }

    public String getCategory() {
        return category;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getPrice() {
        return price;
    }

    public int getAisleNumber() {
        return aisleNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Category='" + category + '\'' +
                ", BrandName='" + brandName + '\'' +
                ", price=" + price +
                ", AisleNumber=" + aisleNumber +
                '}';
    }
}
