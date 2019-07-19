package com.oocl.grow.service;

import com.oocl.grow.model.WeeklyPlan;

import java.util.List;

public interface WeeklyPlanService {
    WeeklyPlan getWeeklyPlanByWeeklyPlanId(int weeklyPlanId);

    List<WeeklyPlan> getAllWeeklyPlan();

    WeeklyPlan updateWeeklyPlan(int weeklyPlanId, float completion_percent);

    WeeklyPlan getWeeklyPlanByTime(int time);
}
