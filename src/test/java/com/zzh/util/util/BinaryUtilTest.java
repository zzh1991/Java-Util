package com.zzh.util.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryUtilTest {

    @Test
    void getProperSize() {
        System.out.println(BinaryUtil.getProperSize(15));
        System.out.println(BinaryUtil.getProperSize(16));
        System.out.println(BinaryUtil.getProperSize(17));
    }
}