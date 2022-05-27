package com.samsung.rest.dto;



import com.samsung.domain.ProductsForRecipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
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
