package com.samsung.service;

import com.samsung.domain.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe insert(Recipe recipe);

    List<Recipe> getAll();

    Recipe getById(int id);

    Recipe getByName(String name);

    Recipe update(int id, String nameRecipe, boolean my ,  String point_1, String point_2, String point_3, String point_4, String point_5, String point_6, String point_7, String point_8, String point_9, String point_10);

    void deleteById(int id);

    List<Recipe> getByMy(boolean my);
}
