package ru.vershinin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import ru.vershinin.client.SOAPConnector;


@EnableWs
@Configuration
public class SoapWebServiceConfiguration extends WsConfigurerAdapter {

    /**
     * Преобразования сообщений и из XML
     * @return - Реализация Marshallerинтерфейса для JAXB 2.0.
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("ru.vershinin.calculate.wsdl");
        return marshaller;
    }


    /**
     * Записывает в marshaller SOAPConnector bean
     * @see SOAPConnector
     *
     * @param marshaller - Реализация Marshallerинтерфейса для JAXB 2.0.
     * @return - объект SOAPConnector
     * @link https://docs.spring.io/spring-framework/docs/3.2.4.RELEASE_to_4.0.0.M3/Spring%20Framework%203.2.4.RELEASE/org/springframework/oxm/jaxb/Jaxb2Marshaller.html
     */
    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
