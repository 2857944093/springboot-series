package com.czk.hope.designmode.proxy.demo1.jdkproxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;

/**
 * @author zhikang.chen
 * @description
 * @date 2020/3/31 21:14
 */
public class MyProxy {
    public static Object newProxyInstance() throws IOException, ClassNotFoundException {
        String rt = "\t\n";
        String str =
        "package com.czk.hope.designmode.proxy.demo1.jdkproxy;" + rt +
        "public class $Proxy0 implements Move {" + rt +
        "    @Override" + rt +
        "    public void move() {" + rt +
        "        System.out.println(\"move。。。\");" + rt +
        "    }" + rt +
        "}";

        String fileName = System.getProperty("user.dir")+"/springboot-designmode/com/czk/hope/designmode/proxy/demo1/jdkproxy/$Proxy.java";
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



        return null;
    }
}
