/**
 * 工程名 ：classdemo
 *
 * @author wangx
 * @version 1.0
 * @createDate 2019/4/2
 * @功能： 类的加载（静态加载/动态加载）
 * @since JDK1.8
 */
public class ClassDemo3 {

    public static void main(String [] args){

        //new创建对象 是静态加载类，在编译时刻就需要加载所有的可能使用到的类
        if("Word".equals(args[0])){
            //如果不存在word类，则编译不通过
//            Word w = new Word();
//            w.start();
        }
    }
}
