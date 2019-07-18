package com.oocl.grow.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {
    /**
     * 将时间格式化为(yyyy.MM.dd)
     * @param localDateTime
     * @return
     */
    public static String formatLocalDateTime(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return formatter.format(LocalDateTime.parse(localDateTime,df));
    }

    /**
     * 将时间格式化为(yyyy.MM.dd)
     * @param localDateTime
     * @return
     */
    public static String formatLocalDateTimeToCn(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return formatter.format(LocalDateTime.parse(localDateTime,df));
    }

    /**
     * 将时间格式化为(yyyy.MM.dd)
     * @param localDateTime
     * @return
     */
    public static LocalDateTime formatStringToLocalTime(String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(localDateTime,formatter);
    }

    /**
     * 将时间格式化为(yyyy.MM.dd)
     * @param localDateTime
     * @return
     */
    public static String formatCNToLocalTime(String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        return String.valueOf(LocalDate.parse(localDateTime,formatter));
    }

}
