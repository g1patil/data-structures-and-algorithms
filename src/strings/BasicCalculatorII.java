package strings;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        s = s.replaceAll("\\s+","");
        List<Character> operationList = new ArrayList<>();
        operationList.add('/');
        operationList.add('*');
        operationList.add('+');
        operationList.add('-');

        for(char ol : operationList){
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int first = 0;
                String input = "" , output = "";

                if (c == ol){
                        first =  getFirstIndex(s , i-1);
                        input = s.substring( first , getLastIndex(s, i+1));
                        output = performOperation(input , i - first);
                        s = s.replace(input , output );

                }
            }
        }

        return Integer.parseInt(s);
    }

    public int getFirstIndex(String s , int i){
        while ( i > 0 && Character.isDigit(s.charAt(i)))
            i--;
        return i == 0 ? 0 : i+1;
    }

    public int getLastIndex(String s , int i){
        while (i < s.length() && Character.isDigit(s.charAt(i)))
            i++;
        return i;
    }

    public String performOperation(String input , int index){
        StringBuilder sb = new StringBuilder();
        int result = 0 ;
        int first = Integer.parseInt(input.substring(0 , index));
        int second = Integer.parseInt(input.substring(index + 1 ));
        switch (input.charAt(index)){
            case '*':
                result = first * second;
                break;
            case '/':
                result = first / second ;
                break;
            case '+':
                result = first + second ;
                break;
            case '-':
                result = first - second;
                break;
            default:
                return null;
        }
        return sb.append(result).toString();
    }

    @Test
    public void test_(){
        System.out.println(calculate(" 1+1+1 " ));
    }
}
