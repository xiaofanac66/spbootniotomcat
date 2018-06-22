package sf.niotomcat.jmx;

/**
 * Created with IntelliJ IDEA.
 * User: qusifan
 * Date: 2018/6/21
 * Time: 上午9:47
 */
public class HelloService implements HelloServiceMBean {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HelloService(String name) {
    this.name = name;
  }

  @Override
  public void hello(String abc) {
    System.out.println("print name:" + name + "  "+ abc);
  }
}
