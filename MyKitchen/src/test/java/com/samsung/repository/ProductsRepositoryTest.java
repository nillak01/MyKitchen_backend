package com.samsung.repository;




import com.samsung.domain.Products;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductsRepositoryTest {

    public static final int EXISTING_DEVICE_COUNT = 8;
    public static final int EXISTING_ID1 = 1;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final int EXISTING_ID4 = 4;
    public static final int EXISTING_ID5 = 5;
    public static final int EXISTING_ID6 = 6;
    public static final int EXISTING_ID7 = 7;
    public static final int EXISTING_ID8 = 8;
    public static final String EXISTING_NAME1 = "Помидоры";
    public static final String EXISTING_NAME2 = "Огурцы";
    public static final String EXISTING_NAME3 = "Картошка";
    public static final String EXISTING_NAME4 = "Лук";
    public static final String EXISTING_NAME5 = "Марковь";
    public static final String EXISTING_NAME6 = "Курица";
    public static final String EXISTING_NAME7 = "Говядина";
    public static final String EXISTING_NAME8 = "Броколи";
    public static final boolean EXISTING_MY1 = true;
    public static final boolean EXISTING_MY2 = false;
    public static final boolean EXISTING_MY3 = true;
    public static final boolean EXISTING_MY4 = true;
    public static final boolean EXISTING_MY5 = true;
    public static final boolean EXISTING_MY6 = true;
    public static final boolean EXISTING_MY7 = true;
    public static final boolean EXISTING_MY8 = true;
    public static final int EXISTING_WEIGHT1 = 10000;
    public static final int EXISTING_WEIGHT2 = 1000;
    public static final int EXISTING_WEIGHT3 = 10000;
    public static final int EXISTING_WEIGHT4 = 500;
    public static final int EXISTING_WEIGHT5 = 3000;
    public static final int EXISTING_WEIGHT6 = 1000;
    public static final int EXISTING_WEIGHT7 = 500;
    public static final int EXISTING_WEIGHT8 = 1000;


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductsRepository productsRepository;

    @DisplayName("должен добавлять продукт")
    @Test
    void shouldInsertProduct() {

        Products expectedProduct = Products.builder()
                .id(4)
                .name("Кракозябра")
                .my(false)
                .weight(666)
                .build();

        productsRepository.save(expectedProduct);
        Products actualProducts = productsRepository.getById(4);

        assertThat(actualProducts).isEqualTo(expectedProduct);
    }

    @Test
    @DisplayName("должен удалять продукт по id")
    void shouldDeleteProductById() {

        int size = productsRepository.findAll().size();

        productsRepository.deleteById(2);

        entityManager.flush();
        int size1 = productsRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);
    }


    @DisplayName("должен обновлять продукт")
    @Test
    void shouldUpdateProduct() {
        Products expectedProducts1 = Products.builder()
                .id(EXISTING_ID1)
                .name("Ivan")
                .my(true)
                .weight(EXISTING_WEIGHT1)
                .build();

        productsRepository.save(expectedProducts1);
        Products actualProducts = productsRepository.getById(EXISTING_ID1);

        assertThat(actualProducts).isEqualTo(expectedProducts1);
    }

    @DisplayName("должен возвращать все продукты")
    @Test
    void shouldGetAllProducts() {

        Products expectedProduct1 = Products.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_WEIGHT1)
                .build();
        Products expectedProduct2 = Products.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY2)
                .weight(EXISTING_WEIGHT2)
                .build();
        Products expectedProduct3 = Products.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY3)
                .weight(EXISTING_WEIGHT3)
                .build();
        Products expectedProduct4 = Products.builder()
                .id(EXISTING_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY4)
                .weight(EXISTING_WEIGHT4)
                .build();
        Products expectedProduct5 = Products.builder()
                .id(EXISTING_ID5)
                .name(EXISTING_NAME5)
                .my(EXISTING_MY5)
                .weight(EXISTING_WEIGHT5)
                .build();
        Products expectedProduct6 = Products.builder()
                .id(EXISTING_ID6)
                .name(EXISTING_NAME6)
                .my(EXISTING_MY6)
                .weight(EXISTING_WEIGHT6)
                .build();
        Products expectedProduct7 = Products.builder()
                .id(EXISTING_ID7)
                .name(EXISTING_NAME7)
                .my(EXISTING_MY7)
                .weight(EXISTING_WEIGHT7)
                .build();
        Products expectedProduct8 = Products.builder()
                .id(EXISTING_ID8)
                .name(EXISTING_NAME8)
                .my(EXISTING_MY8)
                .weight(EXISTING_WEIGHT8)
                .build();


        assertThat(productsRepository.findAll().size()).isEqualTo(EXISTING_DEVICE_COUNT);
        assertThat(productsRepository.findAll())
                .containsExactlyInAnyOrder(expectedProduct1, expectedProduct2, expectedProduct3,expectedProduct4, expectedProduct5, expectedProduct6,expectedProduct7, expectedProduct8);
    }

    @DisplayName("должен возвращать продукт по id")
    @Test
    void shouldGetProductById() {

        Products expectedProduct = Products.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_WEIGHT1)
                .build();

        Products actualProduct = productsRepository.getById(EXISTING_ID1);

        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @DisplayName("должен возвращать продукт по названию")
    @Test
    void shouldGetProductByName() {

        Products expectedProduct = Products.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_WEIGHT1)
                .build();

        Products actualProduct = productsRepository.findByName(EXISTING_NAME1);

        assertThat(actualProduct).isEqualTo(expectedProduct);
    }

    @DisplayName("должен возвращать продукт по наличию у меня")
    @Test
    void shouldGetProductMy() {

        Products expectedProduct1 = Products.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .weight(EXISTING_WEIGHT1)
                .build();
        Products expectedProduct2 = Products.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY2)
                .weight(EXISTING_WEIGHT2)
                .build();
        Products expectedProduct3 = Products.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY3)
                .weight(EXISTING_WEIGHT3)
                .build();
        Products expectedProduct4 = Products.builder()
                .id(EXISTING_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY4)
                .weight(EXISTING_WEIGHT4)
                .build();
        Products expectedProduct5 = Products.builder()
                .id(EXISTING_ID5)
                .name(EXISTING_NAME5)
                .my(EXISTING_MY5)
                .weight(EXISTING_WEIGHT5)
                .build();
        Products expectedProduct6 = Products.builder()
                .id(EXISTING_ID6)
                .name(EXISTING_NAME6)
                .my(EXISTING_MY6)
                .weight(EXISTING_WEIGHT6)
                .build();
        Products expectedProduct7 = Products.builder()
                .id(EXISTING_ID7)
                .name(EXISTING_NAME7)
                .my(EXISTING_MY7)
                .weight(EXISTING_WEIGHT7)
                .build();
        Products expectedProduct8 = Products.builder()
                .id(EXISTING_ID8)
                .name(EXISTING_NAME8)
                .my(EXISTING_MY8)
                .weight(EXISTING_WEIGHT8)
                .build();

        List<Products> actualProduct = productsRepository.findByMy(true);

        assertThat(actualProduct).containsExactlyInAnyOrder(expectedProduct1, expectedProduct3,expectedProduct4, expectedProduct5, expectedProduct6,expectedProduct7, expectedProduct8);
    }



}
