package com.epik.user_ev.mapper;

import com.epik.user_ev.domain.User;
import com.epik.user_ev.dto.EvDto;
import com.epik.user_ev.dto.UserDto;
import com.epik.user_ev.services.EvService;
import com.epik.user_ev.services.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private EvService evService;

    @Autowired
    private EvMapper evMapper;

    public User toEntity(UserDto dto) {
        User userEntity = new User();
        userEntity.setName(dto.getName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        EvDto evDto = evService.findById(dto.getEvId());
        if (null != evDto) {
            userEntity.setEv(evMapper.toEntity(evDto));
        }else{
            throw new Error("EV_NOT_FOUND");
        }
        return userEntity;
    }

    public UserDto toDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setName(entity.getName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setEvId(entity.getEv().getId());
        return userDto;
    }
}
