package miscellaneous;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class Calc {

    public double calculate(String input){

        String[] inputArray = input.split(" ");
        String operation = "";
        if ( input == ""){
            return 0;
        }

        Stack<Double> stack = new Stack<Double>();

        double firstDigit,secondDigit, operationResult;

        for( int i = 0 ; i < inputArray.length; i ++){

            if (inputArray[i].equals("*") || inputArray[i].equals("+") || inputArray[i].equals("-") || inputArray[i].equals("/") ){
                operation = inputArray[i];

            } else {
                stack.push ( Double.valueOf( inputArray[i] ));
            }

            switch ( operation){
                case "*" :
                    firstDigit = stack.pop();
                    secondDigit = stack.pop();
                    operationResult = firstDigit * secondDigit;
                    stack.push(operationResult);
                    operation = "";
                    break;
                case "-" :
                    firstDigit = stack.pop();
                    secondDigit = stack.pop();
                    operationResult = secondDigit - firstDigit;
                    stack.push(operationResult);
                    operation = "";
                    break;
                case "+" :
                    firstDigit = stack.pop();
                    secondDigit = stack.pop();
                    operationResult = firstDigit + secondDigit;
                    stack.push(operationResult);
                    operation = "";
                    break;
                case "/" :
                    firstDigit = stack.pop();
                    secondDigit = stack.pop();
                    operationResult = secondDigit / firstDigit;
                    stack.push((double) operationResult);
                    operation = "";
                    break;

                default:
                    continue;
            }

        }

        return stack.pop();
    }

    @Test
    public void shouldWorkForAnEmptyString() {
        assertEquals(0, calculate(""), 0);
    }
    @Test
    public void shouldParseNumbers() {
        assertEquals(3, calculate("1 2 3"), 0);
    }
    @Test
    public void shouldParseFloats() {
        assertEquals(3.5, calculate("1 2 3.5"), 0);
    }
    @Test
    public void shouldSupportAddition() {
        assertEquals(4, calculate("1 3 +"), 0);
    }
    @Test
    public void shouldSupportMultiplication() {
        assertEquals(3, calculate("1 3 *"), 0);
    }
    @Test
    public void shouldSupportSubtraction() {
        assertEquals(-2, calculate("1 3 -"), 0);
    }
    @Test
    public void shouldSupportDivision() {
        assertEquals(2, calculate("4 2 /"), 0);
    }

}
