package com.liukx.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by liukx on 2018/12/2.
 */
public class MyCallbackFilter implements CallbackFilter {
    public int accept(Method method) {
        if("create".equals(method.getName())){
            return 0;
        }
        return 1;
    }
}
