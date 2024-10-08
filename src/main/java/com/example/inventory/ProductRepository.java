package com.example.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT EXISTS(SELECT 1 FROM Product p WHERE p.brandName=?1)")
    boolean findProductByBrandName(String aInBrandName);
}
