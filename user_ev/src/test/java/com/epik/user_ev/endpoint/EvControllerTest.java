package com.epik.user_ev.endpoint;

import com.epik.user_ev.dtos.EvDto;
import com.epik.user_ev.services.EvService;
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
public class EvControllerTest {

    private static final int BUS_MODEL = 0;
    private static final int THIRTY_KWH = 0;
    private static final Long FAKE_ID = -1L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EvService evServiceMock;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String json;
    private EvDto evDto;

    @Before
    public void setUp() throws Exception {
        evDto = new EvDto();
        evDto.setId(FAKE_ID);
        evDto.setModel(BUS_MODEL);
        evDto.setBatteryCapacity(THIRTY_KWH);

        json = objectMapper.writeValueAsString(evDto);
    }

    @Test
    public void createTest() throws Exception{
        Mockito.when(evServiceMock.saveEv(Mockito.any())).thenReturn(evDto);
        MvcResult result = mockMvc.perform(post("/ev/")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().is2xxSuccessful()).andReturn();

    }

    @Test
    public void getTest() throws Exception{
        Mockito.when(evServiceMock.findById(Mockito.anyLong())).thenReturn(evDto);
        mockMvc.perform(get("/ev/" + evDto.getId())
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void updateTest() throws Exception{
        Mockito.when(evServiceMock.updateEv(Mockito.any())).thenReturn(evDto);
        mockMvc.perform(put("/ev")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void deleteTest() throws Exception{
        Mockito.when(evServiceMock.deleteById(Mockito.anyLong())).thenReturn(true);
        mockMvc.perform(delete("/ev/" + evDto.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}
