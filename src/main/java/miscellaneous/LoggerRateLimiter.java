package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author g1patil
 * 359. Logger Rate Limiter
 */
@Platform(Site.LEETCODE)
@Quality(value = Stage.DOCUMENTED , details = "passes all the cases")
public class LoggerRateLimiter {

    Map<String , Integer> loggerMap;

    public LoggerRateLimiter() {
        this.loggerMap = new ConcurrentHashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {

        /* if we put in the map, that means it was printed at least once*/
        if (!loggerMap.containsKey(message)){
            loggerMap.put(message , timestamp);
            return true;
        }

        /* since it was already printed , check the new timestamp and compare. If last
        * timestamp was older then update it. And since we are updating it , means we will print it.
        * */
        int time = loggerMap.get(message);

        if ( timestamp - time >= 10){
            loggerMap.put(message , time);
            return true;
        } else
            return false;

    }


    @Test
    @DisplayName("sample test case from LC page.")
    public void test_(){
        System.out.println(this.shouldPrintMessage(0 , "A"));
        System.out.println(this.shouldPrintMessage(0 , "B"));
        System.out.println(this.shouldPrintMessage(0 , "C"));

        System.out.println(this.shouldPrintMessage(0 , "A"));
        System.out.println(this.shouldPrintMessage(0 , "B"));
        System.out.println(this.shouldPrintMessage(0 , "C"));

        System.out.println(this.shouldPrintMessage(0 , "A"));
        System.out.println(this.shouldPrintMessage(0 , "B"));
        System.out.println(this.shouldPrintMessage(0 , "C"));

        System.out.println(this.shouldPrintMessage(0 , "A"));

    }
}

