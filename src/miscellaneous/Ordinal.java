package miscellaneous;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

@Platform(Site.LEETCODE)
public class Ordinal {
    private String ordinal(Integer number){

        String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };

        switch (number % 100) {
            case 11:
            case 12:
            case 13:
                return number + "th";
            default:
                return number + sufixes[number % 10];
        }
    }

    @Test
    public void test(){
        String ordinal = ordinal(1);

    }
}
