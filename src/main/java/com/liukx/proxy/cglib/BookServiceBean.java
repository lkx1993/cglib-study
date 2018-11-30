package com.liukx.proxy.cglib;

/**
 * Created by liukx on 2018/11/28.
 */
public class BookServiceBean {

    private String ss = "rrre";

    public BookServiceBean() {
        System.out.println("这是BookserviceBean的构造方法");
    }

    public void create(){
        System.out.println("BookserviceBean.create() is running");
    }

    public void query(){
        System.out.println("BookserviceBean.query() is running");
    }


}
