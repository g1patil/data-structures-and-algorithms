import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    int uniCharCount , windowLength  ;
    Map<Character,Integer> map = new HashMap<>();

    public void freqCal(String s){

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c , 1);
            } else map.put(c , map.get(c) + 1 );
        }

        uniCharCount = map.size();
        windowLength = s.length();
    }

    public boolean checkInclusion(String s1, String s2) {

        freqCal(s2);

        if(s1 == null || s2 == null)
            return false;

        int start = 0 , end = 0 ;

        while(end < s1.length()){
            char c = s1.charAt(end);

            //calculations phase
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;

                if(count == 0)
                    uniCharCount--;

                map.put(c, count);
            }

            //window is smaller than increase window length
            if(end - start + 1 < windowLength){
                end++;
            } else {

                //calculate the result
                if(uniCharCount == 0)
                    return true;

                //reverse the result
                if(map.containsKey(s1.charAt(start))){
                    int count = map.get(s1.charAt(start));

                    if(count == 0)
                        uniCharCount++;
                    count++;
                    map.put(s1.charAt(start) , count);

                }

                //increase flags
                start++;
                end++;
            }
        }

        return false;
    }

    @Test
    public void test_(){

        String input = "ooolleoooleh";
        String pattern = "hello";

        System.out.println(checkInclusion(input, pattern));
    }

}
