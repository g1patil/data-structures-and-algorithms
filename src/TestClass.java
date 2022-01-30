import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {

    ArrayList<Integer> list = new ArrayList<>();
    class Query{
        int[] ints = new int[2];
    }
    List answerQueries(ArrayList<Query> queries, int N){
        ArrayList<Integer> answer = new ArrayList<>();
        for (Query query : queries){

            switch (query.ints[0]){
                case 1 :
                    list.add(query.ints[2]);
                    break;
                case 2 :
                    if (list.isEmpty()){
                        answer.add(-1);
                        break;
                    }
                    int ans = getAnwer(query.ints[2]);
                    answer.add(ans);
                    break;
            }
        }

        return answer ;
    }

    private int getAnwer(int index) {
        int low = 0 ;
        int high = list.size();

        while (low < high){
            int mid = (low + high)/2 ;

            if (list.get(mid) > index){
                high = mid;
            } else if(list.get(mid) < index) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return high;
    }
    @Test
    public void test_(){
        ArrayList<Query> queries = new ArrayList<>();

        System.out.println(answerQueries(null,1));
    }
}
