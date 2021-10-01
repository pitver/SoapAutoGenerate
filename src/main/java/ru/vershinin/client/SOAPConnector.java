package ru.vershinin.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.vershinin.calculate.wsdl.*;


/**
 * Класс расширяет WebServiceGatewaySupport для взаимодействия с веб-службой
 * @link https://docs.spring.io/spring-ws/sites/2.0/apidocs/org/springframework/ws/client/core/support/WebServiceGatewaySupport.html
 *
 * Класс определяет методы, соответствующие операциям, которую предоставил веб-сервис.
 * В этом классе создаются экземпляры Request для каждого метода и вызов веб-службы, чтобы получить нужный Response.
 * Другими словами, здесь мы производили обмен по протоколу SOAP.
 * Spring делает вызов с помощью шаблона WebServiceTemplate,
 * и используется метод шаблона marshalSendAndReceive для выполнения обмена по протоколу SOAP.
 * Для преобразования XML здесь обрабатываются через подключаемый модуль Marshaller.
 *
 * @see ru.vershinin.config.SoapWebServiceConfiguration
 *
 *
 */
public class SOAPConnector extends WebServiceGatewaySupport {


    public AddResponse additions(int a, int b) {

        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);
        System.out.println();
        System.out.println("Requesting forecast for " + a + " + " + b);
        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://tempuri.org/Add"));
    }




    public SubtractResponse subtraction(int a, int b) {
        Subtract request = new Subtract();
        request.setIntA(a);
        request.setIntB(b);
        System.out.println();
        System.out.println("Requesting forecast for " + a + " - " + b);
        return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://tempuri.org/Subtract"));
    }

    public DivideResponse division(int a, int b) {
        Divide request = new Divide();
        request.setIntA(a);
        request.setIntB(b);
        System.out.println();
        System.out.println("Requesting forecast for " + a + " / " + b);
        return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://tempuri.org/Divide"));
    }
    public MultiplyResponse multiplication(int a, int b) {
        Multiply request = new Multiply();
        request.setIntA(a);
        if(b==0){
            throw new IllegalArgumentException();
        }
        request.setIntB(b);
        System.out.println();
        System.out.println("Requesting forecast for " + a + " * " + b);
        return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(
                request,
                new SoapActionCallback(
                        "http://tempuri.org/Multiply"));
    }


}