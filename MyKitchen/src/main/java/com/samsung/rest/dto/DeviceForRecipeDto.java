package com.samsung.rest.dto;


import com.samsung.domain.DeviceForRecipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceForRecipeDto {

    private int id;

    private RecipeDto recipeDto;

    private DeviceDto deviceDto;



    public static DeviceForRecipeDto toDto(DeviceForRecipe deviceForRecipe) {

        return new DeviceForRecipeDto(
                deviceForRecipe.getId(),
                RecipeDto.toDto(deviceForRecipe.getRecipe()),
                DeviceDto.toDto(deviceForRecipe.getDevice())

        );
    }


}
