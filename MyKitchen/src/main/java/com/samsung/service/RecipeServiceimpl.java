package com.samsung.service;

import com.samsung.domain.Products;
import com.samsung.domain.Recipe;
import com.samsung.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeServiceimpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    @Override
    public Recipe insert(Recipe recipe) {

        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> getAll() {

        return recipeRepository.findAll();
    }

    @Override
    public Recipe getById(int id) {

        return recipeRepository.getById(id);
    }

    @Override
    public Recipe getByName(String name) {

        return recipeRepository.findByName(name);
    }

    @Override
    public Recipe update(int id, String nameRecipe, boolean my,  String point_1, String point_2, String point_3, String point_4, String point_5, String point_6, String point_7, String point_8, String point_9, String point_10) {

        Recipe recipe = Recipe.builder()
                .id(id)
                .name(nameRecipe)
                .my(my)
                .point_1(point_1)
                .point_2(point_2)
                .point_3(point_3)
                .point_4(point_4)
                .point_5(point_5)
                .point_6(point_6)
                .point_7(point_7)
                .point_8(point_8)
                .point_9(point_9)
                .point_10(point_10)
                .build();


        return recipeRepository.save(recipe);

    }

    @Override
    public void deleteById(int id) {

        recipeRepository.deleteById(id);

    }

    @Override
    public List<Recipe> getByMy(boolean my) {


        return recipeRepository.findByMy(my);
    }
}
