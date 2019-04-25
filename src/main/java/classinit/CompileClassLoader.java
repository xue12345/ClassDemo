package classinit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @project: classdemo
 * @description: 自定义类加载器
 * @author: xuexue
 * @date: 2019/4/7 11:14
 */
public class CompileClassLoader extends ClassLoader{
    /**
     *
     * 功能描述: 读取一个文件的内容
     *
     * @param: [fileName]
     * @author: xuexue
     * @date: 2019/4/7 11:15
     */
    private byte[] getBytes(String fileName){
        //得到数据文件
        File file = new File(fileName);
        //获取文件的长度
        long len = file.length();
        //转化为byte数组
        byte[] raw = new byte[(int)len];
        try {
            //读取文件
            FileInputStream fil = new FileInputStream(file);
            //一次性读取Class文件的全部二进制数据
            int r = fil.read(raw);
            if(r != len){
                throw new IOException("无法读取全部文件：" + r + " != " +len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return raw;
    }

    /**
     *
     * 功能描述: 定义编译指定java文件的方法
     *
     * @param: [javaFile]
     * @author: xuexue
     * @date: 2019/4/7 14:52
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader：正在编译"+ javaFile +"...");
        //调用系统的javac命令
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            //其他线程需要等待这个线程完成
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        //获取javac线程的退出值
        int ret = p.exitValue();
        //返回编译是否成功
        return ret == 0;
    }

    /**
     *
     * 功能描述: 重写findClass方法
     *
     * @param: [name]
     * @author: xuexue
     * @date: 2019/4/7 15:00
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{

        Class clazz = null;
        //将包路径中的点（.）替换成斜线（/）
        String fileStub = name.replace(".","/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub +".class";

        //获取.java文件
        File javaFile = new File(javaFileName);
        //获取.class文件
        File classFile = new File(classFileName);

        //当指定的java源文件存在且.class文件不存在，或者java源文件的修改时间比.class文件的修改时间更晚时，重新编译
        if(javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()){

            try {
                if(!compile(javaFileName) || !classFile.exists()){
                    throw new ClassNotFoundException("ClassNotFountException：" + javaFileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果class文件存在，系统负责将该文件转换成Class对象
        if (classFile.exists()){
            //将class文件转换为byte[] 数组
            byte[] raw = getBytes(classFileName);
            //调用defineClass方法将二进制数组转换为class对象
            clazz = defineClass(name, raw,0, raw.length);
        }
        //表明加载失败，则抛出异常
        if(clazz == null){
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception{
        //如果运行该程序时没有参数，即没有目标类
        if (args.length < 1){
            System.out.println("缺少目标类，请按如下格式运行java源文件：");
            System.out.println("java compileClassLoader ClassName");
        }
        //第一个参数是需要运行的类
        String progClass = args[0];
        //剩下的参数将作为运行目标类时的参数
        //将这些参数复制到一个新数组中
        String[] progArgs = new String[args.length - 1];
        System.arraycopy(args, 1 ,progArgs, 0 ,progArgs.length);

        CompileClassLoader compileClassLoader = new CompileClassLoader();
        //加载需要运行的类
        Class<?> cls = compileClassLoader.loadClass(progClass);
        Method main = cls.getMethod("main", (new String[0].getClass()));
        Object argsArray[] = {progArgs};
        main.invoke(null,argsArray);
    }


}

