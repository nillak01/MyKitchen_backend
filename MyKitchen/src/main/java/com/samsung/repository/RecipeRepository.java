package com.samsung.repository;

import com.samsung.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Recipe findByName(String name);

    List<Recipe> findByMy(boolean my);
}
