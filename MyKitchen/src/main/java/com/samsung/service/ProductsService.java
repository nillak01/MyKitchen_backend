package com.samsung.service;

import com.samsung.domain.Products;


import java.util.List;

public interface ProductsService {

    Products insert(Products products);

    List<Products> getAll();

    Products getById(int id);

    Products getByName(String name);

    Products update(int id, String nameProduct, boolean my, int weight);

    void deleteById(int id);


    List<Products> getByMy(boolean my);
}
