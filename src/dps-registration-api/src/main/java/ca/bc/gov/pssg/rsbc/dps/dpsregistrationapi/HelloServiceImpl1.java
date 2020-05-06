package ca.bc.gov.pssg.rsbc.dps.dpsregistrationapi;

public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}