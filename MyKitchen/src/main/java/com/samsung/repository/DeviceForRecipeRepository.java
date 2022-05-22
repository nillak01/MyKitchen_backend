package com.samsung.repository;

import com.samsung.domain.DeviceForRecipe;
import com.samsung.domain.ProductsForRecipe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceForRecipeRepository extends JpaRepository<DeviceForRecipe, Integer> {

    @Override
    @EntityGraph(attributePaths = {"recipe","device"})
    List<DeviceForRecipe> findAll();

    List<DeviceForRecipe>  findByRecipeId(int id);
}
