package com.samsung.repository;

import com.samsung.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    Device findByName(String name);

    List<Device> findByMy(boolean my);
}
