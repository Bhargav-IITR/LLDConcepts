package org.example.compositePattern.calculatorSolution;

public class Operator implements Expression{

    OperatorType type;
    Expression left;
    Expression right;

    public Operator(OperatorType type, Expression left, Expression right){
        this.type = type;
        this.left = left;
        this.right = right;
    }

    @Override
    public int execute() {
        int result;
        if(type == OperatorType.ADD){
            result = left.execute() + right.execute();
        }else if(type == OperatorType.SUBTRACT){
            result = left.execute() - right.execute() ;
        }else if(type == OperatorType.MULTIPLY){
            result = left.execute() * right.execute();
        }else result = left.execute() / right.execute();

        System.out.println("Result : " + result);
        return result;
    }
}
