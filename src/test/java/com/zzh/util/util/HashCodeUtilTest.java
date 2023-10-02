package com.zzh.util.util;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class HashCodeUtilTest {

    @Test
    void getHashCode() {
        // 64 bits
        // System.out.println(VM.current().details());
        Object object = new Object();

        System.out.println(object.toString());
        System.out.println(object.hashCode());
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        System.out.println(Thread.currentThread().threadId());

//        Object object2 = new Object();
//        System.out.println(object);
//        System.out.println(object.hashCode());
    }

    @Test
    void getIdentityHashCode() {
        Object object = new Object();
        assertThat(object).isEqualTo(HashCodeUtil.getIdentityHashCode(object));
    }

    @Test
    void lockUpgradeTest() {
        Object object = new Object();

        // first biased, the call hashcode
        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
            System.out.println(object.hashCode());
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }

        System.out.println(object);
        System.out.println(object.hashCode());
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        synchronized (object) {
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }

    @Test
    void testHashMapHashCode() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("hello", "world");

        Map<String, String> map2 = new HashMap<>();
        map2.put("hello", "world");

        System.out.println(map1.hashCode());
        System.out.println(map2.hashCode());

        System.out.println(System.identityHashCode(map1));
        System.out.println(System.identityHashCode(map2));

        System.out.println(Objects.hash(map1));
        System.out.println(Objects.hash(map2));
    }

    @Test
    void testArrayListHashCode() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("hello");
        list2.add("hello");

        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());

//        System.out.println(System.identityHashCode(list1));
//        System.out.println(System.identityHashCode(list2));

        System.out.println(Objects.hash(list1));
        System.out.println(Objects.hash(list2));

        System.out.println(HashCodeUtil.calculateListHashCode(list1));
        System.out.println(HashCodeUtil.calculateListHashCode(list2));
    }
}