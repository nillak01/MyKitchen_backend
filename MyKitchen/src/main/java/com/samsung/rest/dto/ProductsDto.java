package com.samsung.rest.dto;



import com.samsung.domain.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsDto {


    private int id;

    private String name;

    private boolean my;

    private int weight;

    public static ProductsDto toDto(Products products) {

        return new ProductsDto(
                products.getId(),
                products.getName(),
                products.isMy(),
                products.getWeight()
        );
    }

    public static Products toDomainObject(ProductsDto productsDto) {

        return new Products(
                productsDto.getId(),
                productsDto.getName(),
                productsDto.isMy(),
                productsDto.getWeight()

        );
    }
}
