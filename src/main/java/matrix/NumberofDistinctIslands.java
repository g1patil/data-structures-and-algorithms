package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class NumberofDistinctIslands {

    public int numDistinctIslands(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                StringBuilder sb = new StringBuilder();
                getShape(i,j,grid,seen,sb,"o");
                String s = sb.toString();
                if(s.length() > 1)
                    set.add(s);
            }
        }
        return set.size();
    }

    private void getShape(int i, int j, int[][] g , boolean[][] seen ,  StringBuilder sb, String o){
        if(i < 0 || j < 0 || i >= g.length || j >= g[0].length || seen[i][j] || g[i][j] == 0)
            return;
        seen[i][j] = true;
        sb.append(o);
        getShape(i,j+1,g,seen,sb,"r");
        getShape(i,j-1,g,seen,sb,"l");
        getShape(i-1,j,g,seen,sb,"u");
        getShape(i+1,j,g,seen,sb,"d");
        sb.append("b");
    }
}
