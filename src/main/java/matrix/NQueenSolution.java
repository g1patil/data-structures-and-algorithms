package matrix;
import java.util.*;

/***
 * Source : GeekForGeeks
 * https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/?ref=lbp
 */

public class NQueenSolution {

    static List<List<Integer> > result
            = new ArrayList<List<Integer> >();

    // Program to solve N-Queens Problem
    public void solveBoard(char[][] board, int row,
                           int rowmask, int ldmask,
                           int rdmask)
    {
        int n = board.length;

        // All_rows_filled is a bit mask
        // having all N bits set
        int all_rows_filled = (1 << n) - 1;

        // If rowmask will have all bits set,
        // means queen has been placed successfully
        // in all rows and board is displayed
        if (rowmask == all_rows_filled) {
            List<Integer> v = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'Q')
                        v.add(j + 1);
                }
            }
            result.add(v);
            return;
        }

        // We extract a bit mask(safe) by rowmask,
        // ldmask and rdmask. all set bits of 'safe'
        // indicates the safe column index for queen
        // placement of this iteration for row index(row).
        int safe = all_rows_filled
                & (~(rowmask | ldmask | rdmask));
        while (safe > 0) {

            // Extracts the right-most set bit
            // (safe column index) where queen
            // can be placed for this row
            int p = safe & (-safe);
            int col = (int)(Math.log(p) / Math.log(2));
            board[row][col] = 'Q';

            // This is very important:
            // we need to update rowmask, ldmask and rdmask
            // for next row as safe index for queen
            // placement will be decided by these three bit
            // masks.

            // We have all three rowmask, ldmask and
            // rdmask as 0 in beginning. Suppose, we are
            // placing queen at 1st column index at 0th row.
            // rowmask, ldmask and rdmask will change for
            // next row as below:

            // rowmask's 1st bit will be set by OR operation
            // rowmask = 00000000000000000000000000000010

            // ldmask will change by setting 1st
            // bit by OR operation and left shifting
            // by 1 as it has to block the next column
            // of next row because that will fall on left
            // diagonal. ldmask =
            // 00000000000000000000000000000100

            // rdmask will change by setting 1st bit
            // by OR operation and right shifting by 1
            // as it has to block the previous column
            // of next row because that will fall on right
            // diagonal. rdmask =
            // 00000000000000000000000000000001

            // these bit masks will keep updated in each
            // iteration for next row
            solveBoard(board, row + 1, rowmask | p,
                    (ldmask | p) << 1,
                    (rdmask | p) >> 1);

            // Reset right-most set bit to 0 so,
            // next iteration will continue by placing the
            // queen at another safe column index of this
            // row
            safe = safe & (safe - 1);

            // Backtracking, replace 'Q' by ' '
            board[row][col] = ' ';
        }
    }

    // Program to print board
    public void printBoard(char[][] board)
    {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String args[])
    {

        // Board size
        int n = 4;

        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }

        int rowmask = 0, ldmask = 0, rdmask = 0;
        int row = 0;

        NQueenSolution solution = new NQueenSolution();

        // Function Call
        result.clear();
        solution.solveBoard(board, row, rowmask, ldmask,
                rdmask);
        System.out.println(result);
    }
}

// This code is contributed by Nikhil Vinay

