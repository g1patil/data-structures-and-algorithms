package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
* 293. Flip Game
*
* You are playing the following Flip Game with your friend:
* Given a string that contains only these two characters: + and -,
* you and your friend take turns to flip two consecutive "++" into "--".
* The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example:

Input: s = "++++"
Output:
[
  "--++",
  "+--+",
  "++--"
]
*
* */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        char[] chars = s.toCharArray();
        List<String> stringList = new ArrayList<>();

        for(int i =0 ; i < chars.length-1 ; i ++){
            if( chars[i]== '+' && chars[i+1]=='+'){
                chars[i] = '-' ;
                chars[i+1] = '-' ;
                stringList.add(String.valueOf(chars));
                chars[i] = '+' ;
                chars[i+1] = '+' ;
            }
        }
        return stringList;
    }

    @Test
    public void test(){
        Assertions.assertEquals( generatePossibleNextMoves("++++").size(),3);
    }
}
