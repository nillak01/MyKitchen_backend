package com.samsung.rest.controller;


import com.samsung.domain.Recipe;
import com.samsung.rest.dto.RecipeDto;
import com.samsung.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public List<RecipeDto> getAllRecipe(){

        return recipeService
                .getAll()
                .stream()
                .map(RecipeDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/recipe")
    public RecipeDto insertRecipe(@RequestBody RecipeDto recipeDto){

        Recipe recipe = recipeService.insert(RecipeDto.toDomainObject(recipeDto));

        return RecipeDto.toDto(recipe);
    }

    @PutMapping("/recipe/{id}")
    public RecipeDto updateRecipe(@PathVariable int id,
                                    @RequestParam String name,
                                    @RequestParam boolean my,
                                    @RequestParam String point_1,
                                    @RequestParam String point_2,
                                    @RequestParam String point_3,
                                    @RequestParam String point_4,
                                    @RequestParam String point_5,
                                    @RequestParam String point_6,
                                    @RequestParam String point_7,
                                    @RequestParam String point_8,
                                    @RequestParam String point_9,
                                    @RequestParam String point_10
                                    ){

        Recipe recipe = recipeService.update(id, name, my, point_1,point_2, point_3,  point_4, point_5, point_6, point_7, point_8, point_9, point_10 );

        return RecipeDto.toDto(recipe);

    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable int id){

        recipeService.deleteById(id);
    }

    /*@GetMapping("/recipe/{id}")
    public RecipeDto getRecipeById(@PathVariable int id){

        Recipe recipe = recipeService.getById(id);

        return RecipeDto.toDto(recipe);
    }*/

    @GetMapping("/recipe/{my}")
    public List<RecipeDto> getRecipeByMy(@PathVariable boolean my){


        return recipeService
                .getByMy(my)
                .stream()
                .map(RecipeDto::toDto)
                .collect(Collectors.toList());
    }
}
