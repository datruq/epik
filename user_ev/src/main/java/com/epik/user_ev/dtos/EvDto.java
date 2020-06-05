package com.epik.user_ev.dtos;

import java.util.List;

public class EvDto {
    private Long id;
    private int model;
    private int batteryCapacity;
    private List<UserDto> userDtos;

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    public Long getId() {
        return id;
    }

    public int getModel() {
        return model;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public List<UserDto> getUserDtos() {
        return userDtos;
    }
}
