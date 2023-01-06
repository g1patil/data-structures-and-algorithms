package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 541. Reverse String II
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i+=2*k) {
            reverse(s , sb , i ,  i + k - 1 , i + k , i + 2*k - 1);
        }
        return sb.toString();
    }

    public StringBuilder reverse(String s , StringBuilder t , int start , int end , int _start , int _end){
        if(end >= s.length()){
            end = s.length() - 1;
        }
        while(end >= start){
            t.append( s.charAt(end));
            end--;
        }

        while(_start < s.length() &&  _start <= _end){
            t.append(s.charAt(_start++));
        }
        return t;
    }

    @Test
    public void test(){
        System.out.println(reverseStr("abcdefg",2));
    }
}
