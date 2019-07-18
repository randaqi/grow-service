package com.oocl.grow.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
public class ObjectDetailDto {

    private String description;

    private String keyResults;

    private String reason;

    private String statusAndBlock;

    private String waysToCrossBlocks;

    private String beginDate;

    private String endDate;

    private String imgsPath;
}
