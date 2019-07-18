package com.oocl.grow.controller;


import com.oocl.grow.model.Task;
import com.oocl.grow.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService service;


    @Test
    public void givenTasks_whenGetTasksByWeeklyPlanId_thenReturnJSONArray() throws Exception{
        Task task = new Task();
        task.setDesc("???");
        List<Task> tasks = asList(task);

        given(service.getTasksByWeeklyPlanId(1)).willReturn(tasks);

        mvc.perform(get("/tasks/weeklyPlans/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].desc", is(task.getDesc())));
    }
}
