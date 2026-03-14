package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * 243. Shortest Word Distance
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ShortestWordDistance {

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int p1 = -1 , p2 = -1;
        int result = wordsDict.length;

        for(int i = 0 ; i < wordsDict.length ; i ++){

            if(word1.equals(wordsDict[i])){
                p1 = i;
            } else if(word2.equals(wordsDict[i])){
                p2 = i;
            }

            if(p1 != -1 && p2 != -1){
                result = Math.min(result, Math.abs(p1-p2));
            }
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(shortestDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding",
                "practice"
        ));
    }

    @Test
    public void test2(){
        System.out.println(shortestDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding",
                "practice"
        ));
    }
}
