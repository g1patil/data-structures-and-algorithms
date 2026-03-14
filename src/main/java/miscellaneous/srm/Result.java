package miscellaneous.srm;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public static long calculateAmount(List<Integer> prices){

        if(prices.isEmpty()){
            return 0;
        }

        if(prices.size() == 1){
            return prices.get(0);
        }

        int min = prices.get(0);
        prices.remove(0);
        long result = min;

        for(Integer price : prices){
            result+= Math.max( price - min, 0);
            min = Math.min( price , min);
        }


        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(4);
        calculateAmount(list);
    }
}
