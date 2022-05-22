package com.samsung.service;

import com.samsung.domain.Device;
import com.samsung.domain.Products;
import com.samsung.repository.DeviceRepository;
import com.samsung.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductsServiceimpl implements ProductsService{

    private final ProductsRepository productsRepository;

    @Override
    public Products insert(Products products) {


        return productsRepository.save(products);
    }

    @Override
    public List<Products> getAll() {

        return productsRepository.findAll();
    }

    @Override
    public Products getById(int id) {


        return productsRepository.getById(id);
    }

    @Override
    public Products getByName(String name) {


        return productsRepository.findByName(name);
    }

    @Override
    public Products update(int id, String nameProdutc, boolean my, int weight) {

        Products products = Products.builder()
                .id(id)
                .name(nameProdutc)
                .my(my)
                .weight(weight)
                .build();
        return productsRepository.save(products);
    }

    @Override
    public void deleteById(int id) {

        productsRepository.deleteById(id);

    }

    @Override
    public List<Products> getByMy(boolean my) {


        return productsRepository.findByMy(my);
    }
}
