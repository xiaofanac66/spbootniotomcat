package sf.niotomcat.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.management.Attribute;
import javax.management.MBeanServer;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Created with IntelliJ IDEA.
 * User: qusifan
 * Date: 2018/6/21
 * Time: 上午9:52
 */
public class HelloAgent {
  public static void main(String[] args) throws Exception {
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    ObjectName helloName = new ObjectName("HelloService:name=HelloWorld");
    mbs.registerMBean(new HelloService("xiaofange"), helloName);

    //    HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//    adapter.start();
//    mbs.registerMBean(adapter,adapterName);
    System.in.read();
  }
}
