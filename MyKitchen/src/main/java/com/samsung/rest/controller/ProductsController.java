package com.samsung.rest.controller;


import com.samsung.domain.Products;
import com.samsung.rest.dto.ProductsDto;
import com.samsung.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/products")
    public List<ProductsDto> getAllProducts(){

        return productsService
                .getAll()
                .stream()
                .map(ProductsDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/products")
    public ProductsDto insertProducts(@RequestBody ProductsDto deviceDto){

        Products products = productsService.insert(ProductsDto.toDomainObject(deviceDto));

        return ProductsDto.toDto(products);
    }

    @PutMapping("/products/{id}")
    public ProductsDto updateProducts(@PathVariable int id,
                                  @RequestParam String name,
                                  @RequestParam boolean my,
                                    @RequestParam int weight){

        Products products = productsService.update(id, name, my, weight);

        return ProductsDto.toDto(products);

    }

    @DeleteMapping("/products/{id}")
    public void deleteProducts(@PathVariable int id){

        productsService.deleteById(id);
    }

    /*@GetMapping("/products/{id}")
    public ProductsDto getProductsById(@PathVariable int id){

        Products products = productsService.getById(id);

        return ProductsDto.toDto(products);
    }*/

    @GetMapping("/products/{my}")
    public List<ProductsDto> getProductsByMy(@PathVariable boolean my){


        return productsService
                .getByMy(my)
                .stream()
                .map(ProductsDto::toDto)
                .collect(Collectors.toList());
    }
}
