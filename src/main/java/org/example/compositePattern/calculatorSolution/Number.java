package org.example.compositePattern.calculatorSolution;

public class Number implements Expression{
    private int num;
    public Number(int num){
        this.num = num;
    }
    @Override
    public int execute() {
        System.out.println("Expression - " + num);
        return num;
    }
}
