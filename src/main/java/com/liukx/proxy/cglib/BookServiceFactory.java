package com.liukx.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by liukx on 2018/11/28.
 */
public class BookServiceFactory {

    public BookServiceFactory() {
    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myCglibProxy){
        Enhancer enhancer = new Enhancer();
        // 将Enhancer中的superclass属性赋值成BookServiceBean
        enhancer.setSuperclass(BookServiceBean.class);
        // 将Enhancer中的callbacks属性赋值成myProxy
        enhancer.setCallbacks(new Callback[]{myCglibProxy,NoOp.INSTANCE});
        enhancer.setCallbackFilter(new MyCallbackFilter());
        return (BookServiceBean)enhancer.create();
    }

}
