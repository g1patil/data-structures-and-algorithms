package miscellaneous;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

/*
* Given the list of products lists, give the number of ways to purchase one of each with given budget.
*
* */
public class NumberOfOptions {
    public static long getNumberOfOptions(List<Integer> p1,
                                          List<Integer> p2,
                                          List<Integer> p3,
                                          List<Integer> p4,
                                          int budget){


        int count = 0;

        for(Integer n1 : p1){
            int p1Budget = budget;
            p1Budget = p1Budget - n1;

            for(Integer n2 : p2){
                int p2Budget = p1Budget;
                p2Budget = p2Budget - n2;

                for(Integer n3 : p3){
                    int p3Budget = p2Budget;
                    p3Budget = p3Budget - n3;

                    for (Integer n4 : p4){
                        int p4Budget = p3Budget;
                        p4Budget = p4Budget - n4;

                        if( p4Budget >=0 ){
                            count++;
                        }
                    }
                }
            }
        }


        return  count;
    }

    @Test
    public void test(){
        Assertions.assertEquals( getNumberOfOptions(List.of(2,3), List.of(2,3), List.of(1,2), List.of(4),
                10
        ), 4);

    }
}
