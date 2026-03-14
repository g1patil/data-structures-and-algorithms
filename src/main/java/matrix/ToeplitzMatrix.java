package matrix;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 * 766. Toeplitz Matrix
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class ToeplitzMatrix {

    public boolean isToeplitzMatrixTraversal(int row , int col , int[][] mat){
        int rowBound = mat.length ;
        int colBound = mat[0].length;

        int r = row , c = col , target = mat[row][col] ;

        while (r < rowBound && c < colBound){
            if (mat[r][c] != target)
                return false;
            r ++;
            c ++;
        }

        return true ;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean r1 = true , r2 = true ;
        for (int i = 0; i < matrix.length; i++) {
            if(!isToeplitzMatrixTraversal(i , 0 , matrix)){
                r1 = false ;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if(!isToeplitzMatrixTraversal(0 , i , matrix)){
                r2 = false;
            }
        }

        return r1 && r2  ;
    }

    @Test
    public void test_(){
        int[][] mat = {
                new int[]{11,74,0,93},
                new int[]{40,11,74,7}
        };

        System.out.println(isToeplitzMatrix(mat));
    }
}
