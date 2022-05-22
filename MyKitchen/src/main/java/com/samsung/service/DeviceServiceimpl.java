package com.samsung.service;

import com.samsung.domain.Device;
import com.samsung.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceimpl implements DeviceService{

    private final DeviceRepository deviceRepository;

    @Override
    public Device insert(Device device) {


        return deviceRepository.save(device);
    }

    @Override
    public List<Device> getAll() {


        return deviceRepository.findAll();
    }

    @Override
    public Device getById(int id) {


        return deviceRepository.getById(id);
    }

    @Override
    public Device getByName(String name) {

        return deviceRepository.findByName(name);
    }

    @Override
    public Device update(int id, String nameDevice, boolean my) {

        Device device = Device.builder()
                .id(id)
                .name(nameDevice)
                .my(my)
                .build();


        return deviceRepository.save(device);
    }

    @Override
    public void deleteById(int id) {

        deviceRepository.deleteById(id);

    }

    @Override
    public List<Device> getByMy(boolean my) {


        return deviceRepository.findByMy(my);
    }
}
