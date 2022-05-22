package com.samsung.repository;



import com.samsung.domain.Device;
import com.samsung.domain.DeviceForRecipe;
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
public class DeviceForRecipeRepositoryTest {

    public static final int EXISTING_DEVICE_COUNT = 3;
    public static final int EXISTING_ID1 = 1;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final int EXISTING_RECIPE_ID1 = 1;
    public static final int EXISTING_RECIPE_ID2 = 1;
    public static final int EXISTING_RECIPE_ID3 = 1;
    public static final int EXISTING_DEVICE_ID1 = 1;
    public static final int EXISTING_DEVICE_ID2 = 6;
    public static final int EXISTING_DEVICE_ID3 = 7;
    public static final String EXISTING_NAME1 = "Половник";
    public static final String EXISTING_NAME2 = "Кастрюла на 5 литров";
    public static final String EXISTING_NAME3 = "Газованя или эл плита";
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
    private DeviceForRecipeRepository deviceForRecipeRepository;


    @DisplayName("должен добавлять связку прибора для рецепта")
    @Test
    void shouldInsertDeviceForRecipe() {

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

        Device expectedDevice1 = Device.builder()
                .id(5)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        DeviceForRecipe expectedDeviceForRecipe = DeviceForRecipe.builder()
                .id(4)
                .recipe(expectedRecipe)
                .device(expectedDevice1)
                .build();

        deviceForRecipeRepository.save(expectedDeviceForRecipe);
        DeviceForRecipe actualDeviceForRecipe = deviceForRecipeRepository.getById(4);

        assertThat(actualDeviceForRecipe).isEqualTo(expectedDeviceForRecipe);
    }

    @Test
    @DisplayName("должен удалять связку по id")
    void shouldDeleteDeviceForRecipeById() {

        int size = deviceForRecipeRepository.findAll().size();

        deviceForRecipeRepository.deleteById(2);

        entityManager.flush();
        int size1 = deviceForRecipeRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);
    }


    @DisplayName("должен обновлять связку прибора и рецепта")
    @Test
    void shouldUpdateDeviceForRecipe() {

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

        Device expectedDevice1 = Device.builder()
                .id(8)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        DeviceForRecipe expectedDeviceForRecipe1 = DeviceForRecipe.builder()
                .id(EXISTING_ID1)
                .recipe(expectedRecipe)
                .device(expectedDevice1)
                .build();

        deviceForRecipeRepository.save(expectedDeviceForRecipe1);
        DeviceForRecipe actualDeviceForRecipe = deviceForRecipeRepository.getById(EXISTING_ID1);

        assertThat(actualDeviceForRecipe).isEqualTo(expectedDeviceForRecipe1);
    }

    @DisplayName("должен возвращать все связки приборов и рецетов")
    @Test
    void shouldGetAllDeviceForRecipes() {

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

        Device expectedDevice1 = Device.builder()
                .id(EXISTING_DEVICE_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();
        Device expectedDevice2 = Device.builder()
                .id(EXISTING_DEVICE_ID2)
                .name(EXISTING_NAME2)
                .my(true)
                .build();
        Device expectedDevice3 = Device.builder()
                .id(EXISTING_DEVICE_ID3)
                .name(EXISTING_NAME3)
                .my(true)
                .build();

        DeviceForRecipe expectedDeviceForRecipe1 = DeviceForRecipe.builder()
                .id(1)
                .recipe(expectedRecipe)
                .device(expectedDevice1)
                .build();
        DeviceForRecipe expectedDeviceForRecipe2 = DeviceForRecipe.builder()
                .id(2)
                .recipe(expectedRecipe)
                .device(expectedDevice2)
                .build();
        DeviceForRecipe expectedDeviceForRecipe3 = DeviceForRecipe.builder()
                .id(3)
                .recipe(expectedRecipe)
                .device(expectedDevice3)
                .build();

        assertThat(deviceForRecipeRepository.findAll().size()).isEqualTo(EXISTING_DEVICE_COUNT);
        assertThat(deviceForRecipeRepository.findAll())
                .containsExactlyInAnyOrder(expectedDeviceForRecipe1, expectedDeviceForRecipe2, expectedDeviceForRecipe3);
    }

    @DisplayName("должен возвращать связку по id")
    @Test
    void shouldGetDeviceForRecipeById() {

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

        Device expectedDevice1 = Device.builder()
                .id(1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        DeviceForRecipe expectedDeviceForRecipe1 = DeviceForRecipe.builder()
                .id(EXISTING_ID1)
                .recipe(expectedRecipe)
                .device(expectedDevice1)
                .build();

        DeviceForRecipe actualDeviceForRecipe = deviceForRecipeRepository.getById(EXISTING_ID1);

        assertThat(actualDeviceForRecipe).isEqualTo(expectedDeviceForRecipe1);
    }

    @DisplayName("должен возвращать связку по id рецепта")
    @Test
    void shouldGetDeviceForRecipeByRecipeId() {

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

        Device expectedDevice1 = Device.builder()
                .id(EXISTING_DEVICE_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();
        Device expectedDevice2 = Device.builder()
                .id(EXISTING_DEVICE_ID2)
                .name(EXISTING_NAME2)
                .my(true)
                .build();
        Device expectedDevice3 = Device.builder()
                .id(EXISTING_DEVICE_ID3)
                .name(EXISTING_NAME3)
                .my(true)
                .build();

        DeviceForRecipe expectedDeviceForRecipe1 = DeviceForRecipe.builder()
                .id(1)
                .recipe(expectedRecipe)
                .device(expectedDevice1)
                .build();
        DeviceForRecipe expectedDeviceForRecipe2 = DeviceForRecipe.builder()
                .id(2)
                .recipe(expectedRecipe)
                .device(expectedDevice2)
                .build();
        DeviceForRecipe expectedDeviceForRecipe3 = DeviceForRecipe.builder()
                .id(3)
                .recipe(expectedRecipe)
                .device(expectedDevice3)
                .build();

        List<DeviceForRecipe> actuaDeviceForRecipe = deviceForRecipeRepository.findByRecipeId(EXISTING_RECIPE_ID1);

        assertThat(deviceForRecipeRepository.findAll())
                .containsExactlyInAnyOrder(expectedDeviceForRecipe1, expectedDeviceForRecipe2, expectedDeviceForRecipe3);
    }

}
