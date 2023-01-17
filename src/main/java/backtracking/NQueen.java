package backtracking;

import matrix.MatrixUtility;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * This is naive implementation of the N Queens problem
 */
public class NQueen {

    int[][] board ;
    int SIZE ;

    /**
     * Initialize the board
     * @param size  initializes the board of given size
     * @throws
     * */
    private void initialize(int size){
        if (size < 0 )
            throw new IllegalArgumentException("The size of the board should be positive");

        this.SIZE = size ;
        this.board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = 0 ;
            }
        }
    }

    private void fillThePosition(final int row , final int column , final int value){
        if ( row < 0 || column < 0)
            return;
        if ( row >= this.board.length || column >= this.board.length )
            return;

        if (this.board[row][column] == 1)
            return;
        this.board[row][column] = value ;

        //recursively call the adjacent elements to make it -1
        for (int i = 0; i < SIZE; i++) {
            if (this.board[row][i] != 1)
                this.board[row][i] = -1;
        }

        for (int i = 0; i < SIZE; i++) {
            if (this.board[i][column] != 1)
                this.board[i][column] = -1;
        }

        int rowPointer = row , columnPointer = column;
        while ( MatrixUtility.insideMatrix(rowPointer + 1 ,columnPointer + 1,SIZE)){
            rowPointer++;
            columnPointer++;
            if (this.board[rowPointer][columnPointer] != -1 )
                this.board[rowPointer][columnPointer] = -1 ;

        }

        rowPointer = row ; columnPointer = column;
        while ( MatrixUtility.insideMatrix(rowPointer - 1,columnPointer -1,SIZE)){
            rowPointer--;
            columnPointer--;
            if (this.board[rowPointer][columnPointer] != -1)
                this.board[rowPointer][columnPointer] = -1;
        }

        rowPointer = row ; columnPointer = column;
        while ( MatrixUtility.insideMatrix(rowPointer -1 ,columnPointer + 1,SIZE)){
            rowPointer--;
            columnPointer++;
            if (this.board[rowPointer][columnPointer] != -1 )
                this.board[rowPointer][columnPointer] = -1 ;

        }

        rowPointer = row ; columnPointer = column;
        while ( MatrixUtility.insideMatrix(rowPointer + 1 ,columnPointer - 1,SIZE)){
            rowPointer++;
            columnPointer--;
            if (this.board[rowPointer][columnPointer] != -1 )
                this.board[rowPointer][columnPointer] = -1 ;

        }


    }

    private void solve(final int boardSize){
        this.initialize(boardSize);

        for (int k = 0; k < boardSize; k++) {
            for (int i = k; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if ( this.board[i][j] != -1 )
                        fillThePosition(i ,j , 1 );
                }
            }
            MatrixUtility.print(this.board);
            System.out.println("-------------------");
            initialize(boardSize);
        }


    }
    @Test
    public void test_(){
        this.solve(4);
    }
}
