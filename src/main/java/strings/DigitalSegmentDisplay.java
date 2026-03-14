package strings;

import org.junit.jupiter.api.Test;

import java.util.*;

public class DigitalSegmentDisplay {

    public List<String> generateNumbers(List<String> numbers){
        Queue<String> q = new LinkedList<>();
        Set<String> set = new TreeSet<>();
        q.addAll(numbers);

        while(!q.isEmpty()){
            String number = q.poll();
            int index = number.indexOf('*');
            if(index < 0){
                set.add(number);
                continue;
            }
            q.addAll(generateNumber(number,index));
        }
        return new LinkedList<>(set);
    }

    private List<String> generateNumber(String input,int index){
        char[] chars = input.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            chars[index] = (char) (i + '0');
            result.add(new String(chars));
        }
        return result;
    }

    @Test
    public void test(){
        List<String> nums = new ArrayList<>();
        nums.add("123*5*7");
        System.out.println(
                generateNumbers(nums)
        );
    }
}
