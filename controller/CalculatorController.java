package pro.sky.hw212.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.hw212.Service.CalculatorService;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String greetings() {
        return "<h1>Долбро пожаловать в калькулятор!<h1>";
    }
    @RequestMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Double num1,
                       @RequestParam(value = "num2", required = false) Double num2) {
        return answerBuild(num1, num2,"+");

    }

    @RequestMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Double num1,
                        @RequestParam(value = "num2", required = false) Double num2) {
        return answerBuild(num1, num2,"-");

    }

    @RequestMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Double num1,
                           @RequestParam(value = "num2", required = false) Double num2) {
        return answerBuild(num1, num2, "*");
    }

    @RequestMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Double num1,
                         @RequestParam(value = "num2", required = false) Double num2) {
        return answerBuild(num1, num2, "/");

    }


    public String answerBuild(Double num1, Double num2, String operation) {
        if (num1 == null || num2 == null) {
            return "Один из параметров не передан";
        }
        if (operation.equals("/") && num2 == 0) {
            return "На ноль делить нельзя";
        }
        Number result;
        switch (operation) {
            case "-":
                result = calculatorService.minus(num1, num2);
                break;
            case "+":
                result = calculatorService.plus(num1, num2);
                break;
            case "/":
                result = calculatorService.divide(num1, num2);
                break;
            default:
                result = calculatorService.multiply(num1, num2);
                break;
        }

        return num1 + " " + operation + " " + num2 + " = " + result;
    }
}
