package com.epik.user_ev.services;

import com.epik.user_ev.dto.UserDto;
import com.epik.user_ev.mapper.UserMapper;
import com.epik.user_ev.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> mapper.toDto(user)).collect(Collectors.toList());
    }

    public Boolean saveUser(UserDto user) {
        try {
            userRepository.save(mapper.toEntity(user));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserDto findByEmail(UserDto user) {
        return mapper.toDto(userRepository.findByEmail(user.getEmail()));
    }
}
