package sf.niotomcat;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * Created with IntelliJ IDEA.
 * User: qusifan
 * Date: 2018/4/27
 * Time: 上午11:27
 */
public class CglibTest {

    public static void main(String[] args) throws Exception {
//        Enhancer enhancer =new Enhancer();
//        enhancer.setSuperclass(SimpleOut.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("in");
//                Object invoke = methodProxy.invokeSuper(o, objects);
//                System.out.println("out");
//                return invoke;
//            }
//        });
//        SimpleOut one=(SimpleOut)enhancer.create();
//        one.say();
//        //sf.niotomcat.SimpleOut$$EnhancerByCGLIB$$7e80645d
//        Class<?> aClass = one.getClass();
//        Constructor<?> constructor = aClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        SimpleOut tow = (SimpleOut)constructor.newInstance();
//        tow.say();
//        while(true) Thread.sleep(3000);
//        ClassWriter classWriter = new ClassWriter(1);
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(SimpleOut.class);
//        try {
//            enhancer.generateClass(classWriter);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("in");
//                Object invoke = methodProxy.invokeSuper(o, objects);
//                System.out.println("out");
//                return invoke;
//            }
//        });
//        SimpleOut o = (SimpleOut)enhancer.create();
//        o.say();
//        byte[] bytes = classWriter.toByteArray();
//        try(FileOutputStream out = new FileOutputStream("/Users/qusifan/spbootniotomcat/target/test-classes/sf/niotomcat/eee.class")){
//            out.write(bytes,0,bytes.length);
//            out.flush();
//        }
    }
}
