package org.example;

public class CalculatorTest {

    private int nbErrors = 0;

    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60)
            throw new IllegalStateException("Bad result: " + result);
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.testAdd();
        } catch (Exception e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0)
            throw new IllegalStateException("There where " + test.nbErrors + " error(s)");
    }
}
