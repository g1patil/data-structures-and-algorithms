package graph;

import annotation.Pattern;
import annotation.Platform;
import annotation.Site;
import annotation.Topic;
import org.junit.jupiter.api.Test;
import sorting.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author g1patil
 * 286. Walls and Gates
 */
@Pattern(Topic.DFS)
@Platform(Site.LEETCODE)
public class WallsandGates {

    List<Integer[]> roomsIndexes = new ArrayList<>();
    int[][] rooms;
    int rowBound , columnBound;

    public void buildGatesIndexes(int[][] rooms){

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    roomsIndexes.add(new Integer[]{i,j});
            }
        }
        System.out.println(roomsIndexes);
    }

    public void wallsAndGates(int[][] _rooms) {
        rooms = _rooms ;
        buildGatesIndexes(rooms);
        rowBound  = _rooms.length;
        columnBound = _rooms[0].length ;

        for (Integer[] gate : roomsIndexes){
            dfs(gate[0], gate[1], 0 );
        }
    }

    public void dfs(int i , int j , int previousValue){
        // break when there is wall , value less than or equal , or invalid
        int newValue = previousValue + 1 ;

        if (i < 0 || j < 0 || i >= rowBound || j >= columnBound || rooms[i][j] == -1 )
            return;

        if (rooms[i][j] != 0){
            if (rooms[i][j] < newValue)
                return;
            rooms[i][j] = Math.min(newValue , rooms[i][j]);
        }
        if (isValid(i-1,j))
            dfs(i - 1 , j , rooms[i][j]);
        if (isValid(i+1 , j))
            dfs(i + 1 , j , rooms[i][j]);
        if (isValid(i,j-1))
            dfs(i  , j - 1 , rooms[i][j]);
        if (isValid(i,j+1))
            dfs(i  , j + 1 , rooms[i][j]);

    }


    public boolean isValid(int row , int col){
        return isValidIndex(row, col) && isValidMove(row, col);
    }
    public boolean isValidIndex(int row , int col){
        return row >=0 && col >=0 && row < rowBound && col < columnBound ;
    }

    public boolean isValidMove(int row , int col){
        return rooms[row][col] != 0 && rooms[row][col] != -1 ;
    }

    @Test
    public void test_(){
        int[][] grid = new int[][]{
                new int[]{Integer.MAX_VALUE , -1 , 0 },
                new int[]{0 ,Integer.MAX_VALUE, Integer.MAX_VALUE  },
                new int[]{Integer.MAX_VALUE , -1 , Integer.MAX_VALUE },
        };

        ArrayUtility.print(grid);
        wallsAndGates(grid);
        ArrayUtility.print(grid);
    }
}
