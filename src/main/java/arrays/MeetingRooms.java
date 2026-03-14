package arrays;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));

        for(int i = 1; i < intervals.length; i++) {
            if( intervals[i-1][1] > intervals[i][0] )
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(
                canAttendMeetings( new int[][]{
                        new int[]{0,30},
                        new int[]{5,10},
                        new int[]{15,20},
                })
        );
    }

    @Test
    public void test2(){
        System.out.println(
                canAttendMeetings( new int[][]{
                        new int[]{7,10},
                        new int[]{2,4}
                })
        );
    }
}
