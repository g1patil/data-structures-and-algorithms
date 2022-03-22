package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSubArraySum {
    public static int getHeaviestPackage(int[] packages){
        int n = packages.length-1;
        int ans = packages[n];
        int curSum = 0;
        for(int i = n-1; i >= 0; i--){
            if(packages[i] < packages[i+1]){
                packages[i] += packages[i+1];
                curSum = packages[i];
            }
            else{
                curSum = packages[i];
            }
            ans = Math.max(ans, curSum);
        }
        return ans;
    }


    @Test
    public void test(){
        System.out.println(getHeaviestPackage(new int[]{Integer.MAX_VALUE ,1 , Integer.MAX_VALUE}));
    }
}
