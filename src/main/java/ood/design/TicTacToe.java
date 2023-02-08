package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 348. Design Tic-Tac-Toe
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class TicTacToe {

    private int[][] grid;
    public TicTacToe(int n) {
        grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        return checkWinner(row,col,player) ? player : 0;
    }

    private boolean checkWinner(int row, int col,int player) {
        return allSameInRow(row,col,player) || allSameInCol(row,col,player) ||
                allSameInDiagonal1(row,col,player) ||
                allSameInDiagonal2(row,col,player) ;
    }

    private boolean allSameInDiagonal1(int row, int col, int player) {

        for (int i = 0; i < grid.length; i++) {
            if ( grid[i][i]!= player){
                return false;
            }
        }
        return true;
    }

    private boolean allSameInDiagonal2(int row, int col, int player) {

        int r = 0 , c = grid[0].length-1;
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][ c - i]!= player)
                return false;
        }
        return true;
    }

    private boolean allSameInCol(int row,int col,int player) {
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            if (grid[i][col]!=player)
                return false;
        }
        return true;
    }

    private boolean allSameInRow(int row,int col,int player) {
        int length = grid[0].length;

        for (int i = 0; i < length; i++) {
            if (grid[row][i]!= player)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        ticTacToe.move(0,0,2);

                ticTacToe.move(0,1,1);

        System.out.println(
                ticTacToe.move(1,1,2)
        );

    }
}
