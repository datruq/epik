package com.epik.user_ev.services;

import com.epik.user_ev.dto.UserDto;
import com.epik.user_ev.mapper.EvMapper;
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

    @Autowired
    private EvMapper evMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> mapper.toDto(user)).collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        try {
            var entity = userRepository.findById(id);
            if (entity.isPresent()) {
                return mapper.toDto(entity.get());
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto saveUser(UserDto user) {
        try {
            var entity = userRepository.save(mapper.toEntity(user));
            return mapper.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }

    public UserDto updateUser(UserDto user) {
        try {
            var entity = userRepository.getOne(user.getId());
            entity.setName(user.getName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            return mapper.toDto(userRepository.save(entity));
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<UserDto> findAllByEvId(Long evId) {
        return userRepository.findAllByEvId(evId).stream().map(user -> mapper.toDto(user)).collect(Collectors.toList());
    }

}
