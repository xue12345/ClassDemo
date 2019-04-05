package jvm;

/**
 * @project: classdemo
 * @description: 初识jvm
 * @author: xuexue
 * @date: 2019/4/5 10:24
 */
public class JvmInit {
    public static void main(String [] args){
        //不建议用 A a = new A(); a.a++ (静态变量要用类.属性)
        A.a ++;
        System.out.println(A.a);

        System.out.println(A.b);
    }
}
