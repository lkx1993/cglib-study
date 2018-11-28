package com.liukx.proxy.cglib;

/**
 * Created by liukx on 2018/11/28.
 */
public class Test {

    public static void main(String[] args) {
        BookServiceBean bookServiceBean = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三"));
        System.out.println(123);
        bookServiceBean.create();
        bookServiceBean.query();
    }
}
