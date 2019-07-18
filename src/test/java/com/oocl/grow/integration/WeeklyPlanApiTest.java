package com.oocl.grow.integration;

import com.oocl.grow.GrowApplication;
import com.oocl.grow.model.WeeklyPlan;
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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = GrowApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class WeeklyPlanApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private WeeklyPlanRepository weeklyPlanRepository;

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    public void givenWeeklyPlan_whenGetWeeklyPlan_thenReturn200()
            throws Exception{
        createTestWeeklyPlan(1);
        mvc.perform(get("/weeklyPlans/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.weeklyPlanId", is(1)));
    }

    private void createTestWeeklyPlan(int weeklyPlanId) {
        WeeklyPlan weeklyPlan = WeeklyPlan.builder().weeklyPlanId(weeklyPlanId).build();
        weeklyPlanRepository.save(weeklyPlan);
    }
}
