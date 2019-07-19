package com.oocl.grow.integration;

import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.Object;
import com.oocl.grow.repository.ObjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ObjectTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectRepository repository;
    @Test
    public void giveObject_whenGetObjectById_thenStatus200() throws Exception{
        Object object = new Object();
        object.setDescription("description");
        object.setKeyResults("keyResults");
        object.setReason("reason");
        object.setStatusAndBlock("fjkflalk");
        object.setWaysToCrossBlocks("ways");
        object.setBeginDate("2018-01-01");
        object.setEndDate("2020-02-02");
        object.setImgsPath("1.jpg");
        repository.save(object);
        mvc.perform(get("/object/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description", is("description")));
    }
}
