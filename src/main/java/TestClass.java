import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    @Test
    public void test(){
        Map<String,Integer> frequency = new HashMap<>();

        try {
            URL url = new URL("https://norvig.com/big.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                String[] words = line.split(" ");
                for(String s : words){
                    s = s.toLowerCase();
                    s = s.replaceAll("[^a-zA-Z0-9]", "");
                    frequency.putIfAbsent( s , frequency.getOrDefault(s , 0 ) + 1 );
                }
            }
            System.out.println(frequency);
            in.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    public int countSegments(String s) {
        if(s == null || s.isBlank())
            return 0;
        int result = 0;
        for(String _s : s.split(" ")){
            if(!_s.isBlank() && !_s.isEmpty()){

                result++;
            }
        }

        return result;
    }

    @Test
    public void test2(){
        System.out.println(
                countSegments(", , , ,        a, eaefa")
        );
    }

}
