package com.zzh.util.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzh.util.vo.TimeVo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    void testLocalDateAndTimeFormat() throws JsonProcessingException {
        TimeVo timeVo = TimeVo.builder().build();
        String timeVoString = TimeUtil.MAPPER.writeValueAsString(timeVo);
        TimeVo timeVoObject = TimeUtil.MAPPER.readValue(timeVoString, TimeVo.class);

        assertThat(timeVoObject).isEqualTo(timeVo);
    }
}