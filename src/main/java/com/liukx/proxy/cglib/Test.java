package com.liukx.proxy.cglib;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liukx on 2018/11/28.
 */
public class Test {

    public static void main(String[] args) {
        BookServiceBean bookServiceBean = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三q"));
        System.out.println(123);
        bookServiceBean.create();
        bookServiceBean.query();

        //下面
        try {
            Class origin = Class.forName("com.liukx.proxy.cglib.BookServiceBean");
//            Class proxy = Class.forName("class com.liukx.proxy.cglib.BookServiceBean$$EnhancerByCGLIB$$b98906c4");
            Class proxy = bookServiceBean.getClass();

            classInfo(origin);
            classInfo(proxy);

            createClassFile(proxy,"TempProxy");
            createClassFile(origin,"origin");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void classInfo(Class clazz){
        Method[] methods = clazz.getMethods();
        System.out.println(String.format("%s的方法数量:%s--------------------------------",clazz.getName(),methods.length));
        int i=1;
        for (Method method : methods) {
            System.out.println(String.format("%s的第%s个方法:    %s",clazz.getName(),i++,method.getName()));
        }

        Field[] fields = clazz.getDeclaredFields();
        i=1;
        for (Field field : fields) {
            System.out.println(String.format("%s的第%s个属性:    %s",clazz.getName(),i++,field.getName()));
        }
    }

    private static void createClassFile(Class clazz,String name){
        try {
            Class proxyGenerator = Class.forName("sun.misc.ProxyGenerator");
            Method[] methods = proxyGenerator.getMethods();
            for (Method method : methods) {
                System.out.println(String.format("ProxyGenerator的method:%s",method.getName()));
                byte[] bytes = (byte[]) method.invoke(proxyGenerator,name,new Class[]{clazz});

                File temp;
                FileOutputStream fos = new FileOutputStream(temp = new File(name+".class"));
                fos.write(bytes);
                fos.flush();
                fos.close();
                System.out.println("路径:"+temp.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
