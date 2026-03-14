package ood;

import java.util.Scanner;

public class TicTacToe {
    TicTacBoard board;
    TicTacPlayer cross,circle;
    TicTacPlayer currentPlayer;

    public TicTacToe(){
        board = new TicTacBoard();
    }
    
    void initGame(){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter plyaer one name : ");
        String name = sc.nextLine();

        System.out.print("Enter plyaer action : ");
        String action = sc.nextLine();
        cross = new TicTacPlayer(name, TicTacBoard.TicTacAction.getAction(action));


        System.out.print("Enter plyaer two name : ");
        name = sc.nextLine();

        System.out.print("Enter plyaer action : ");
        action = sc.nextLine();
        circle = new TicTacPlayer(name, TicTacBoard.TicTacAction.getAction(action));

        currentPlayer = circle;
    }
    
    void statusGame(){
        board.currentStatus();
    }

    void makeMove(){
        int[] move = getInputs();
        board.update((int) move[0],move[1],currentPlayer.action);
        currentPlayer = currentPlayer == cross ? circle : cross;
    }

    int[] getInputs(){
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter row and col  ");
        int i = sc.nextInt();
        int j = sc.nextInt();
        return new int[]{i , j};
    }

    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initGame();

        while(ticTacToe.board.isActive){
            ticTacToe.makeMove();
            ticTacToe.board.currentStatus();
        }

    }
}

class TicTacBoard {

    TicTacAction[][] matrix;
    boolean isActive = true;

    public TicTacBoard(){
        matrix = new TicTacAction[3][3];
    }
    
    void update(int i , int j , TicTacAction action){
        matrix[i][j] = action;
    }
    
    void currentStatus(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    
    enum TicTacAction {
        CROSS("x"),CIRCLE("o");

        public final String name;

        TicTacAction(String x){
            this.name = x;
        }

        public static TicTacAction getAction(String _a){
            for(TicTacAction action : values()){
                if(_a.equals(action.name))
                    return action;
            }
            return CIRCLE;
        }
    }
}

class TicTacPlayer {
    String name;
    TicTacBoard.TicTacAction action;
    
    TicTacPlayer(String _name, TicTacBoard.TicTacAction _action){
        this.name = _name;
        this.action = _action; 
    }
}