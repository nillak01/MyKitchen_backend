package com.samsung.repository;



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
public class RecipeRepositoryTest {

    public static final int EXISTING_DEVICE_COUNT = 1;
    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Куринный суп";
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
    private RecipeRepository recipeRepository;

    @DisplayName("должен добавлять рецепт")
    @Test
    void shouldInsertRecipe() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(false)
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

        recipeRepository.save(expectedRecipe);
        Recipe actualProducts = recipeRepository.getById(EXISTING_ID1);

        assertThat(actualProducts).isEqualTo(expectedRecipe);
    }

    @Test
    @DisplayName("должен удалять рецепт по id")
    void shouldDeleteRecipeById() {

        int size = recipeRepository.findAll().size();

        recipeRepository.deleteById(EXISTING_ID1);

        entityManager.flush();
        int size1 = recipeRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);
    }


    @DisplayName("должен обновлять рецепт")
    @Test
    void shouldUpdateRecipe() {
        Recipe expectedRecipe1 = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(false)
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

        recipeRepository.save(expectedRecipe1);
        Recipe actualProducts = recipeRepository.getById(EXISTING_ID1);

        assertThat(actualProducts).isEqualTo(expectedRecipe1);
    }

    @DisplayName("должен возвращать все рецепты")
    @Test
    void shouldGetAllRecipes() {

        Recipe expectedRecipe1 = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
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


        assertThat(recipeRepository.findAll().size()).isEqualTo(EXISTING_DEVICE_COUNT);
        assertThat(recipeRepository.findAll())
                .containsExactlyInAnyOrder(expectedRecipe1);
    }

    @DisplayName("должен возвращать рецепт по id")
    @Test
    void shouldGetRecipeById() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
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

        Recipe actualRecipe = recipeRepository.getById(EXISTING_ID1);

        assertThat(actualRecipe).isEqualTo(expectedRecipe);
    }

    @DisplayName("должен возвращать рецепт по названию")
    @Test
    void shouldGetRecipeByName() {

        Recipe expectedRecipe = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
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

        Recipe actualRecipe = recipeRepository.findByName(EXISTING_NAME1);

        assertThat(actualRecipe).isEqualTo(expectedRecipe);
    }

    @DisplayName("должен возвращать рецепт по наличию у меня")
    @Test
    void shouldGetRecipeMy() {

        Recipe expectedRecipe1 = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
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
        Recipe expectedRecipe2 = Recipe.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(false)
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

        List<Recipe> actualRecipe = recipeRepository.findByMy(true);

        assertThat(actualRecipe).containsExactlyInAnyOrder(expectedRecipe1);
    }
}
