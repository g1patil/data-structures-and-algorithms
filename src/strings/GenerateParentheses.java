package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author g1patil
 *
 * 22. Generate Parentheses
 */
@Platform(Site.LEETCODE)
@Quality(Stage.DOCUMENTED)
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if ( n <= 0)
            return new LinkedList<>();

        LinkedList<String> result = new LinkedList();
        Set<String> resultSet = new HashSet<>();
        result.add(" ");

        for (int i = 1 ; i <= n ; i ++){

            while (result.peek().length()!= (i*2)){
                String _s = result.remove();

                for (int j = 0; j < _s.length(); j++) {
                   String newString =  _s.substring(0 , j) + "()" + _s.substring(j , _s.length());
                   result.addLast(newString.replaceAll("\\s+", ""));
                }
            }
        }
        /* Remove the duplicated*/
        result.stream().forEach(r-> resultSet.add(r));
        return resultSet.stream().collect(Collectors.toList());

    }

    @Test
    public void test_(){
        System.out.println(generateParenthesis(3));
    }
}
