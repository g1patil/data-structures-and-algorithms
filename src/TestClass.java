import data.TreeNode;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {


    ArrayList<Long> prob = new ArrayList();
    Map<Long, Integer> map = new HashMap();
    public TestClass(int[] w) {
        int sum = 0;
        for(int i : w){
            sum+=i;
        }

        Long previous = 0L ;
        for(int i = 0 ; i < w.length ;i++){
            Long p = Math.round(((double)w[i]/sum)*100);
            map.put(p + previous , i);
            prob.add(p+ previous);
            previous+=p;
        }
        // System.out.print(prob);
        System.out.print(map);

        Collections.sort(prob);
    }

    public int getIndex(long p){
        int low= 0 , high = prob.size();

        while(low < high){
            int mid = low + (high - low)/2 ;

            if(prob.get(mid) < p){
                low = mid + 1;
            } else{
                high = mid;
            }
        }

        return high;
    }

    public int pickIndex() {
        int index = getIndex( Math.round(Math.random()*100));
        return map.get(prob.get(index == prob.size() ? index -1 : index));
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass(new int[]{3,14,1,7});
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
        System.out.println(testClass.pickIndex());
    }


}
