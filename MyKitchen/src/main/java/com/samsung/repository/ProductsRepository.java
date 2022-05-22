package com.samsung.repository;

import com.samsung.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

    Products findByName(String name);

    List<Products> findByMy(boolean my);
}
