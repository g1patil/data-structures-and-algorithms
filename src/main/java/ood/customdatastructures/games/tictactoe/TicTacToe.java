package ood.customdatastructures.games.tictactoe;

import org.junit.jupiter.api.Test;

/**
 * My attempt on tic tac toe OOD game
 * */
public interface TicTacToe {
    boolean makeMove(int i,int j,ACTION action );
    ACTION checkWinner();
    void startGame(ACTION action);
    void printGame();
}

class TicTacToeImpl implements TicTacToe {

    private static int ROW = 3 , COL = 3;
    private ACTION[][] game ;
    private ACTION currentAction;


    @Override
    public boolean makeMove(int i, int j, ACTION action){
        if(currentAction != action && game[i][j] == null)
            return false;
        game[i][j] = action;
        currentAction = action == ACTION.O ? ACTION.X : ACTION.O;
        printGame();
        ACTION winner = checkWinner();
        if(winner != null)
            System.out.println("We have winner : " + action);
        return true;
    }

    @Override
    public ACTION checkWinner(){
        if( game[0][0] == game[1][0] && game[1][0] == game[2][0])
            return game[0][0];
        if( game[0][1] == game[1][1] && game[1][1] == game[2][1])
            return game[0][1];
        if( game[0][2] == game[1][2] && game[1][2] == game[2][2])
            return game[0][2];
        if( game[0][0] == game[0][1] && game[0][1] == game[0][2])
            return game[0][0];
        if( game[1][0] == game[1][1] && game[1][1] == game[1][2])
            return game[1][0];
        if( game[2][0] == game[2][1] && game[2][1] == game[2][2])
            return game[2][0];
        return null;
    }

    @Override
    public void startGame(ACTION action){
        game = new ACTION[ROW][COL];
        currentAction = action;
    }

    @Override
    public void printGame(){
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                System.out.print(game[i][j] + "     ");
            }
            System.out.println();
        }
        System.out.println("____________________");
    }

    @Test
    public void test(){
        startGame(ACTION.O);
        makeMove(0,0,ACTION.O);
        makeMove(1,1,ACTION.X);
        makeMove(2,0,ACTION.O);
        makeMove(1,0,ACTION.X);
        makeMove(0,2,ACTION.O);
        makeMove(1,2,ACTION.X);
    }
}
enum ACTION {
    X,
    O
}
