package classone;

/**
 * 工程名 ：classdemo
 *
 * @author wangx
 * @version 1.0
 * @createDate 2019/4/2
 * @描述： 万事万物皆对象，除了静态成员变量，以及基本数据变量
 *          类是class类的实例对象
 * @since JDK1.8
 */
public class ClassDemo1 {

    public static void main(String [] arr){
        //Foo的实例化
        Foo foo1 = new Foo();

        //Foo这个类也是一个实例对象，那么Class类的实例对象，该如何表示呢？
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式----》任何一个类都有一个隐含的静态成员变量Class
        Class c1 = Foo.class;

        //第二种表示方式----》已经知道该类的对象通过getClass方法获取
        Class c2 = foo1.getClass();

        /**
         * c1,c2表示了Foo类的类类型
         * 万事万物皆对象
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型
         * */

        //一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);
        System.out.println(c1.getName());

        //第三种方式----》
        Class c3 =null;
        try {
             c3 = Class.forName("classone.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);

        //我们可以通过类的类类型创建g该类的对象实例----》通过c1 or c2 or c3创建出Foo对象的实例
        try {
            Foo foo2 = (Foo)c1.newInstance();
            foo2.getfoo();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Foo{

    public void getfoo(){
        System.out.println("foo");
    }

}
