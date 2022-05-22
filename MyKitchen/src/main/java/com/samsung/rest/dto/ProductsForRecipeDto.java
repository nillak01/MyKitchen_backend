package com.samsung.rest.dto;



import com.samsung.domain.ProductsForRecipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsForRecipeDto {

    private int id;

    private RecipeDto recipeDto;

    private ProductsDto productsDto;

    private int weight;


    public static ProductsForRecipeDto toDto(ProductsForRecipe productsForRecipe) {

        return new ProductsForRecipeDto(
                productsForRecipe.getId(),
                RecipeDto.toDto(productsForRecipe.getRecipe()),
                ProductsDto.toDto(productsForRecipe.getProducts()),
                productsForRecipe.getWeight()




        );
    }
}
