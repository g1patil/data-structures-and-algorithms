package matrix;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 422. Valid Word Square
 * */

@Platform(Site.LEETCODE)
public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++) {
            if(!words.get(i).equals(buildWord(i,words))){
                return false;
            }
        }

        return true;
    }

    public String buildWord(int index , List<String> words){
        StringBuilder sb = new StringBuilder();
        for(String s : words){
            if(index < s.length())
                sb.append(s.charAt(index));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(validWordSquare(
                List.of("abcd","bnrt","crm","dt")
        ));
    }

    @Test
    public void test2(){
        System.out.println(validWordSquare(
                List.of("ball","area","read","lady")
        ));
    }

    @Test
    public void test3(){
        System.out.println(validWordSquare(
                List.of("abc","asee","let","lep")
        ));
    }
}
