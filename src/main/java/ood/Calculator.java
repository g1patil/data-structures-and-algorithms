package ood;

import org.junit.jupiter.api.Test;


/**
 * Initial version of the basci calculator
 * */
public class Calculator {

    public double performOperation( double num1 , double num2, Character operation){
        return switch(operation){
            case '+' -> num1 + num2;
            case '*' -> num1 * num2;
            case '/' ->{
                if(num2 == 0)
                    throw new IllegalArgumentException();
                yield num1 / num2;
            }
            case '-' -> num1 - num2;
            default -> throw new IllegalArgumentException("Operations invalid or not supported");
        };
    }

    @Test
    public void test(){
        System.out.println(
                performOperation(1,2,'*')
        );
    }
}

enum OPERATION{
    ADD,
    SUB,
    DIV,
    MUL
}

