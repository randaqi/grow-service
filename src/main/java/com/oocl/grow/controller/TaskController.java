package com.oocl.grow.controller;

import com.oocl.grow.model.Task;
import com.oocl.grow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/weeklyPlans/{weeklyPlanId}")
    public List<Task> getTaskListByWeeklyPlanId(@PathVariable("weeklyPlanId") Integer id){
        return taskService.getTasksByWeeklyPlanId(id);
    }

    @PostMapping("/tasks")
    public Task createATask(@RequestBody Task task){
        return taskService.createATask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteATask(@PathVariable("id") Integer id){
        taskService.deleteATask(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateATask(@RequestBody Task task) {
        return taskService.updateATask(task);
    }
}