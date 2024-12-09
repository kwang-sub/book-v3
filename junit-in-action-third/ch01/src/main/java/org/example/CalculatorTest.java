package org.example;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        double result = calc.add(10, 50);
        if (result != 60)
            System.out.println("Bad result: " + result);
    }
}
