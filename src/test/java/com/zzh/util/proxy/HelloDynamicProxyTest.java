package com.zzh.util.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HelloDynamicProxyTest {
    @Test
    void testDynamicProxy() {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            if (Objects.equals(method.getName(), "hello")) {
                System.out.println(method);
                return args[0];
            }
            return null;
        };

        HelloDynamicProxy proxyInstance = (HelloDynamicProxy) Proxy
                .newProxyInstance(HelloDynamicProxyTest.class.getClassLoader(),
                        new Class[]{ HelloDynamicProxy.class },
                        invocationHandler);

        System.out.println(proxyInstance.hello("hello world"));
        System.out.println(HelloDynamicProxy.PROXY_TEXT);
    }

    @Test
    void testMapDynamicProxy() {
        Map mayDynamicProxy = (Map) Proxy
                .newProxyInstance(HelloDynamicProxyTest.class.getClassLoader(),
                        new Class[]{ Map.class },
                        new TimingDynamicInvocationHandler(new HashMap<>()));
        System.out.println(mayDynamicProxy.get("hello"));
    }
}
