package backtracking;

import matrix.MatrixUtility;
import org.junit.Test;

import java.util.List;

/**
 * @auther g1patil
 */
public class NQueen {

    int[][] board ;

    /**
     * Initialize the board
     * @param size  initializes the board of given size
     * @throws
     * */
    private void initialize(int size){
        if (size < 0 )
            throw new IllegalArgumentException("The size of the board should be positive");
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
        if ((row  > 0 && column >= 0) && board[row -1][column]!= -1 && this.board[row][column] != 1 )
            fillThePosition( row -1, column , -1 );

        if ((row + 1 < this.board.length ) && board[row + 1][column]!= -1 && board[row + 1][column]!= 1)
            fillThePosition( row + 1, column , -1 );

        if ((column + 1 < this.board.length ) && board[row][column + 1 ]!= -1 && board[row][column + 1 ]!= 1)
            fillThePosition( row , column + 1, -1 );

        if ((column -1 >= 0) && board[row][column - 1 ]!= -1 && board[row][column - 1 ]!= 1)
            fillThePosition( row , column - 1 , -1 );

        if ((row -1 >= 0 && column -1  >= 0) && board[row][column - 1 ]!= -1 && board[row][column - 1 ]!= 1)
            fillThePosition( row -1 , column -1 , -1 );

        if ((row + 1 < this.board.length && column + 1 < this.board.length) && board[row + 1][column + 1 ]!= -1 && board[row + 1][column + 1 ]!= 1)
            fillThePosition( row + 1 , column + 1, -1 );

        if (( column - 1  >= 0 && row + 1 < this.board.length) && board[row  + 1][column - 1]!= -1 && board[row  + 1][column - 1]!= 1)
            fillThePosition( row + 1 , column -1 , -1 );

        if ((row -1 >= 0 && column + 1 < this.board.length) && board[row -1][column + 1 ]!= -1 && board[row -1][column + 1 ]!= 1)
            fillThePosition( row -1 , column + 1 , -1 );
    }

    private void solve(final int boardSize){
        this.initialize(boardSize);

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if ( this.board[i][j] != -1 )
                    fillThePosition(i ,j , 1 );
            }
        }

        MatrixUtility.print(this.board);
    }
    @Test
    public void test_(){
        this.solve(3);
    }
}
