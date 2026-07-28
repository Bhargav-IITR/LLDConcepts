package org.example.compositePattern.calculatorSolution;

public class Main {
    public static void main(String [] args) {
        Expression num1 = new Number(1);
        Expression num2 = new Number(77);
        Expression operator1 = new Operator(OperatorType.ADD, num1, num2);
        Expression num3 = new Number(88);
        Expression operator2 = new Operator(OperatorType.MULTIPLY, num3, operator1);

        int result = operator2.execute();
        System.out.println("Result : " + result);
    }
}
