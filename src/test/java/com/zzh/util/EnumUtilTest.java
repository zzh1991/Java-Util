package com.zzh.util;

import com.zzh.util.constant.StatusEnum;
import org.junit.jupiter.api.Test;
import com.zzh.util.util.EnumUtil;

import java.util.Map;

class EnumUtilTest {

    @Test
    void getEnumMap() {
        Map<String, StatusEnum> map = EnumUtil.getEnumMap(StatusEnum.class);
        for (StatusEnum statusEnum :
                map.values()) {
            System.out.println(statusEnum.name());
            System.out.println(statusEnum.toString());
        }
    }
}