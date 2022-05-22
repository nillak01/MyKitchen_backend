package com.samsung.service;

import com.samsung.domain.Device;

import java.util.List;

public interface DeviceService {

    Device insert(Device device);

    List<Device> getAll();

    Device getById(int id);

    Device getByName(String name);

    Device update(int id, String nameDevice, boolean my);

    void deleteById(int id);

    List<Device> getByMy(boolean my);
}
