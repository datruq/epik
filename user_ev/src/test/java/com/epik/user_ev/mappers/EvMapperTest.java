package com.epik.user_ev.mappers;

import com.epik.user_ev.domains.Ev;
import com.epik.user_ev.dtos.EvDto;
import com.epik.user_ev.dtos.UserDto;
import com.epik.user_ev.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EvMapperTest {

    private static final int BUS_MODEL = 0;
    private static final int THIRTY_KWH = 0;

    @MockBean
    private UserService userServiceMock;

    @Autowired
    private EvMapper mapper;
    private EvDto dto;
    private Ev entity;

    @Test
    public void toEntity() {
        setUpDto();
        Ev ev = mapper.toEntity(dto);
        Assert.assertEquals(ev.getModel().ordinal(), dto.getModel());
        Assert.assertEquals(ev.getBatteryCapacity().ordinal(), dto.getBatteryCapacity());
    }

    @Test
    public void toDto() {
        setUpEntity();
        EvDto evDto = mapper.toDto(entity);
        Assert.assertEquals(evDto.getModel(), entity.getModel().ordinal());
        Assert.assertEquals(evDto.getBatteryCapacity(), entity.getBatteryCapacity().ordinal());
    }

    private void setUpEntity() {
        entity = new Ev();
        entity.setModel(Ev.MODEL.BUS);
        entity.setBatteryCapacity(Ev.BATTERY_CAPACITY.THIRTY_KWH);
        setUpUserDto();
    }

    private void setUpDto() {
        dto = new EvDto();
        dto.setModel(BUS_MODEL);
        dto.setBatteryCapacity(THIRTY_KWH);
    }

    private void setUpUserDto() {
        List<UserDto> userDtoList = new ArrayList<>();
        Mockito.when(userServiceMock.findAllByEvId(Mockito.anyLong())).thenReturn(userDtoList);
    }
}
