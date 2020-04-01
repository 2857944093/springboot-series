package com.czk.hope.designmode.proxy.jdkproxy;
import java.lang.reflect.Method;
public class $Proxy0 implements Move {
    public $Proxy0(MyInvocationHandler h){	
       super();	
       this.h = h;	
} 	
    private MyInvocationHandler h;	
public void move(){	
try {	
Method md = Move.class.getMethod("move");
h.invoke(this, md);	
}catch(Exception e) {}	
}	
}