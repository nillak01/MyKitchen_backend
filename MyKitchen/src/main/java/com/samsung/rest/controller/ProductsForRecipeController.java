package com.samsung.rest.controller;


import com.samsung.domain.ProductsForRecipe;
import com.samsung.rest.dto.ProductsForRecipeDto;
import com.samsung.service.ProductsForRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductsForRecipeController {

    private final ProductsForRecipeService productsForRecipeService;

    @GetMapping("/products_for_recipe")
    public List<ProductsForRecipeDto> getAll(){

        List<ProductsForRecipeDto> productsForRecipeDtoList = productsForRecipeService.getAll().stream().map(ProductsForRecipeDto::toDto).collect(Collectors.toList());

        return productsForRecipeDtoList;

    }

    @PostMapping("/products_for_recipe")
    public ProductsForRecipeDto insertProductsForRecipe(
            @RequestParam int recipe_id,
            @RequestParam int product_id,
            @RequestParam int weight

    ){

        ProductsForRecipe productsForRecipe = productsForRecipeService.insert(recipe_id, product_id, weight);

        return ProductsForRecipeDto.toDto(productsForRecipe);

    }

    @PutMapping("/products_for_recipe/{id}")
    public ProductsForRecipeDto updateProductsForRecipe(@PathVariable int id,
                                                    @RequestParam int recipe_id,
                                                    @RequestParam int product_id,
                                                    @RequestParam int weight
                                                    ){

        ProductsForRecipe productsForRecipe = productsForRecipeService.update(id, recipe_id, product_id, weight);

        return ProductsForRecipeDto.toDto(productsForRecipe);
    }

    @GetMapping("/products_for_recipe/{id}")
    public  ProductsForRecipeDto getById(@PathVariable int id){

        return ProductsForRecipeDto.toDto(productsForRecipeService.getById(id));
    }

    @DeleteMapping("/products_for_recipe/{id}")
    public void deleteById(@PathVariable int id){

        productsForRecipeService.deleteById(id);
    }
}
