package com.oocl.grow.repository;

import com.oocl.grow.model.WeeklyPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WeeklyPlanRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private WeeklyPlanRepository weeklyPlanRepository;

    @Test

    public void add_new_Weekly_plan_successfully(){
        for (int i = 0; i < 4; i++) {
            testEntityManager.persist(WeeklyPlan.builder().build());
            testEntityManager.flush();
        }
        List<WeeklyPlan> weeklyPlans = weeklyPlanRepository.findAll();
        assertThat(weeklyPlans.size()).isEqualTo(4);
        assertThat(weeklyPlans.get(3).getWeeklyPlanId()).isEqualTo(4);
    }

    @Test
    public void return_NULL_when_not_find_Weekly_Plan_by_id(){
        WeeklyPlan weeklyPlan = WeeklyPlan.builder().build();
        testEntityManager.persist(weeklyPlan);
        testEntityManager.flush();
        assertThat(weeklyPlanRepository.findByWeeklyPlanId(2)).isNull();
    }
}
