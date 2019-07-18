package com.oocl.grow.service;

import com.oocl.grow.model.WeeklyPlan;
import com.oocl.grow.repository.WeeklyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeeklyPlanServiceImpl implements WeeklyPlanService {
    @Autowired
    private WeeklyPlanRepository weeklyPlanRepository;

    @Override
    public WeeklyPlan getWeeklyPlanByWeeklyPlanId(int weeklyPlanId) {
        return weeklyPlanRepository.findByWeeklyPlanId(weeklyPlanId);
    }

    @Override
    public List<WeeklyPlan> getAllWeeklyPlan() {
        return weeklyPlanRepository.findAll();
    }
}
