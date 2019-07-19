package com.oocl.grow.service;

import com.oocl.grow.model.Task;
import com.oocl.grow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByWeeklyPlanId(Integer id) {

        return taskRepository.findAllByWeeklyPlanId(id);
    }

    @Override
    public Task createATask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteATask(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateATask(Task task) {
        return taskRepository.save(task);
    }
}
