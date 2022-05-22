package com.samsung.service;


import com.samsung.domain.*;
import com.samsung.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MyKitchenDemoSout implements MyKitchenDemo{



    private final DeviceRepository deviceRepository;

    private final ProductsRepository productsRepository;

    private final RecipeRepository recipeRepository;

    private final DeviceForRecipeRepository deviceForRecipeRepository;

    private final ProductsForRecipeRepository productsForRecipeRepository;


    @Override
    @Transactional
    public void deviceDemo() {

        Device newDevice = Device.builder()
                .name("Огнемет")
                .build();
        deviceRepository.save(newDevice);

        System.out.println("======Все приборы======");

        for (Device device : deviceRepository.findAll()) {

            System.out.println(device);
        }

        System.out.println("======================\n");

    }

    @Override
    @Transactional
    public void recipeDemo() {

        Recipe newRecipe = Recipe.builder()
                .name("Новый рецепт")
                .build();

        recipeRepository.save(newRecipe);

        System.out.println("======Все рецепты======");

        for (Recipe recipe : recipeRepository.findAll()) {

            System.out.println(recipe);
        }

        System.out.println("======================\n");




    }

    @Override
    @Transactional
    public void productsDemo() {

        Products newProduct = Products.builder()
                .name("Новый продукт")
                .build();

        productsRepository.save(newProduct);

        System.out.println("======Все Продукты======");

        for (Products products : productsRepository.findAll()) {

            System.out.println(products);
        }

        System.out.println("======================\n");

    }

    @Override
    @Transactional
    public void deviceForRecipeDemo() {
        System.out.println("======Все приборы для рецепта======");

        for (DeviceForRecipe deviceForRecipe : deviceForRecipeRepository.findAll()) {

            System.out.println(deviceForRecipe.getRecipe().getName() + " - " +  deviceForRecipe.getDevice().getName());
        }

        System.out.println("======================\n");

    }

    @Override
    @Transactional
    public void productsForRecipeDemo() {

        System.out.println("======Все продукты для рецепта======");

        for (ProductsForRecipe productsForRecipe : productsForRecipeRepository.findAll()) {

            System.out.println(productsForRecipe.getRecipe().getName() + " - " + productsForRecipe.getProducts().getName());
        }

        System.out.println("======================\n");

    }



    @Override
    @Transactional
    public void myKitchenDemo() {

        deviceDemo();


        recipeDemo();

        productsDemo();

        deviceForRecipeDemo();

        productsForRecipeDemo();


    }
}
