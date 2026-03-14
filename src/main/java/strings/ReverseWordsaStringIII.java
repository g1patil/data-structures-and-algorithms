package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 557. Reverse Words in a String III
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ReverseWordsaStringIII {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        for(String word : s.split(" ")){
            for(int i = word.length() - 1; i >=0 ; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(" ");

        }
        return sb.toString().stripTrailing();
    }
}
