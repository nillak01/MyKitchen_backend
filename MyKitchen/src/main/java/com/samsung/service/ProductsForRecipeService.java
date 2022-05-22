package com.samsung.service;

import com.samsung.domain.DeviceForRecipe;
import com.samsung.domain.ProductsForRecipe;

import java.util.List;

public interface ProductsForRecipeService {

    ProductsForRecipe insert(int recipe_id, int product_id, int weight);

    List<ProductsForRecipe> getAll();

    List<ProductsForRecipe> getByRecipe_id(int Recipe_id);

    void deleteById(int id);

    ProductsForRecipe update(int id, int recipe_id, int  product_id, int weight);

    ProductsForRecipe getById(int id);
}
