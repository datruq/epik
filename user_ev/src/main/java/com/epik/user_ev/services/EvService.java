package com.epik.user_ev.services;

import com.epik.user_ev.domains.Ev;
import com.epik.user_ev.dtos.EvDto;
import com.epik.user_ev.mappers.EvMapper;
import com.epik.user_ev.persistence.EvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvService {

    @Autowired
    private EvRepository evRepository;

    @Autowired
    private EvMapper mapper;

    public List<EvDto> findAll() {
        return evRepository.findAll().stream().map(user -> mapper.toDto(user)).collect(Collectors.toList());
    }

    public EvDto findById(Long id) {
        try {
            var entity = evRepository.findById(id);
            if (entity.isPresent()){
                return mapper.toDto(entity.get());
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    public EvDto saveEv(EvDto user) {
        try {
            var entity = evRepository.save(mapper.toEntity(user));
            return mapper.toDto(entity);
        } catch (Exception e) {
            return null;
        }
    }

    public EvDto updateEv(EvDto dto) {
        try {
            var entity = evRepository.getOne(dto.getId());
            entity.setModel(Ev.MODEL.fromValue(dto.getModel()));
            entity.setBatteryCapacity(Ev.BATTERY_CAPACITY.fromValue(dto.getBatteryCapacity()));
            return mapper.toDto(evRepository.save(entity));
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteById(Long id) {
        try {
            evRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public EvDto findByUserEmail(String email){
        var entity = evRepository.findByUserEmail(email);
        if (entity.isPresent()){
            return mapper.toDto(entity.get());
        }else{
            return null;
        }

    }
}
