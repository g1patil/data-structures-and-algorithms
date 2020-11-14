import java.util.*;

/**
 * Check if the given brackets are balanced or not
 * */
public class BalancedBrackets {

    public boolean checkBalancedBraces(String input){
        int score = 0;
        Stack<Character> bracesStack = new Stack<>();

        Map<Character,Character> openingBraces = new HashMap<>();
        openingBraces.put('{','}');
        openingBraces.put('(',')');
        openingBraces.put('[',']');
        openingBraces.put(')','(');
        openingBraces.put('}','{');
        openingBraces.put(']','[');

        Character lastChar = null;
        for (int index =0; index < input.length(); index++){
            Character currentChar = input.charAt(index);

            if (currentChar == lastChar ){
                if (!bracesStack.isEmpty()){
                    bracesStack.pop();
                    score++;
                    if (!bracesStack.isEmpty()){
                        lastChar = openingBraces.get(bracesStack.peek());
                    }
                    continue;
                }
            }

            if (openingBraces.containsKey(currentChar)){
                bracesStack.push(currentChar);
                lastChar = openingBraces.get(currentChar);
            }

        }

        System.out.println("Score : " +score);
        return bracesStack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(new BalancedBrackets().checkBalancedBraces("(()){([])}[]}"));
    }
}


