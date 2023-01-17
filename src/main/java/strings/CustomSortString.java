package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author g1patil
 * 791. Custom Sort String
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class CustomSortString {

    Map<Character,Integer> orderMap = new HashMap();

    public void buildOrderMap(String order){
        int index = 1 ;
        for(char c : order.toCharArray()){
            orderMap.put(c , index);
            index++;
        }
    }

    //n log n
    public String customSortString(String order, String s) {
        if(order == null || s == null)
            return null;

        buildOrderMap(order);

        PriorityQueue<Character> queue = new PriorityQueue(Comparator.comparingInt(o-> orderMap.getOrDefault(o , orderMap.size()) + 1));
        for(char c : s.toCharArray()){
            queue.add(c);
        }
        StringBuilder sb = new StringBuilder("");

        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }

        if(sb.length()< order.length()){
            sb.append(order.substring(sb.length(), s.length()));
        }

        return sb.toString();
    }

    public String customSortStringOptimal(String order, String s) {
        if(order == null || s == null)
            return null;

        int[] bucket = new int[26];

        for( char c : s.toCharArray()){
            bucket[c - 'a']++;
        }

        StringBuilder sb  = new StringBuilder();

        for ( char c : order.toCharArray()){

            for(int i = 0 ; i < bucket[ c - 'a'] ; i ++){
                sb.append(c);
            }
            bucket[c - 'a'] = 0 ;
        }

        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < bucket[i] ; j ++){
                sb.append( (char) ('a' +  i ) );
            }
        }

        return sb.toString();
    }

    @Test
    public void test_(){
        System.out.println(customSortStringOptimal("cbafg","abcd"));
    }
}
