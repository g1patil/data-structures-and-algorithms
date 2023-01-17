package strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author g1patil
 *
 * TODO
 */
public class MinimumWindowSubstring {


    public int minWindow(String s, String t) {
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        String input = s;
        String target = t ;
        int uniqueCount = 0 , length = input.length() , answer = Integer.MAX_VALUE;

        for (char c : target.toCharArray()){
            frequencyMap.putIfAbsent(c , frequencyMap.getOrDefault(c , 0) + 1);
        }

        uniqueCount = frequencyMap.size();


        for (int slow = 0 , fast = 0 ; fast < length ; fast ++){
            char current = input.charAt(fast);

            if (frequencyMap.containsKey(current)){
                int f = frequencyMap.get(current);
                f--;
                frequencyMap.put(current , f);

                if (f == 0)
                    uniqueCount--;
            }

            if (uniqueCount == 0){
                while (uniqueCount == 0){
                    answer = Math.min(answer , fast - slow + 1);

                    char slowChar = input.charAt(slow);
                    if (frequencyMap.containsKey(slowChar)){
                        int currentFreq = frequencyMap.get(slowChar);
                        currentFreq++;

                        if (currentFreq > 0)
                            uniqueCount++;
                    }
                    slow++;
                }

            }

        }

        return answer;
    }

    @Test
    public void test_(){
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }


    @Test
    public void test_2(){
        String s = "(())";
        int buffer = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                buffer++;
            }
            else if(s.charAt(i)==')'){
                if(buffer>0) buffer--;
                System.out.println("invalid");
            }
        }

        System.out.println(buffer);
    }


}
