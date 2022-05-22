package com.samsung.rest.controller;


import com.samsung.domain.DeviceForRecipe;
import com.samsung.rest.dto.DeviceForRecipeDto;
import com.samsung.service.DeviceForRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DeviceForRecipeController {

    private final DeviceForRecipeService deviceForRecipeService;

    @GetMapping("/device_for_recipe")
    public List<DeviceForRecipeDto> getAll(){

        List<DeviceForRecipeDto> deviceForRecipeDtoList = deviceForRecipeService.getAll().stream().map(DeviceForRecipeDto::toDto).collect(Collectors.toList());

        return deviceForRecipeDtoList;

    }

    @PostMapping("/device_for_recipe")
    public DeviceForRecipeDto insertDeviceForRecipe(
            @RequestParam int recipe_id,
            @RequestParam int device_id
    ){

        DeviceForRecipe deviceForRecipe = deviceForRecipeService.insert(recipe_id, device_id);

        return DeviceForRecipeDto.toDto(deviceForRecipe);

    }

    @PutMapping("/device_for_recipe/{id}")
    public DeviceForRecipeDto updateDeviceForRecipe(@PathVariable int id,
                                                    @RequestParam int recipe_id,
                                                    @RequestParam int device_id){

        DeviceForRecipe deviceForRecipe = deviceForRecipeService.update(id, recipe_id, device_id);

        return DeviceForRecipeDto.toDto(deviceForRecipe);
    }

    @GetMapping("/device_for_recipe/{id}")
    public  DeviceForRecipeDto getById(@PathVariable int id){

        return DeviceForRecipeDto.toDto(deviceForRecipeService.getById(id));
    }

    @DeleteMapping("/device_for_recipe/{id}")
    public void deleteById(@PathVariable int id){

        deviceForRecipeService.deleteById(id);
    }
}
