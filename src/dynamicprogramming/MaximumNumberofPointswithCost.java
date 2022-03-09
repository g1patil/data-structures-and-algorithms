package dynamicprogramming;

/**
 * @author g1patil
 */
public class MaximumNumberofPointswithCost {

    public long maxPoints(int[][] P) {
        int m = P.length, n = P[0].length;
        long[] pre = new long[n];
        for (int i = 0; i < n; ++i)
            pre[i] = P[0][i];
        for (int i = 0; i < m - 1; ++i){
            long[] lft = new long[n], rgt = new long[n], cur = new long[n];

            lft[0] = pre[0];
            rgt[n - 1] = pre[n - 1];

            for (int j = 1; j < n; ++j)
                lft[j] = Math.max(lft[j - 1] - 1, pre[j]);
            for (int j = n - 2; j >= 0; --j)
                rgt[j] = Math.max(rgt[j + 1] - 1, pre[j]);
            for (int j = 0; j < n; ++j)
                cur[j] = P[i + 1][j] + Math.max(lft[j], rgt[j]);

            pre = cur;
        }
        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, pre[i]);
        return ans;
    }
}
