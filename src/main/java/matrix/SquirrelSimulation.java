package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 573. Squirrel Simulation
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class SquirrelSimulation {

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0;
        int start = Integer.MIN_VALUE ;

        for(int[] nut : nuts){
            int d = getDistance(nut,tree);
            result+=d*2;
            start = Math.max(start , d - getDistance(nut,squirrel));
        }
        return result-start;
    }

    private int getDistance(int[] nut,int[] tree){
        return Math.abs(nut[0]-tree[0]) + Math.abs(nut[1]-tree[1]);
    }
}
