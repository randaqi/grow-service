package com.oocl.grow.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.Task;
import com.oocl.grow.repository.TaskRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class TaskApiTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void giveTasks_whenGetTasksByWeeklyPlanId_thenStatus200() throws Exception{

        createTask();

        mvc.perform(get("/tasks/weeklyPlans/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].desc", is("???")));


    }

    private void createTask() {
        Task task= new Task();
        task.setDesc("???");
        task.setWeeklyPlanId(1);
        taskRepository.save(task);
    }

    @Test
    public void givenTask_whenPostTask_thenReturnTask() throws Exception {
        Task task = new Task();
        task.setDesc("what?");

        mvc.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.desc", is("what?")));
    }
}
