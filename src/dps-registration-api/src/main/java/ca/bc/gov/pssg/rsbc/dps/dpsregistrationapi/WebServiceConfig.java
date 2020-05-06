package ca.bc.gov.pssg.rsbc.dps.dpsregistrationapi;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.xml.ws.Endpoint;
import java.util.Arrays;

@Configuration
public class WebServiceConfig {
//
    @Bean
    public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
        return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/ws/*");
    }
////

    @Bean
    @Primary
    public DispatcherServletPath dispatcherServletPathProvider() {
        return () -> "";
    }


    @Bean
    public Endpoint endpoint(Bus bus, RegistrationServiceEndpoint registrationServiceEndpoint) {
        EndpointImpl endpoint = new EndpointImpl(bus, registrationServiceEndpoint);
        endpoint.publish("/DPS_RegistrationServices.wsProvider:dpsDocumentStatusRegWS");
        return endpoint;
    }



    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus cxfBus = new  SpringBus();
        return cxfBus;
    }


    @Bean
    public Server rsServer(Bus bus) {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(new HelloServiceImpl1()));
        endpoint.setAddress("/api");
       // endpoint.setFeatures(Arrays.asList(createOpenApiFeature(), new LoggingFeature()));
        return endpoint.create();
    }

  //  @Bean
//    public OpenApiFeature createOpenApiFeature() {
//        final OpenApiFeature openApiFeature = new OpenApiFeature();
//        openApiFeature.setPrettyPrint(true);
//        openApiFeature.setTitle("Spring Boot CXF REST Application");
//        openApiFeature.setContactName("The Apache CXF team");
//        openApiFeature.setDescription("This sample project demonstrates how to use CXF JAX-RS services"
//                + " with Spring Boot. This demo has two JAX-RS class resources being"
//                + " deployed in a single JAX-RS endpoint.");
//        openApiFeature.setVersion("1.0.0");
//        openApiFeature.setSwaggerUiConfig(
//                new SwaggerUiConfig()
//                        .url("/services/helloservice/openapi.json"));
//        return openApiFeature;
//    }

}
