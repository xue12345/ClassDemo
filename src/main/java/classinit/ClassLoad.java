package classinit;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @project: classdemo
 * @description: 类加载器
 * @author: xuexue
 * @date: 2019/4/7 09:33
 */
public class ClassLoad {

    public static void main(String [] args) throws IOException {
        //获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统加载器：" + systemLoader);
        //获取系统类加载器的加载路径
        Enumeration<URL> em1 = systemLoader.getResources("");
        while (em1.hasMoreElements()) {
            System.out.println(em1.nextElement());
        }
        //获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader exClassLoader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + exClassLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        //JVM的根类加载器并不是Java实现的，而且程序通常无需访问根类加载器，因此访问扩展类加载器的父类加载器时返回null
        System.out.println("扩展类加载器的parent：" + exClassLoader.getParent());
    }
}