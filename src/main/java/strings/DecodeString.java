package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 394. Decode String
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class DecodeString {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ) {
            Character current = s.charAt(i);
            if(Character.isDigit(current)){
                int times = Integer.parseInt(String.valueOf(current));
                while(Character.isDigit(s.charAt(i+1))){
                    times = times*10 + Character.getNumericValue(s.charAt(i+1));
                    i++;
                }
                i = getSubString(i+1 , s ,sb, times);
            } else {
                sb.append(current);
                i++;
            }
        }
        return sb.lastIndexOf("[") == -1 ? sb.toString() : decodeString(sb.toString());

    }

    private int getSubString(int p1, String s, StringBuilder sb, int times){
        int count = 0 ;

        for(int p2 = p1; p2 < s.length(); p2++) {

            if(s.charAt(p2) == '['){
                count++;
            } else if(s.charAt(p2) == ']'){
                count--;
            }
            if(p1!=p2 && count == 0){
                String sub = s.substring(p1+1,p2);
                for(int i = times; i >0 ; i--) {
                    sb.append(sub);
                }
                return p2+1;
            }
        }

        return p1+1;
    }

    @Test
    public void test(){
        System.out.println(
                decodeString("100[leetcode]")
        );
    }
}
