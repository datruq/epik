package com.epik.user_ev.mappers;

import com.epik.user_ev.domains.Ev;
import com.epik.user_ev.domains.User;
import com.epik.user_ev.dtos.EvDto;
import com.epik.user_ev.dtos.UserDto;
import com.epik.user_ev.services.EvService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    private static final String USER_NAME = "TEST";
    private static final String USER_LAST_NAME = "USER";
    private static final String USER_EMAIL = "t.user@nuvve.com";
    private static final Long FAKE_ID = -1L;
    private static final int BUS_MODEL = 0;
    private static final int THIRTY_KWH = 0;

    @MockBean
    private EvService evServiceMock;

    @Autowired
    private UserMapper mapper;
    private UserDto dto;
    private User entity;
    private Ev evEntity;
    private EvDto evDto;

    @Test
    public void toEntity() {
        setUpDto();
        User user = mapper.toEntity(dto);
        Assert.assertEquals(user.getName(), dto.getName());
        Assert.assertEquals(user.getLastName(), dto.getLastName());
        Assert.assertEquals(user.getEmail(), dto.getEmail());
        Assert.assertEquals(user.getEv().getId(), dto.getEvId());
    }

    @Test
    public void toDto() {
        setUpEntity();
        UserDto userDto = mapper.toDto(entity);
        Assert.assertEquals(userDto.getName(), entity.getName());
        Assert.assertEquals(userDto.getLastName(), entity.getLastName());
        Assert.assertEquals(userDto.getEmail(), entity.getEmail());
        Assert.assertEquals(userDto.getEvId(), entity.getEv().getId());
    }

    private void setUpEntity() {
        evEntity = new Ev();
        evEntity.setId(FAKE_ID);
        evEntity.setModel(Ev.MODEL.BUS);
        evEntity.setBatteryCapacity(Ev.BATTERY_CAPACITY.TEN_KWH);

        entity = new User();
        entity.setName(USER_NAME);
        entity.setLastName(USER_LAST_NAME);
        entity.setEmail(USER_EMAIL);
        entity.setEv(evEntity);
    }

    private void setUpDto() {
        dto = new UserDto();
        dto.setName(USER_NAME);
        dto.setLastName(USER_LAST_NAME);
        dto.setEmail(USER_EMAIL);
        dto.setEvId(FAKE_ID);
        setUpEvDto();
    }

    private void setUpEvDto() {
        evDto = new EvDto();
        evDto.setId(FAKE_ID);
        evDto.setModel(BUS_MODEL);
        evDto.setBatteryCapacity(THIRTY_KWH);
        Mockito.when(evServiceMock.findById(Mockito.anyLong())).thenReturn(evDto);
    }
}
