package classone;

/**
 * 工程名 ：classdemo
 *
 * @author wangx
 * @version 1.0
 * @createDate 2019/4/2
 * @功能： 了解基本的数据类型 基本数据类型也有他们对应的类类型
 * @since JDK1.8
 */
public class ClassDemo2 {

    public static void main(String [] args){
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = void.class;
        Class c4 = double.class;
        Class c5 = Double.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());
        System.out.println(c3.getName());
    }

}
