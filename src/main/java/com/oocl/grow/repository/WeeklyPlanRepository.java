package com.oocl.grow.repository;

import com.oocl.grow.model.WeeklyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeeklyPlanRepository extends JpaRepository<WeeklyPlan, Integer> {
    WeeklyPlan findByWeeklyPlanId(Integer id);

    WeeklyPlan findByTime(Integer time);
}
