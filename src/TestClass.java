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


    public String getSong(String[] songs){
        int max = 0;
        String result = "";
        Map<String,Integer> fre = new HashMap<>();
        for (String song : songs){
            fre.put( song , fre.getOrDefault(song  , 0) + 1 );
        }

        for(String s : fre.keySet()){
            int count = fre.get(s);
            if (count > max){
                result = s;
                max = count;
            }
        }
        return result;
    }

    @Test
    public void test_(){
        String[] songs = new String[]{
                "a","b","c","a","a","a","f","f","g"
        };
        getSong(songs);
    }


}
