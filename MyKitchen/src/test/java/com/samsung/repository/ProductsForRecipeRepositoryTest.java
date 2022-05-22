package com.samsung.repository;


import com.samsung.domain.DeviceForRecipe;
import com.samsung.domain.Products;
import com.samsung.domain.ProductsForRecipe;
import com.samsung.domain.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ProductsForRecipeRepositoryTest {

    public static final int EXISTING_DEVICE_COUNT = 4;
    public static final int EXISTING_ID1 = 1;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final int EXISTING_RECIPE_ID1 = 1;
    public static final int EXISTING_RECIPE_ID2 = 1;
    public static final int EXISTING_RECIPE_ID3 = 1;
    public static final int EXISTING_PRODUCTS_ID1 = 4;
    public static final int EXISTING_PRODUCTS_ID2 = 6;
    public static final int EXISTING_PRODUCTS_ID3 = 3;
    public static final int EXISTING_PRODUCTS_ID4 = 5;
    public static final String EXISTING_NAME1 = "Лук";
    public static final String EXISTING_NAME2 = "Курица";
    public static final String EXISTING_NAME3 = "Картошка";
    public static final String EXISTING_NAME4 = "Марковь";
    public static final int    EXISTING_FOR_RECIPE_WEIGHT1 = 100;
    public static final int    EXISTING_FOR_RECIPE_WEIGHT2 = 700;
    public static final int    EXISTING_FOR_RECIPE_WEIGHT3 = 500;
    public static final int    EXISTING_FOR_RECIPE_WEIGHT4 = 200;
    public static final int    EXISTING_PRODUCT_WEIGHT1 = 500;
    public static final int    EXISTING_PRODUCT_WEIGHT2 = 1000;
    public static final int    EXISTING_PRODUCT_WEIGHT3 = 10000;
    public static final int    EXISTING_PRODUCT_WEIGHT4 = 3000;
    public static final boolean EXISTING_MY1 = true;
    public static final String EXISTING_POINT_11 = "Приготовьте все ингредиенты";
    public static final String EXISTING_POINT_21 = "Промойте курицу и  положите ее в кастрюлю с холодной водой и поставьте на сильный огонь";
    public static final String EXISTING_POINT_31 = "Когда вода закипит убавьте огонь ";
    public static final String EXISTING_POINT_41 = " Накройте и варите 40 минут";
    public static final String EXISTING_POINT_51 = " пока вариться курица почистите марковку картошку и лук";
    public static final String EXISTING_POINT_61 = " Порежте картошку иаленькими кубиками и закиньте в кастрюлю";
    public static final String EXISTING_POINT_71 = " потрите марковку на мелкой терке и отправте туда же";
    public static final String EXISTING_POINT_81 = " лук порежьте маленькими кусочками и также добавьте в кастрюлю";
    public static final String EXISTING_POINT_91 = "посолите поперчите по вкусу ваш суп готов! Приятного аппетита";
    public static final String EXISTING_POINT_101 = ":)";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductsForRecipeRepository productsForRecipeRepository;


    @DisplayName("должен добавлять связку ghjlernf для рецепта")
    @Test
    void shouldInsertProductsForRecipe() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_RECIPE_ID1)
                .name("Куринный суп")
                .my(true)
                .point_1(EXISTING_POINT_11)
                .point_2(EXISTING_POINT_21)
                .point_3(EXISTING_POINT_31)
                .point_4(EXISTING_POINT_41)
                .point_5(EXISTING_POINT_51)
                .point_6(EXISTING_POINT_61)
                .point_7(EXISTING_POINT_71)
                .point_8(EXISTING_POINT_81)
                .point_9(EXISTING_POINT_91)
                .point_10(EXISTING_POINT_101)
                .build();

        Products expectedProducts1 = Products.builder()
                .id(5)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(1000)
                .build();

        ProductsForRecipe expectedProductsForRecipe = ProductsForRecipe.builder()
                .id(4)
                .recipe(expectedRecipe)
                .products(expectedProducts1)
                .build();

        productsForRecipeRepository.save(expectedProductsForRecipe);
        ProductsForRecipe actualProductsForRecipe = productsForRecipeRepository.getById(4);

        assertThat(actualProductsForRecipe).isEqualTo(expectedProductsForRecipe);
    }

    @Test
    @DisplayName("должен удалять связку по id")
    void shouldDeleteProductsForRecipeById() {

        int size = productsForRecipeRepository.findAll().size();

        productsForRecipeRepository.deleteById(2);

        entityManager.flush();
        int size1 = productsForRecipeRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);
    }


    @DisplayName("должен обновлять связку продуктв и рецепта")
    @Test
    void shouldUpdateProductsForRecipe() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_RECIPE_ID1)
                .name("Куринный суп")
                .my(true)
                .point_1(EXISTING_POINT_11)
                .point_2(EXISTING_POINT_21)
                .point_3(EXISTING_POINT_31)
                .point_4(EXISTING_POINT_41)
                .point_5(EXISTING_POINT_51)
                .point_6(EXISTING_POINT_61)
                .point_7(EXISTING_POINT_71)
                .point_8(EXISTING_POINT_81)
                .point_9(EXISTING_POINT_91)
                .point_10(EXISTING_POINT_101)
                .build();

        Products expectedProducts1 = Products.builder()
                .id(5)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(1000)
                .build();

        ProductsForRecipe expectedProductsForRecipe = ProductsForRecipe.builder()
                .id(EXISTING_ID1)
                .recipe(expectedRecipe)
                .products(expectedProducts1)
                .build();


        productsForRecipeRepository.save(expectedProductsForRecipe);
        ProductsForRecipe actualProductsForRecipe = productsForRecipeRepository.getById(EXISTING_ID1);

        assertThat(actualProductsForRecipe).isEqualTo(expectedProductsForRecipe);
    }

    @DisplayName("должен возвращать все связки продуктов и рецетов")
    @Test
    void shouldGetAllProductsForRecipes() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_RECIPE_ID1)
                .name("Куринный суп")
                .my(true)
                .point_1(EXISTING_POINT_11)
                .point_2(EXISTING_POINT_21)
                .point_3(EXISTING_POINT_31)
                .point_4(EXISTING_POINT_41)
                .point_5(EXISTING_POINT_51)
                .point_6(EXISTING_POINT_61)
                .point_7(EXISTING_POINT_71)
                .point_8(EXISTING_POINT_81)
                .point_9(EXISTING_POINT_91)
                .point_10(EXISTING_POINT_101)
                .build();

        Products expectedProducts1 = Products.builder()
                .id(EXISTING_PRODUCTS_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT1)
                .build();
        Products expectedProducts2 = Products.builder()
                .id(EXISTING_PRODUCTS_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT2)
                .build();
        Products expectedProducts3 = Products.builder()
                .id(EXISTING_PRODUCTS_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT3)
                .build();
        Products expectedProducts4 = Products.builder()
                .id(EXISTING_PRODUCTS_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT4)
                .build();

        ProductsForRecipe expectedProductsForRecipe1 = ProductsForRecipe.builder()
                .id(1)
                .recipe(expectedRecipe)
                .products(expectedProducts1)
                .weight(EXISTING_FOR_RECIPE_WEIGHT1)
                .build();
        ProductsForRecipe expectedProductsForRecipe2 = ProductsForRecipe.builder()
                .id(2)
                .recipe(expectedRecipe)
                .products(expectedProducts2)
                .weight(EXISTING_FOR_RECIPE_WEIGHT2)
                .build();
        ProductsForRecipe expectedProductsForRecipe3 = ProductsForRecipe.builder()
                .id(3)
                .recipe(expectedRecipe)
                .products(expectedProducts3)
                .weight(EXISTING_FOR_RECIPE_WEIGHT3)
                .build();
        ProductsForRecipe expectedProductsForRecipe4 = ProductsForRecipe.builder()
                .id(4)
                .recipe(expectedRecipe)
                .products(expectedProducts4)
                .weight(EXISTING_FOR_RECIPE_WEIGHT4)
                .build();


        assertThat(productsForRecipeRepository.findAll().size()).isEqualTo(EXISTING_DEVICE_COUNT);
        assertThat(productsForRecipeRepository.findAll())
                .containsExactlyInAnyOrder(expectedProductsForRecipe1, expectedProductsForRecipe2, expectedProductsForRecipe3, expectedProductsForRecipe4);
    }

    @DisplayName("должен возвращать связку по id ")
    @Test
    void shouldGetProductsForRecipeById() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_RECIPE_ID1)
                .name("Куринный суп")
                .my(true)
                .point_1(EXISTING_POINT_11)
                .point_2(EXISTING_POINT_21)
                .point_3(EXISTING_POINT_31)
                .point_4(EXISTING_POINT_41)
                .point_5(EXISTING_POINT_51)
                .point_6(EXISTING_POINT_61)
                .point_7(EXISTING_POINT_71)
                .point_8(EXISTING_POINT_81)
                .point_9(EXISTING_POINT_91)
                .point_10(EXISTING_POINT_101)
                .build();

        Products expectedProducts1 = Products.builder()
                .id(EXISTING_PRODUCTS_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT1)
                .build();

        ProductsForRecipe expectedProductsForRecipe = ProductsForRecipe.builder()
                .id(EXISTING_ID1)
                .recipe(expectedRecipe)
                .products(expectedProducts1)
                .weight(EXISTING_FOR_RECIPE_WEIGHT1)
                .build();

        ProductsForRecipe actualProductsForRecipe = productsForRecipeRepository.getById(EXISTING_ID1);

        assertThat(actualProductsForRecipe).isEqualTo(expectedProductsForRecipe);
    }

    @DisplayName("должен возвращать связки по id рецепта")
    @Test
    void shouldGetProductsForRecipeByRecipeId() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_RECIPE_ID1)
                .name("Куринный суп")
                .my(true)
                .point_1(EXISTING_POINT_11)
                .point_2(EXISTING_POINT_21)
                .point_3(EXISTING_POINT_31)
                .point_4(EXISTING_POINT_41)
                .point_5(EXISTING_POINT_51)
                .point_6(EXISTING_POINT_61)
                .point_7(EXISTING_POINT_71)
                .point_8(EXISTING_POINT_81)
                .point_9(EXISTING_POINT_91)
                .point_10(EXISTING_POINT_101)
                .build();

        Products expectedProducts1 = Products.builder()
                .id(EXISTING_PRODUCTS_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT1)
                .build();
        Products expectedProducts2 = Products.builder()
                .id(EXISTING_PRODUCTS_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT2)
                .build();
        Products expectedProducts3 = Products.builder()
                .id(EXISTING_PRODUCTS_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT3)
                .build();
        Products expectedProducts4 = Products.builder()
                .id(EXISTING_PRODUCTS_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY1)
                .weight(EXISTING_PRODUCT_WEIGHT4)
                .build();

        ProductsForRecipe expectedProductsForRecipe1 = ProductsForRecipe.builder()
                .id(1)
                .recipe(expectedRecipe)
                .products(expectedProducts1)
                .weight(EXISTING_FOR_RECIPE_WEIGHT1)
                .build();
        ProductsForRecipe expectedProductsForRecipe2 = ProductsForRecipe.builder()
                .id(2)
                .recipe(expectedRecipe)
                .products(expectedProducts2)
                .weight(EXISTING_FOR_RECIPE_WEIGHT2)
                .build();
        ProductsForRecipe expectedProductsForRecipe3 = ProductsForRecipe.builder()
                .id(3)
                .recipe(expectedRecipe)
                .products(expectedProducts3)
                .weight(EXISTING_FOR_RECIPE_WEIGHT3)
                .build();
        ProductsForRecipe expectedProductsForRecipe4 = ProductsForRecipe.builder()
                .id(4)
                .recipe(expectedRecipe)
                .products(expectedProducts4)
                .weight(EXISTING_FOR_RECIPE_WEIGHT4)
                .build();



        assertThat(productsForRecipeRepository.findByRecipeId(EXISTING_RECIPE_ID1))
                .containsExactlyInAnyOrder(expectedProductsForRecipe1, expectedProductsForRecipe2, expectedProductsForRecipe3, expectedProductsForRecipe4);
    }

}