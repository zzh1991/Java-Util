package com.zzh.util.util;

import com.google.common.collect.Lists;
import com.jsoniter.spi.TypeLiteral;
import org.junit.jupiter.api.Test;
import com.zzh.util.vo.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MapperUtilTest {

    @Test
    void getObjectFromJson() {
        assertThat(
                MapperUtil.getObjectFromJson("[1,2,3]", int[].class)
        ).isEqualTo(new int[]{1, 2, 3});

        assertThat(
                MapperUtil.getObjectFromJson("[1,2,3]", new TypeLiteral<List<Integer>>(){})
        ).isEqualTo(Lists.newArrayList(1, 2, 3));

        assertThat(
                MapperUtil.getObjectFromJson("[]", new TypeLiteral<List<Integer>>(){})
        ).isEqualTo(Lists.newArrayList());

        assertThat(
                MapperUtil.getObjectFromJson("{'name': 'zzh1991', 'age': 18}", Person.class)
        ).isEqualTo(Person.builder()
                .name("zzh1991")
                .age(18)
                .build());

        assertThat(
                MapperUtil.getObjectFromJson("{\"name\": \"zzh1991\", \"age\": 18}", Person.class)
        ).isEqualTo(Person.builder()
                .name("zzh1991")
                .age(18)
                .build());

        assertThat(
                MapperUtil.getObjectFromJson("{\"name\": \"zzh1991\"}", Person.class)
        ).isEqualTo(Person.builder()
                .name("zzh1991")
                .build());
    }
}