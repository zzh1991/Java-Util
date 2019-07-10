package vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author zhihao zhang
 * @date 2019-04-10
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
