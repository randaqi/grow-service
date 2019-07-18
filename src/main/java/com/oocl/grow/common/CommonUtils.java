package com.oocl.grow.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author MIAOOY2
 */
public class CommonUtils {
    /**
     * 将时间格式化为(yyyy.MM.dd)

     */
    public static String formatLocalDateTime(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return formatter.format(LocalDateTime.parse(localDateTime,df));
    }

    /**
     * 将时间格式化为(yyyy年MM月dd日)

     */
    public static String formatLocalDateTimeToCn(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return formatter.format(LocalDateTime.parse(localDateTime,df));
    }

    /**
     * 将时间格式化为(yyyy-MM-dd HH:mm:ss)
     */
    public static LocalDateTime formatStringToLocalTime(String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(localDateTime,formatter);
    }

    /**
     * 将(yyyy年MM月dd日)转换为(yyyy-MM-dd)
     */
    public static String formatCNToLocalTime(String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return String.valueOf(LocalDate.parse(localDateTime,formatter));
    }

    /**
     *  计算剩余天数
     */
    public static Integer restDays(LocalDateTime beginDate, LocalDateTime endDate){
        Duration duration = Duration.between(beginDate, endDate);
        int daysFlag = (int) (duration.toHours()%24);
        return Math.toIntExact(daysFlag == 0 ? duration.toHours() / 24 : duration.toHours() / 24 + 1);
    }

}
