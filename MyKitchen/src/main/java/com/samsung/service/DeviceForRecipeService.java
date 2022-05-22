package com.samsung.service;

import com.samsung.domain.DeviceForRecipe;

import java.util.List;

public interface DeviceForRecipeService {

    DeviceForRecipe insert(int recipe_id, int device_id);

    List<DeviceForRecipe> getAll();

    List<DeviceForRecipe> getByRecipe_id(int recipe_id);

    void deleteById(int id);

    DeviceForRecipe update(int id, int recipe_id, int  device_id);

    DeviceForRecipe getById(int id);


}
