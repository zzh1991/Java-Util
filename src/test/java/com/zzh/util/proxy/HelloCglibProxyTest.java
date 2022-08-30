package com.zzh.util.proxy;

import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

/**
 * @author zhihao zhang
 * @since 10/3/20
 */

public class HelloCglibProxyTest {
    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(HelloCglibClass.class.getClassLoader());
        enhancer.setSuperclass(HelloCglibClass.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        HelloCglibClass proxy = (HelloCglibClass) enhancer.create();
        proxy.hello("hello world!");
    }
}
