package com.zzh.util.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author zhihao zhang
 * @since 2019-04-10
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    String name;
    int age;
}
