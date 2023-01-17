package dynamicprogramming;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * @author g1patil
 * Reference : https://leetcode.com/yu6
 * 552. Student Attendance Record II
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        int[][][] mem = new int[n][2][3];
        return dfs(0, 0, 0, n, mem);
    }
    private int dfs(int i, int A, int L, int n, int[][][] mem) {
        if(i==n)
            return 1;
        if(mem[i][A][L]!=0)
            return mem[i][A][L];
        long res = dfs(i+1, A, 0, n, mem);  //P

        if(A==0)
            res += dfs(i+1, 1, 0, n, mem); //A
        if(L<2)
            res += dfs(i+1, A, L+1, n, mem); //L
        return mem[i][A][L] = (int)(res%1000000007);
    }
}
