package com.epik.user_ev.mappers;

import com.epik.user_ev.domains.Ev;
import com.epik.user_ev.dtos.EvDto;
import com.epik.user_ev.dtos.UserDto;
import com.epik.user_ev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EvMapper {

    @Autowired
    private UserService userService;

    public Ev toEntity(EvDto dto){
        Ev evEntity = new Ev();
        evEntity.setId(dto.getId());
        evEntity.setModel(Ev.MODEL.fromValue(dto.getModel()));
        evEntity.setBatteryCapacity(Ev.BATTERY_CAPACITY.fromValue(dto.getBatteryCapacity()));
        return evEntity;
    }

    public EvDto toDto (Ev entity){
        EvDto evDto = new EvDto();
        evDto.setId(entity.getId());
        evDto.setModel(entity.getModel().ordinal());
        evDto.setBatteryCapacity(entity.getBatteryCapacity().ordinal());
        List<UserDto> userDtos = userService.findAllByEvId(entity.getId());
        evDto.setUserDtos(userDtos);
        return evDto;
    }

}
