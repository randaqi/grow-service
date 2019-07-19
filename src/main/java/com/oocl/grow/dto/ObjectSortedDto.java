package com.oocl.grow.dto;


import lombok.Data;

/**
 * @author MIAOOY2
 */
@Data
public class ObjectSortedDto {
    private Long id;
    private String description;
    private String beginDate;
    private String endDate;
    private Integer restDays;
    private String imgsPath;
    private String keyResults;
    private String reason;
    private String statusAndBlock;
    private String waysToCrossBlocks;
}
