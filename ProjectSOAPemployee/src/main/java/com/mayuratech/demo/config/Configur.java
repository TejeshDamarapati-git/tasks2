package com.mayuratech.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class Configur extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/allService/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema ) {
    	DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    	wsdl11Definition.setPortTypeName("allServiceSoapHttp");
        wsdl11Definition.setLocationUri("/allService");
        wsdl11Definition.setTargetNamespace("com.mayuratech.demo");
        wsdl11Definition.setSchema(employeeSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema employee() {
        return new SimpleXsdSchema(new ClassPathResource("/employee.xsd"));
    }
}