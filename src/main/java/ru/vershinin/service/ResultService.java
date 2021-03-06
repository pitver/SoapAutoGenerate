package ru.vershinin.service;


import org.springframework.stereotype.Service;
import ru.vershinin.calculate.wsdl.AddResponse;
import ru.vershinin.calculate.wsdl.DivideResponse;
import ru.vershinin.calculate.wsdl.MultiplyResponse;
import ru.vershinin.calculate.wsdl.SubtractResponse;
import ru.vershinin.client.SOAPConnector;


@Service
public class ResultService {
    final
    SOAPConnector soapConnector;

    public ResultService(SOAPConnector soapConnector) {
        this.soapConnector = soapConnector;
    }

   public AddResponse add(int a, int b) {
        AddResponse addResponse = soapConnector.additions(a, b);
        return addResponse;

    }

    public SubtractResponse subtract(int a, int b){
        SubtractResponse subtractResponse=soapConnector.subtraction(a, b);
        return subtractResponse;
    }
    public DivideResponse division(int a, int b) {
        DivideResponse addResponse = soapConnector.division(a, b);
        return addResponse;
    }

    public MultiplyResponse multiply(int a, int b){
        MultiplyResponse multiplyResponse=soapConnector.multiplication(a, b);
        return multiplyResponse;
    }

}
