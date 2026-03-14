package matrix;

import annotation.Platform;
import annotation.Site;

@Platform(Site.LEETCODE)
public class RangeSumQuery {

    int[][] matrixSum;
    private RangeSumQuery(int[][] matrix){
        matrixSum = new int[matrix.length][matrix[0].length];

        int count = 0;
        for (int i = 1; i < matrix.length; i++) {
            matrixSum[0][i] = matrixSum[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < matrix[0].length; i++) {
            matrixSum[i][0] = matrixSum[i-1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrixSum[i][j] = matrix[i][j] +  matrixSum[i-1][j] + matrixSum[i][j-1] - matrixSum[i-1][j-1];
            }
        }
    }

    public int getRangeSumQuery(int r1,int c1 , int r2 , int c2){
        return matrixSum[r2][c2]  - matrixSum[r1-1][c2] - matrixSum[r2][c1-1] + matrixSum[r1-1][c1-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,0,1,1},
                {1,1,0,1,1},
                {0,0,1,1,1},
                {1,0,1,1,1},
                {0,1,1,1,1}
        };
        RangeSumQuery rangeSumQuery = new RangeSumQuery(matrix);
        System.out.println(rangeSumQuery.getRangeSumQuery(0,0,3,3));

    }
}
