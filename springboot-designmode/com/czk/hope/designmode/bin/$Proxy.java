package com.czk.hope.designmode.proxy.demo1.jdkproxy;	
import com.czk.hope.designmode.proxy.demo1.jdkproxy.MyInvocationHandler;	
import java.lang.reflect.Method;	
public class $Proxy0 implements com.czk.hope.designmode.proxy.demo1.jdkproxy.Move {	
    public $Proxy0(MyInvocationHandler h){	
       super();	
       this.h = h;	
} 	
    private MyInvocationHandler h;	
public void move(){	
try {	
Method md = com.czk.hope.designmode.proxy.demo1.jdkproxy.Move.class.getMethod("move");	
h.invoke(this, md);	
}catch(Exception e) {}	
}	
}