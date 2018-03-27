package sf.niotomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    DeferredResult<String> home() {
        final DeferredResult<String> def = new DeferredResult<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                def.setResult("hahaha");
            }
        }).start();
        //6666
        return def;
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.setPort(8064);
        tomcat.addAdditionalTomcatConnectors(createNioConnector());
        return tomcat;
    }

    @Bean
    public Servlet getDispatcherServlet(){
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(getDispatcherServlet(),"/**");
        servletRegistrationBean.setAsyncSupported(true);
        return servletRegistrationBean;
    }



    private Connector createNioConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(38065);
        connector.setAsyncTimeout(100000);
        connector.setEnableLookups(false);
        connector.setRedirectPort(8443);
        connector.setURIEncoding("UTF-8");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        protocol.setAcceptorThreadCount(1);
        protocol.setAcceptCount(5);
        protocol.setMaxConnections(5);
        protocol.setProcessorCache(1024);
        protocol.setMaxThreads(1);
        return connector;
    }



    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}