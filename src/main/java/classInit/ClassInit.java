package classInit;

/**
 * @project: classdemo
 * @description: 类的加载
 * @author: xuexue
 * @date: 2019/4/5 22:26
 */
public class ClassInit {
    public static void main(String [] args){
        //final修饰的静态变量（类变量），如果在编译时即可确定下来，则程序在使用时，无需初始化类
        System.out.println(Init.c);

        //在类的初始化阶段，主要是对类变量进行初始化
        System.out.println(Init.b);

    }
}
class Init{

    /**
     * 常量
     * */
    public final static int c = 100;

    /**
     * 静态代码块
     * */
    static {
        b = 9;
        System.out.println("--------初始化类-----------");
    }

    /**
     * 静态变量
     * */
    public static int a = 10;

    static int b = 12;


}
