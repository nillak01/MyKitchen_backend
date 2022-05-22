package com.samsung.service;

import com.samsung.domain.Device;
import com.samsung.domain.DeviceForRecipe;
import com.samsung.domain.Recipe;
import com.samsung.repository.DeviceForRecipeRepository;
import com.samsung.repository.DeviceRepository;
import com.samsung.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DeviceForRecipeServiceimpl implements DeviceForRecipeService{

    private final DeviceForRecipeRepository deviceForRecipeRepository;

    private final DeviceRepository deviceRepository;

    private final RecipeRepository recipeRepository;

    @Override
    public DeviceForRecipe insert(int recipe_id, int device_id) {

        Recipe recipe = recipeRepository.getById(recipe_id);

        Device device = deviceRepository.getById(device_id);

        DeviceForRecipe deviceForRecipe = DeviceForRecipe.builder()
                .recipe(recipe)
                .device(device)
                .build();

        return deviceForRecipeRepository.save(deviceForRecipe);
    }

    @Override
    public List<DeviceForRecipe> getAll() {

        return deviceForRecipeRepository.findAll();
    }

    @Override
    public List<DeviceForRecipe> getByRecipe_id(int recipe_id) {

        return deviceForRecipeRepository.findByRecipeId(recipe_id);
    }

    @Override
    public void deleteById(int id) {

        deviceForRecipeRepository.deleteById(id);

    }

    @Override
    public DeviceForRecipe update(int id, int recipe_id, int  device_id) {

        Recipe recipe = recipeRepository.getById(recipe_id);

        Device device = deviceRepository.getById(device_id);


        return deviceForRecipeRepository.save(DeviceForRecipe.builder()
                        .id(id)
                .recipe(recipe)
                .device(device)
                .build());
    }
    @Override
    public DeviceForRecipe getById(int id) {

        return deviceForRecipeRepository.getById(id);
    }
}
