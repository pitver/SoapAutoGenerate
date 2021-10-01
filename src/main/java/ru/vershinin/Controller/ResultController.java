package ru.vershinin.Controller;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ru.vershinin.calculate.wsdl.AddResponse;
import ru.vershinin.calculate.wsdl.DivideResponse;
import ru.vershinin.calculate.wsdl.MultiplyResponse;
import ru.vershinin.calculate.wsdl.SubtractResponse;
import ru.vershinin.service.ResultService;


@RestController
public class ResultController {


    final ResultService resultService;



    public static final String paternFormat = "\\d+";

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/additions")
    public int add(
            @RequestParam(value = "num1", required = false, defaultValue = "1") String num1,
            @RequestParam(value = "num2", required = false, defaultValue = "1") String num2){

        AddResponse response;
        if (num1.matches(paternFormat) && (num2.matches(paternFormat))) {

            response = resultService.add(Integer.parseInt(num1), Integer.parseInt(num2));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid input");
        }

        return response.getAddResult();
    }



    @GetMapping("/subtraction")
    public int subtraction(
            @RequestParam(value = "num1", required = false, defaultValue = "1") String num1,
            @RequestParam(value = "num2", required = false, defaultValue = "1") String num2)  {

        SubtractResponse response;
        if (num1.matches(paternFormat) && (num2.matches(paternFormat))) {
            response = resultService.subtract(Integer.parseInt(num1), Integer.parseInt(num2));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid input");
        }
        return response.getSubtractResult();

    }


    @GetMapping("/multiply")
    public int multiply(
            @RequestParam(value = "num1", required = false, defaultValue = "1") String num1,
            @RequestParam(value = "num2", required = false, defaultValue = "1") String num2)  {

        MultiplyResponse response;
        if (num1.matches(paternFormat) && (num2.matches(paternFormat))) {
            response = resultService.multiply(Integer.parseInt(num1), Integer.parseInt(num2));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid input");
        }
        return response.getMultiplyResult();
    }


    @GetMapping("/division")
    public int division(
            @RequestParam(value = "num1", required = false, defaultValue = "1") String num1,
            @RequestParam(value = "num2", required = false, defaultValue = "1") String num2)  {

        DivideResponse response;
        if (num1.matches(paternFormat) && (num2.matches(paternFormat)) && Integer.parseInt(num2) != 0) {
            response = resultService.division(Integer.parseInt(num1), Integer.parseInt(num2));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid input");
        }
        return response.getDivideResult();
    }

}
