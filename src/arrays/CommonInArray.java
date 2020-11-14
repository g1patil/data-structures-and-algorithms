import java.util.*;

/***
 * Find common elements in two arrays
 */

public class CommonInArray {

    void getCommonElements(List<Integer[]> inputList){
        Map<Integer,Integer> result = new HashMap<>();

        inputList.forEach(list->{
            for (Integer number: list){
                if(result.containsKey(number)){
                    result.put(number,result.get(number)+1);
                } else {
                    result.put(number,1);
                }
            }
        });

        result.forEach((k,v)->{
            if(v == inputList.size()){
                System.out.println(k);
            }
        });
    }
    public static void main(String[] args) {
        Integer[] first = {1,2,3,8,100};
        Integer[] second = {100,11,2,35,9};
        Integer[] third = {6,2,100,5,10};

        List<Integer[]> list = List.of(first,second,third);
        CommonInArray commonInArray = new CommonInArray();

        commonInArray.getCommonElements(list);

    }
}
