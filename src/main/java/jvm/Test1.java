package jvm;

/**
 * @project: classdemo
 * @description: 测试jvm运行
 * @author: xuexue
 * @date: 2019/4/5 10:54
 */
public class Test1 {
    public static void main(String [] args){
        //因为改变a的值得并不是同一个Java程序，所以此程序会重新初始化该类的数据
        System.out.println(A.a);
    }
}
