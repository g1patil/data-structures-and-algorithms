package dynamicprogramming.knapsack;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 1235. Maximum Profit in Job Scheduling
 * Given the set of jobs and their values, schedule the jobs in a way that they
 * are nonoverlapping and we get maximum value out of it.
 *
 * The input is modified from the Leetcode to make it easy. But the concept is same.
 *
 */
@Platform(Site.LEETCODE)
@Quality(Stage.DOCUMENTED)
public class MaximumProfitJobScheduling {


    /**
     * Returns the maximum profit/value that can be gained by scheduling the
     * jobs in non overlapping way.
     *
     * @param jobs list of jobs
     * @param pointer pointer to keep track of the jobs
     * @param start pointer to current start time
     * @return maximum value that can be achieved
     * */
    private int getMaxProfit(Job[] jobs , int start , int pointer){
        if ( pointer >= jobs.length)
            return 0;

        /* If the start time of job is greater than equal to current pointer at the time , then we can choose of not choose*/
        if ( jobs[pointer].start >= start ) {
            return Math.max(
                    jobs[pointer].value + getMaxProfit(jobs , jobs[pointer].end , pointer + 1 ),
                    getMaxProfit(jobs , start , pointer + 1 )
            );
        }

        /* if the start time if greater then we have to skip it. */
        return getMaxProfit(jobs , start , pointer + 1 );
    }

    @Test
    @DisplayName("Example test case from LC")
    public void test_(){
        Job[] jobs = new Job[]{
                new Job(1 , 3 , 20),
                new Job(2 , 5 , 20),
                new Job(3 , 10 , 100),
                new Job(4 , 6 , 70),
                new Job(6 , 9 , 60),
        };
        Assertions.assertEquals(150 , getMaxProfit(jobs , 1 , 0 ));
    }
}

/**
 * Data class to hold the job
 * */
class Job{
    public int start;
    public int end;
    public int value;

    Job(int start_ , int end_ , int value_){
        this.start = start_;this.end = end_;this.value = value_;
    }
}
