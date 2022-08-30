package com.zzh.util.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.JsonStream;
import com.jsoniter.spi.DecodingMode;
import com.jsoniter.spi.JsonException;
import com.jsoniter.spi.JsoniterSpi;
import com.zzh.util.vo.TimeVo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testLocalDateAndTimeFormatByJsonIter() {
        TimeVo timeVo = TimeVo.builder().build();
        String timeVoString = JsonStream.serialize(timeVo);

        String finalTimeVoString = timeVoString;
        Exception exception = assertThrows(JsonException.class, () -> JsonIterator.deserialize(finalTimeVoString, TimeVo.class));

        assertThat(exception).isNotNull();

        JsonIterator.setMode(DecodingMode.DYNAMIC_MODE_AND_MATCH_FIELD_STRICTLY);
        JsonStream.setMode(EncodingMode.DYNAMIC_MODE);

        JsoniterSpi.registerTypeEncoder(LocalDate.class, (obj, stream) -> stream.writeVal(obj.toString()));
        JsoniterSpi.registerTypeDecoder(LocalDate.class, iter -> LocalDate.parse(iter.readString()));

        JsoniterSpi.registerTypeEncoder(LocalDateTime.class, (obj, stream) -> stream.writeVal(obj.toString()));
        JsoniterSpi.registerTypeDecoder(LocalDateTime.class, iter -> LocalDateTime.parse(iter.readString()));

        timeVoString = JsonStream.serialize(timeVo);

        TimeVo timeVoObject = JsonIterator.deserialize(timeVoString, TimeVo.class);

        assertThat(timeVoObject).isEqualTo(timeVo);
    }
}