package com.oocl.grow.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.Task;
import com.oocl.grow.model.WeeklyPlan;
import com.oocl.grow.repository.TaskRepository;
import com.oocl.grow.repository.WeeklyPlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WeeklyPlanApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WeeklyPlanRepository weeklyPlanRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void givenWeeklyPlan_whenGetWeeklyPlan_thenReturn200()
            throws Exception {
        createTestWeeklyPlan(1);
        mvc.perform(get("/weeklyPlans/info/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.weeklyPlanId", is(1)));
    }

    @Test
    public void return_tasks_when_find_Weekly_Plan_by_id()
            throws Exception {
        createTestWeeklyPlan(1);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Task task = new Task();
            task.setWeeklyPlanId(1);
            task.setDesc("task" + i);
            tasks.add(task);
            taskRepository.save(task);
        }
        mvc.perform(get("/weeklyPlans/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[3].id", is(4)));
    }

    @Test
    public void given_idAndPercent_toUpdateWeeklyPlan()
            throws Exception {
        createTestWeeklyPlan(1);
        weeklyPlanRepository.findByWeeklyPlanId(1).setCompletionPercent(0.5f);
        mvc.perform(MockMvcRequestBuilders.put("/weeklyPlans/update/1/0.8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.completionPercent", is(0.8)));
    }

    @Test
    public void getCurrentWeeklyPlan() throws Exception {
        weeklyPlanRepository.saveAndFlush(WeeklyPlan.builder().weeklyPlanId(1).time(3).build());
        for (int i = 0; i < 4; i++) {
            Task task = Task.builder().weeklyPlanId(1).desc("").build();
            taskRepository.saveAndFlush(task);
        }
        mvc.perform(MockMvcRequestBuilders.get("/weeklyPlans/current/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[3].id", is(4)));
    }

    private void createTestWeeklyPlan(int weeklyPlanId) {
        WeeklyPlan weeklyPlan = WeeklyPlan.builder().weeklyPlanId(weeklyPlanId).build();
        weeklyPlanRepository.save(weeklyPlan);
    }
}
