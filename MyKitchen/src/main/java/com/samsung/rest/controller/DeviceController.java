package com.samsung.rest.controller;


import com.samsung.domain.Device;
import com.samsung.rest.dto.DeviceDto;
import com.samsung.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/device")
    public List<DeviceDto> getAllDevice(){

        return deviceService
                .getAll()
                .stream()
                .map(DeviceDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/device")
    public DeviceDto insertAuthor(@RequestBody DeviceDto deviceDto){

        Device device = deviceService.insert(DeviceDto.toDomainObject(deviceDto));

        return DeviceDto.toDto(device);
    }

    @PutMapping("/device/{id}")
    public DeviceDto updateAuthor(@PathVariable int id,
                                  @RequestParam String name,
                                  @RequestParam boolean my){

        Device device = deviceService.update(id, name, my);

        return DeviceDto.toDto(device);

    }

    @DeleteMapping("/device/{id}")
    public void deleteDevice(@PathVariable int id){

        deviceService.deleteById(id);
    }

    @GetMapping("/device/{id}")
    public DeviceDto getDeviceById(@PathVariable int id){

        Device device = deviceService.getById(id);

        return DeviceDto.toDto(device);
    }
}
