package com.zzh.util;

import com.google.common.collect.Lists;
import com.zzh.util.constant.StatusEnum;
import org.junit.jupiter.api.Test;
import com.zzh.util.util.EnumUtil;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EnumUtilTest {

    @Test
    void getEnumMap() {
        Map<String, StatusEnum> map = EnumUtil.getEnumMap(StatusEnum.class);
        assertThat(map.values()).containsAll(Lists.newArrayList(StatusEnum.values()));
    }
}