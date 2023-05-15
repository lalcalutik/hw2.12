package pro.sky.hw212.Service;


import org.springframework.stereotype.Service;
import pro.sky.hw212.Exception.DivByZeroException;

@Service
public class CalculatorService {

    public double plus(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new DivByZeroException();
        }
        return a / b;
    }
}
