package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 67. Add Binary
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AddBinary {

    public String[] appendZero(String a, String b){
        while (a.length() > b.length()){
            b = "0" + b ;
        }

        while (a.length() < b.length()){
            a = "0" + a ;
        }
        return new String[]{a,b};
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String[] result = appendZero(a,b);

        a = result[0];b = result[1];

        int p1 = a.length() - 1,p2 = b.length() - 1, carry = 0 ;

        while (p1 >= 0 && p2 >= 0){
            int current = carry + Character.getNumericValue(a.charAt(p1)) +
            Character.getNumericValue(b.charAt(p2));

            if (current == 3){
                sb.append(1);
                carry = 1;
            } else if(current == 2){
                sb.append(0);
                carry = 1;
            } else {
                sb.append(current);
                carry = 0;
            }

            p1--;
            p2--;
        }

        if (carry >0)
            sb.append(carry);

        return sb.reverse().toString();
    }


    @Test
    public void test_(){
        System.out.println(addBinary("11","1"));
    }
}
