package com.samsung.service;

import com.samsung.domain.*;
import com.samsung.repository.ProductsForRecipeRepository;
import com.samsung.repository.ProductsRepository;
import com.samsung.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsForRecipeServiceimpl implements ProductsForRecipeService{

    private final ProductsForRecipeRepository productsForRecipeRepository;

    private final RecipeRepository recipeRepository;

    private final ProductsRepository productsRepository;




    @Override
    public ProductsForRecipe insert(int recipe_id, int product_id , int weight) {

        Recipe recipe = recipeRepository.getById(recipe_id);

        Products products = productsRepository.getById(product_id);

        ProductsForRecipe productsForRecipe = ProductsForRecipe.builder()
                .recipe(recipe)
                .products(products)
                .weight(weight)
                .build();

        return productsForRecipeRepository.save(productsForRecipe);
    }

    @Override
    public List<ProductsForRecipe> getAll() {


        return productsForRecipeRepository.findAll();
    }

    @Override
    public List<ProductsForRecipe> getByRecipe_id(int recipe_id) {

        return productsForRecipeRepository.findByRecipeId(recipe_id);
    }

    @Override
    public void deleteById(int id) {

        productsForRecipeRepository.deleteById(id);

    }

    @Override
    public ProductsForRecipe update(int id, int recipe_id, int  product_id, int weight) {

        Recipe recipe = recipeRepository.getById(recipe_id);

        Products products = productsRepository.getById(product_id);


        return productsForRecipeRepository.save(ProductsForRecipe.builder()
                .id(id)
                .recipe(recipe)
                .products(products)
                .weight(weight)
                .build());
    }
    @Override
    public ProductsForRecipe getById(int id) {

        return productsForRecipeRepository.getById(id);
    }
}
