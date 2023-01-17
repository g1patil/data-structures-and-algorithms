package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author g1patil
 * 249. Group Shifted Strings
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strings){

            if (str.length() == 1){
                if(map.containsKey("-1")){
                    map.get("-1").add(str);
                }else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put( "-1" , list );
                }
            } else {
                StringBuilder pattern = new StringBuilder();
                for (int i = 1; i < str.length(); i++) {
                    int diff = str.charAt(i-1) - str.charAt(i);
                    pattern.append( diff > 0 ? diff : getPositive(diff));
                }
                String patternString = pattern.toString();
                if(map.containsKey(patternString)){
                    map.get(patternString).add(str);
                }else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put( patternString , list );
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        map.keySet().forEach(k-> result.add(map.get(k)));

        return result;
    }

    public int getPositive(int num){
        return 26 + num ;
    }

    @Test
    public void test_(){
        String[] strings = new String[]{
                "abc","bcd","acef","xyz","az","ba","a","z"
        };
        System.out.println(groupStrings(strings));
    }
}
