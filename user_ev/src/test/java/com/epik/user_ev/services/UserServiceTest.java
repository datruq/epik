package com.epik.user_ev.services;

import com.epik.user_ev.domain.Ev;
import com.epik.user_ev.domain.User;
import com.epik.user_ev.dto.EvDto;
import com.epik.user_ev.dto.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private EvService evService;

    private EvDto ev;
    private UserDto user;

    @Before
    public void setUp(){
        ev = new EvDto();
        ev.setModel(Ev.MODEL.BUS.ordinal());
        ev.setBatteryCapacity(Ev.BATTERY_CAPACITY.SEVENTY_KWH.ordinal());
        evService.saveEv(ev);

        user = new UserDto();
        user.setName("keep");
        user.setLastName("testing");
        user.setEmail("k.testing@nuvve.com");
        user.setId(ev.getId());

    }

    @Test
    public void crudTest(){
        UserDto fromDB = userService.saveUser(user);
        Assert.assertEquals(fromDB.getName(), user.getName());
        Assert.assertEquals(fromDB.getLastName(), user.getLastName());
        Assert.assertEquals(fromDB.getEmail(), user.getEmail());
        Assert.assertEquals(fromDB.getEvId(), user.getEvId());
    }
}
