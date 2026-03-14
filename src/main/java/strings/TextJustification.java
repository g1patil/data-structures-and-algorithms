package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < words.length; ) {
            String w = words[i];

            if(sb.length() + w.length() > maxWidth){
                String sentence = sb.toString().strip();
                int whiteSpace = maxWidth - sentence.length();
                String s = addWhiteSpaces(sentence , whiteSpace);
                result.add(s);
                sb = new StringBuilder();
            } else {
                sb.append(w);
                sb.append(" ");
                i++;
            }
        }
        if(sb.length() > 0)
            result.add(addWhiteSpaces(sb.toString(), maxWidth - sb.length()));
        return result;
    }

    private String addWhiteSpaces(String sb, int whiteSpace){
        StringBuilder space = new StringBuilder();
        for(int i = 0; i <= whiteSpace/2 && whiteSpace > 0 ; i++) {
            space.append(" ");
        }

        if(space.length() > 0){
            sb= sb.replace(" ", space.toString());
        }
        if(whiteSpace % 2 == 1)
            sb = sb + " ";
        return sb;
    }

    @Test
    public void test(){
        System.out.println(
                fullJustify(
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                        16
                )
        );
    }
}
