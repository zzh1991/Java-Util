package com.zzh.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingDynamicInvocationHandler implements InvocationHandler {
    private Object target;

    public TimingDynamicInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return args[0];
    }
}
