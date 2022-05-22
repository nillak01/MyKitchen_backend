package com.samsung.rest.dto;


import com.samsung.domain.Device;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceDto {


    private int id;

    private String name;

    private boolean my;

    public static DeviceDto toDto(Device device) {

        return new DeviceDto(
                device.getId(),
                device.getName(),
                device.isMy()
        );
    }

    public static Device toDomainObject(DeviceDto deviceDto) {

        return new Device(
                deviceDto.getId(),
                deviceDto.getName(),
                deviceDto.isMy()

        );
    }
}
