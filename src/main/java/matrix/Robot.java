package matrix;

/**
 * 2069. Walking Robot Simulation II
 * */
//my impl . ths is not same as the leetcode. Duretions and orientation is changed.
public class Robot {

    int[][] direction = new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
    };
    int currentDurection = 0;
    int currentRow,curentCol,ROW,COL;

    public Robot(int width, int height) {
        ROW = height;
        COL = width;
        currentRow = 0;
        curentCol = 0;
    }

    public void step(int num) {
        for(int i = num; i >0 ; i--) {
            int newRow = currentRow + direction[currentDurection][0];
            int newCol = curentCol + direction[currentDurection][1];
            if(isOutOfBound(newRow,newCol)){
                changeDirection();
            }
            makeMove();
        }
    }

    private void makeMove(){
        currentRow = currentRow + direction[currentDurection][0];
        curentCol = curentCol + direction[currentDurection][1];
    }

    public int[] getPos() {
        System.out.println(curentCol + " : " + currentRow);
        return new int[]{curentCol,currentRow};
    }

    private boolean isOutOfBound(int i , int j){
        return i < 0 || j < 0 || i >= ROW || j >= COL;
    }

    private void changeDirection(){
        switch(currentDurection){
            case 0 -> this.currentDurection = 3;
            case 1 -> this.currentDurection = 2;
            case 2 -> this.currentDurection = 0;
            case 3 -> this.currentDurection = 1;
        }
    }
    public String getDir() {
        return switch(currentDurection){
            case 0 -> "East";
            case 1-> "West";
            case 2 -> "South";
            default -> "North";
        };
    }

    public static void main(String[] args){
        Robot robot = new Robot(6,3);
        robot.getPos();
        robot.step(2);
        robot.step(2);
        robot.getPos();
        robot.step(2);
        robot.getPos();
        robot.step(1);
        robot.getPos();
        robot.step(4);
        robot.getPos();
    }
}
