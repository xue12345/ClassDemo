/**
 * 工程名 ：classdemo
 *
 * @author wangx
 * @version 1.0
 * @createDate 2019/4/2
 * @功能：
 * @since JDK1.8
 */
public class OfficeBetter {

    public static void main(String [] args){

        try {
            //动态加载类，在运行时刻加赞
            Class c = Class.forName("Word");
            //通过类类型创建该类的对象
            OfficeAble oa =(OfficeAble)c.newInstance();
            oa.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
