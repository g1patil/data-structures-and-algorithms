package strings;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {


    public boolean confusingNumber(int n) {
        if(n == 0)
            return false;

        StringBuilder sb = new StringBuilder();
        sb.append(n);

        StringBuilder sb2 = new StringBuilder();
        Map<Integer,Integer> map = buildIntMap();

        int num = n;
        while(num != 0){
            int d = num % 10;
            num = num / 10 ;

            if(!map.containsKey(d)){
                return false;
            } else {
                sb2.append( map.get(d));
            }
        }

        return !sb.toString().equals(sb2.toString());
    }

    private Map<Integer,Integer> buildIntMap(){
        Map<Integer,Integer> map = new HashMap();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        return map;
    }


    @Test
    public void test(){
        System.out.println(
                confusingNumber(0)
        );
    }

}
