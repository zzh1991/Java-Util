package com.zzh.util.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhihao zhang
 * @date 2019-04-10
 */

@UtilityClass
public class TimeUtil {

    public String getTimeByTimestamp(long timestamp) {
        DateTimeFormatter zonedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return zonedFormatter.format(ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("UTC+8")));
    }

    public long getMillisecondsByLocalDateTime(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    
    public boolean isTimeAfter(ZonedDateTime dateTime, ZonedDateTime baseDateTime) {
        return dateTime.compareTo(baseDateTime) > 0;
    }
}
