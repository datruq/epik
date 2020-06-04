package com.epik.user_ev.mapper;

import com.epik.user_ev.domain.User;
import com.epik.user_ev.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto dto){
        User userEntity = new User();
        userEntity.setName(dto.getName());
        userEntity.setLastName(dto.getLastName());
        userEntity.setEmail(dto.getEmail());
        return userEntity;
    }

    public UserDto toDto (User entity){
        UserDto userDto = new UserDto();
        userDto.setName(entity.getName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        return userDto;
    }
}
