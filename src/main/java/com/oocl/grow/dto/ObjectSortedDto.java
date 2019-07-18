package com.oocl.grow.dto;


import lombok.Data;

@Data
public class ObjectSortedDto {
    private Long id;
    private String description;
    private String beginDate;
    private String endDate;
    private Integer restDays;
    private String imgUrl;
}
