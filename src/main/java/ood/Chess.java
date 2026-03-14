package ood;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Chess {
    Board board;
    Player[] players;
    Player turn;


    void init(){

    };

    void start(){

    }

    void terminate(){

    }

    void getState(){

    }

    void play(Player _player,int i, int j, int _i, int _j){
        board.movePiece(i,j, _i,_j);
    }
}

class Player {

}
@Data
@AllArgsConstructor
abstract class Piece {
    boolean isWhite;
    boolean isAlive;

    public Piece(){}

    abstract boolean isValidMove(int i , int j,int _i, int _j);
}

@Data
@AllArgsConstructor
class KnightPiece extends Piece{
    public KnightPiece(boolean isAlive,boolean isWhite){
        super(isWhite,isAlive);
    }

    @Override
    boolean isValidMove(int i , int j,int _i, int _j){
        return false;
    }
}

@Data
class Spots {
    int x,y;
    Piece piece;
}


@Data
class Board {

    Spots[][] spots;

    void movePiece(int i,int j , int _i , int _j){

        if(isValidMove(i,j,_i,_j)){
            spots[_i][_j].piece = spots[i][j].piece;
            spots[i][j].piece = null;
        }

    }

    boolean isValidMove(int i,int j , int _i , int _j){
        return spots[i][j].piece.isValidMove(i,j,_i,_j);
    };
}



