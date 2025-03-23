package matrix;

import lists.ListNode;

public class SpiralMatricIV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = init(m, n);
        int[] direction = {1,0,0};
        ListNode temp = head;

        while(temp!=null){
            int value = temp.val;
            temp = temp.next;
            matrix[direction[1]][direction[2]] = value;
            updateDirection(direction,matrix);
        }

        return matrix;
    }

    private int[][] init(int row,int col){
        int[][] matrix = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = -1;
            }
        }
        return matrix;
    }

    private void updateDirection(int[] direction,int[][] matrix){
        int currentDirection = direction[0];
        if(currentDirection == 1){
            if(!changeDirection(direction[1],direction[2],matrix)){
                direction[2]++;
            } else {
                direction[0] = 2;
                direction[1]++;
            }
        }
        if(currentDirection == 2){
            if(!changeDirection(direction[1],direction[2],matrix)){
                direction[1]++;
            } else {
                direction[0] = 3;
                direction[2]--;
            }
        }

        if(currentDirection == 3){
            if(!changeDirection(direction[1],direction[2],matrix)){
                direction[2]--;
            } else {
                direction[0] = 4;
                direction[1]--;
            }
        }
        if(currentDirection == 4){
            if(!changeDirection(direction[1],direction[2],matrix)){
                direction[1]--;
            } else {
                direction[0] = 1;
                direction[2]++;
            }
        }
    }

    private boolean changeDirection(int row,int col,int[][] matrix){
        return  row == matrix.length-1 | col == matrix[0].length-1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.setNext(n2);
        n2.setNext(n3);

        MatrixUtility.print(new SpiralMatricIV().spiralMatrix(1,3,n1));
    }
}