package com.zzh.util.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhihao zhang
 * @since 4/13/20
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeVo {
    @Builder.Default
    private LocalDate localDate = LocalDate.of(2020, 4, 13);

    @Builder.Default
    private LocalDateTime localDateTime = LocalDateTime.of(2020, 4, 13, 12, 0, 0);
}
