package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 *  58 : Length of Last Word
 * */
@Platform(Site.LEETCODE)
@Quality(Stage.TESTED)
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        String input = s.strip();
        int lastIndex = getLastSpace(input);
        return lastIndex == 0 ? input.length() : input.length() - lastIndex - 1;
    }
    public int getLastSpace(String input){
        int last = input.length() - 1;
        while(last > 0 && input.charAt(last) != ' '){
            last--;
        }
        return last;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord(" a"));
    }
}
