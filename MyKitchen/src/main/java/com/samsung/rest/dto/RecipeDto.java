package com.samsung.rest.dto;



import com.samsung.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {

    private int id;

    private String name;
    private boolean my;

    private String point_1;
    private String point_2;
    private String point_3;
    private String point_4;
    private String point_5;
    private String point_6;
    private String point_7;
    private String point_8;
    private String point_9;
    private String point_10;

    public static RecipeDto toDto(Recipe recipe) {

        return new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.isMy(),
                recipe.getPoint_1(),
                recipe.getPoint_2(),
                recipe.getPoint_3(),
                recipe.getPoint_4(),
                recipe.getPoint_5(),
                recipe.getPoint_6(),
                recipe.getPoint_7(),
                recipe.getPoint_8(),
                recipe.getPoint_9(),
                recipe.getPoint_10()

        );
    }

    public static Recipe toDomainObject(RecipeDto recipeDto) {

        return new Recipe(
                recipeDto.getId(),
                recipeDto.getName(),
                recipeDto.isMy(),
                recipeDto.getPoint_1(),
                recipeDto.getPoint_2(),
                recipeDto.getPoint_3(),
                recipeDto.getPoint_4(),
                recipeDto.getPoint_5(),
                recipeDto.getPoint_6(),
                recipeDto.getPoint_7(),
                recipeDto.getPoint_8(),
                recipeDto.getPoint_9(),
                recipeDto.getPoint_10()

        );
    }
}
