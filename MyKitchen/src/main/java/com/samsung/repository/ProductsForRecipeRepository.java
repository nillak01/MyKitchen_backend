package com.samsung.repository;



import com.samsung.domain.Products;
import com.samsung.domain.ProductsForRecipe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public interface ProductsForRecipeRepository extends JpaRepository<ProductsForRecipe, Integer>  {

    @Override
    @EntityGraph(attributePaths = {"recipe", "products", "weight"})
    List<ProductsForRecipe> findAll();

    List<ProductsForRecipe>  findByRecipeId(int id);

}
