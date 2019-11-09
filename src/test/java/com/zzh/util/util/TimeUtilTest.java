package com.zzh.util.util;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

class TimeUtilTest {
    private static final LocalDateTime dateTime =
            LocalDateTime.of(2019, 4, 10, 21, 30, 0);

    @Test
    void getTimeByTimestamp() {
        assertThat(TimeUtil.getTimeByTimestamp(
                TimeUtil.getMillisecondsByLocalDateTime(dateTime)
        )).isEqualTo("2019-04-10 21:30:00 UTC+08:00");
    }

    @Test
    void getMillisecondsByLocalDateTime() {
        assertThat(TimeUtil.getMillisecondsByLocalDateTime(dateTime))
                .isEqualTo(1554903000000L);
    }
}