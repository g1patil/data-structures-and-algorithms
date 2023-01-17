package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the smallest missing number
 * 
 * 
*/
public class MissingSmallestInt {

    int getSmallestMissing(int[] input){
        int result=1;
        Set<Integer> numbers = new HashSet<>();

        for(int n: input){
            numbers.add(n);
        }

        for(int n: numbers){
            if(result == n){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MissingSmallestInt o = new MissingSmallestInt();
        System.out.println(
            o.getSmallestMissing(new int[]{1,2,3,7,8,9})
        );
        
    }
    
}