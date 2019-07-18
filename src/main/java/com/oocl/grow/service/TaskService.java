package com.oocl.grow.service;

import com.oocl.grow.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasksByWeeklyPlanId(Integer id);

    Task createATask(Task task);
}
