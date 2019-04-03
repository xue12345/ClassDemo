import java.lang.reflect.Method;

/**
 * 工程名 ：classdemo
 *
 * @author wangx
 * @version 1.0
 * @createDate 2019/4/2
 * @功能：
 * @since JDK1.8
 */
public class ClassUtil {

    /**
     * 打印类的信息，包括类的成员方法、成员变量
     * @param  obj 该对象所属累的信息
     * */
    public static void  printClassMessage(Object obj){
        //通过实例对象获取相应的类类型
        Class c = obj.getClass();
        //查询所有类类型下的所有属于自己的方法
        Method [] methodList = c.getDeclaredMethods();

        //查询所有类类型下的公共方法（包括父类继承的方法）
        Method [] methods = c.getMethods();

        for (Method m: methods){

        }

    }

}
