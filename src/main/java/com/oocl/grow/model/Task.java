package com.oocl.grow.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String desc;

    @Column
    private int weeklyPlanId;

    @Column
    private int status;

    @Column
    private int objectiveId;
}
