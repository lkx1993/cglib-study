package com.liukx.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liukx on 2018/11/28.
 */
public class MyCglibProxy implements MethodInterceptor{

    private String name;

    public MyCglibProxy(String name) {
        this.name = name;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(String.format("实际调用者是:%s",o.getClass()));
        System.out.println(String.format("实际调用的方法是:%s",method.getName()));
        for (Object param : objects) {
            System.out.println(String.format("实际参数类型是:%s",param.getClass()));
        }

        if(!"张三".equals(name)){
            System.out.println("权限不够,无法调用!");
        }
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("代理调用完成啦啦啦------------!");
        return result;
    }
}
