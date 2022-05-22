package com.samsung.repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.samsung.domain.Device;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DeviceRepositoryTest {

    public static final int EXISTING_DEVICE_COUNT = 7;
    public static final int EXISTING_ID1 = 1;
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final int EXISTING_ID4 = 4;
    public static final int EXISTING_ID5 = 5;
    public static final int EXISTING_ID6 = 6;
    public static final int EXISTING_ID7 = 7;
    public static final String EXISTING_NAME1 = "Половник";
    public static final String EXISTING_NAME2 = "Кастрюла на литр";
    public static final String EXISTING_NAME3 = "Ложка";
    public static final String EXISTING_NAME4 = "Мультиварка";
    public static final String EXISTING_NAME5 = "Кастрюла на 3 литра";
    public static final String EXISTING_NAME6 = "Кастрюла на 5 литров";
    public static final String EXISTING_NAME7 = "Газованя или эл плита";
    public static final boolean EXISTING_MY1 = true;
    public static final boolean EXISTING_MY2 = true;
    public static final boolean EXISTING_MY3 = false;
    public static final boolean EXISTING_MY4 = true;
    public static final boolean EXISTING_MY5 = true;
    public static final boolean EXISTING_MY6 = true;
    public static final boolean EXISTING_MY7 = true;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DeviceRepository deviceRepository;

    @DisplayName("должен добавлять прибор")
    @Test
    void shouldInsertDevice() {

        Device expectedDevice = Device.builder()
                .id(8)
                .name("Кракозябра")
                .my(false)
                .build();

        deviceRepository.save(expectedDevice);
        Device actualDevice = deviceRepository.getById(8);

        assertThat(actualDevice).isEqualTo(expectedDevice);
    }

    @Test
    @DisplayName("должен удалять прибор по id")
    void shouldDeleteDeviceById() {

        int size = deviceRepository.findAll().size();

        deviceRepository.deleteById(2);

        entityManager.flush();
        int size1 = deviceRepository.findAll().size();

        assertThat(size).isEqualTo(size1 + 1);
    }


    @DisplayName("должен обновлять прибор")
    @Test
    void shouldUpdateDevice() {
        Device expectedDevice1 = Device.builder()
                .id(EXISTING_ID1)
                .name("Ivan")
                .my(true)
                .build();

        deviceRepository.save(expectedDevice1);
        Device actualDevice = deviceRepository.getById(EXISTING_ID1);

        assertThat(actualDevice).isEqualTo(expectedDevice1);
    }

    @DisplayName("должен возвращать все приборы")
    @Test
    void shouldGetAllDevices() {

        Device expectedDevice1 = Device.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();
        Device expectedDevice2 = Device.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY2)
                .build();

        Device expectedDevice3 = Device.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY3)
                .build();
        Device expectedDevice4 = Device.builder()
                .id(EXISTING_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY4)
                .build();
        Device expectedDevice5 = Device.builder()
                .id(EXISTING_ID5)
                .name(EXISTING_NAME5)
                .my(EXISTING_MY5)
                .build();
        Device expectedDevice6 = Device.builder()
                .id(EXISTING_ID6)
                .name(EXISTING_NAME6)
                .my(EXISTING_MY6)
                .build();
        Device expectedDevice7 = Device.builder()
                .id(EXISTING_ID7)
                .name(EXISTING_NAME7)
                .my(EXISTING_MY7)
                .build();

        assertThat(deviceRepository.findAll().size()).isEqualTo(EXISTING_DEVICE_COUNT);
        assertThat(deviceRepository.findAll())
                .containsExactlyInAnyOrder(expectedDevice1, expectedDevice2, expectedDevice3, expectedDevice4, expectedDevice5, expectedDevice6, expectedDevice7);
    }

    @DisplayName("должен возвращать прибор по id")
    @Test
    void shouldGetDeviceById() {

        Device expectedDevice = Device.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        Device actualDevice = deviceRepository.getById(EXISTING_ID1);

        assertThat(actualDevice).isEqualTo(expectedDevice);
    }

    @DisplayName("должен возвращать прибор по названию")
    @Test
    void shouldGetDeviceByName() {

        Device expectedDevice = Device.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        Device actualDevice = deviceRepository.findByName(EXISTING_NAME1);

        assertThat(actualDevice).isEqualTo(expectedDevice);
    }

    @DisplayName("должен возвращать прибор по наличию у меня")
    @Test
    void shouldGetDeviceMy() {

        Device expectedDevice1 = Device.builder()
                .id(EXISTING_ID1)
                .name(EXISTING_NAME1)
                .my(EXISTING_MY1)
                .build();

        Device expectedDevice2 = Device.builder()
                .id(EXISTING_ID2)
                .name(EXISTING_NAME2)
                .my(EXISTING_MY2)
                .build();

        Device expectedDevice3 = Device.builder()
                .id(EXISTING_ID3)
                .name(EXISTING_NAME3)
                .my(EXISTING_MY3)
                .build();
        Device expectedDevice4 = Device.builder()
                .id(EXISTING_ID4)
                .name(EXISTING_NAME4)
                .my(EXISTING_MY4)
                .build();
        Device expectedDevice5 = Device.builder()
                .id(EXISTING_ID5)
                .name(EXISTING_NAME5)
                .my(EXISTING_MY5)
                .build();
        Device expectedDevice6 = Device.builder()
                .id(EXISTING_ID6)
                .name(EXISTING_NAME6)
                .my(EXISTING_MY6)
                .build();
        Device expectedDevice7 = Device.builder()
                .id(EXISTING_ID7)
                .name(EXISTING_NAME7)
                .my(EXISTING_MY7)
                .build();

        List<Device> actualProduct = deviceRepository.findByMy(true);

        assertThat(actualProduct).containsExactlyInAnyOrder(expectedDevice1, expectedDevice2, expectedDevice4, expectedDevice5, expectedDevice6, expectedDevice7);
    }


}
