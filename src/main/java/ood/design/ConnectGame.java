package ood.design;

import java.util.*;

public class ConnectGame {

    private char[][] grid;
    private int row,col;
    private Map<Integer, Set<Character>> currentScore ;
    private Map<Character,Integer> playerScore;

    public ConnectGame(int r , int c){
        grid = new char[r][c];
        row = r;col = c;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                grid[i][j] = '*';
            }
        }
        currentScore = new TreeMap<>(Comparator.reverseOrder());
        playerScore = new HashMap<>();
    }

    public boolean isWinner(int column,int r, char c){
        return playerScore.get(c) > 2 ;
    }

    private int getDFS(int r, int c, char _c, boolean[][] visited){
        if(r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || grid[r][c] != _c){
            return 0;
        }
        visited[r][c] = true;
        return 1 + getDFS(r,c+1,_c,visited) +
                getDFS(r,c-1,_c,visited) +
                getDFS(r+1,c,_c,visited) +
                getDFS(r-1,c,_c,visited) ;
    }

    public void element(int column , char c){
        int r = row-1;
        while(r >= 0 && grid[r][column]!='*'){
            r--;
        }
        grid[r][column] = c;
        addScore(r,column,c);
        if(isWinner(r,column,c))
            System.out.println("Winner !! ");
    }

    private void addScore(int r, int column, char c){
        int oldScore = playerScore.getOrDefault(c,0);
        int newScore = Math.max(getDFS(r,column,c,new boolean[row][col]) , oldScore);

        if(currentScore.containsKey(oldScore)){
            currentScore.get(oldScore).remove(c);
            if(currentScore.get(oldScore).isEmpty())
                currentScore.remove(oldScore);
        }

        currentScore.putIfAbsent(newScore,new HashSet<>());
        currentScore.get(newScore).add(c);

        playerScore.put(c,newScore);
    }

    public void print(){
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col ; j++) {
                System.out.print(grid[i][j] + "     ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        ConnectGame game = new ConnectGame(4,4);
        game.element(0,'R');
        game.element(1,'B');
        game.element(1,'B');
        game.element(1,'B');
        game.print();
        System.out.println(game.currentScore);
    }
}
