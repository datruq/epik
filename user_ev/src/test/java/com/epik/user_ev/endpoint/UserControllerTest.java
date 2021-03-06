package com.epik.user_ev.endpoint;

import com.epik.user_ev.dtos.UserDto;
import com.epik.user_ev.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    private static final String USER_NAME = "TEST";
    private static final String USER_LAST_NAME = "USER";
    private static final String USER_EMAIL = "t.user@nuvve.com";
    private static final Long FAKE_ID = -1L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userServiceMock;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String json;
    private UserDto userDto;

    @Before
    public void setUp() throws Exception {
        userDto = new UserDto();
        userDto.setId(FAKE_ID);
        userDto.setName(USER_NAME);
        userDto.setLastName(USER_LAST_NAME);
        userDto.setEmail(USER_EMAIL);
        userDto.setEvId(FAKE_ID);

        json = objectMapper.writeValueAsString(userDto);
    }

    @Test
    public void createTest() throws Exception{
        Mockito.when(userServiceMock.saveUser(Mockito.any())).thenReturn(userDto);
        MvcResult result = mockMvc.perform(post("/user/")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().is2xxSuccessful()).andReturn();

    }

    @Test
    public void getTest() throws Exception{
        Mockito.when(userServiceMock.findById(Mockito.anyLong())).thenReturn(userDto);
        mockMvc.perform(get("/user/" + userDto.getId())
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void updateTest() throws Exception{
        Mockito.when(userServiceMock.updateUser(Mockito.any())).thenReturn(userDto);
        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteTest() throws Exception{
        Mockito.when(userServiceMock.deleteById(Mockito.anyLong())).thenReturn(true);
        mockMvc.perform(delete("/user/" + userDto.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

}
