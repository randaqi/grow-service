package com.oocl.grow.controller;

import com.oocl.grow.model.Task;
import com.oocl.grow.model.WeeklyPlan;
import com.oocl.grow.repository.WeeklyPlanRepository;
import com.oocl.grow.service.TaskService;
import com.oocl.grow.service.WeeklyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/weeklyPlans")
public class WeeklyPlanRestController {

    @Autowired
    private WeeklyPlanService weeklyPlanService;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<WeeklyPlan> getAllWeeklyPlans() {
        return weeklyPlanService.getAllWeeklyPlan();
    }

    @GetMapping("/{id}")
    public List<Task> getWeeklyPlan(@PathVariable Integer id) {
        return taskService.getTasksByWeeklyPlanId(id);
    }

    @GetMapping("/info/{id}")
    public WeeklyPlan getWeeklyPlanInfo(@PathVariable Integer id) {
        return weeklyPlanService.getWeeklyPlanByWeeklyPlanId(id);
    }

    @PutMapping("/update/{id}/{percent}")
    public WeeklyPlan updateCompletionPercent(@PathVariable Float percent, @PathVariable int id) {
        return weeklyPlanService.updateWeeklyPlan(id, percent);
    }

    @GetMapping("/current/{time}")
    public List<Task> getCurrentWeeklyPlan(@PathVariable Integer time) {
        WeeklyPlan weeklyPlan = weeklyPlanService.getWeeklyPlanByTime(time);
        return taskService.getTasksByWeeklyPlanId(weeklyPlan.getWeeklyPlanId());
    }
}
