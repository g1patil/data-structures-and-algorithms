package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author jivanpatil
 * 1832. Check if the Sentence Is Pangram
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class CheckSentencePangram {

    public boolean checkIfPangram(String sentence) {
        boolean[] fre = new boolean[26];
        for (char c : sentence.toCharArray())
            fre[c-'a'] = true;
        for (boolean f : fre)
            if (!f)
                return false;
        return true;
    }

    @Test
    public void test(){
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
