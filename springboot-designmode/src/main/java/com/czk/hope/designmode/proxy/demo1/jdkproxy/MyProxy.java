package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 21:14
 */
public class MyProxy {
    public static Object newProxyInstance(Class infce, MyInvocationHandler h) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String rt = "\t\n";
        String methodStr = "";
        for (Method m : infce.getMethods()) {
            methodStr =
            "public void "+ m.getName() +"(){" + rt +
                    "try {" + rt +
            "Method md = " + infce.getName() + ".class.getMethod(\""+ m.getName() +"\");" + rt +
            "h.invoke(this, md);" + rt +
                    "}catch(Exception e) {}" + rt +

            "}";
        }
        String str =
        "package com.czk.hope.designmode.proxy.demo1.jdkproxy;" + rt +
        "import com.czk.hope.designmode.proxy.demo1.jdkproxy.MyInvocationHandler;" + rt +
        "import java.lang.reflect.Method;" + rt +
        "public class $Proxy0 implements "+ infce.getName() +" {" + rt +
        "    public $Proxy0(MyInvocationHandler h){" + rt +
        "       super();" + rt +
        "       this.h = h;" + rt +
        "} "+ rt +
        "    private MyInvocationHandler h;" + rt +
        methodStr + rt +
        "}";

        String fileName = System.getProperty("user.dir")+"/springboot-designmode/com/czk/hope/designmode/bin/$Proxy.java";
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("com.czk.hope.designmode.proxy.demo1.jdkproxy.$Proxy0");

        Constructor ctr = c.getConstructor(MyInvocationHandler.class);

        return ctr.newInstance(h);
    }
}
