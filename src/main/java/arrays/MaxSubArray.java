package arrays;

public class MaxSubArray{

    public String getname(){
        return null;
    }

    public int getname(int name){
        return 0;
    }
    static int getSum(int[] input){
        int max = Integer.MIN_VALUE,currentSum=0;

        for(int number : input){
            currentSum = Math.max(number, number + currentSum);  
            max = Math.max(currentSum, max); 
        }

        return max;
    }
    public static void main(String[] args) {
        int[] input = {-2,-3,4,-1,-2,1,5,-3};
        int[] input1 = {-2,-3,-4,-1,-2,-1,-5,-3};

        System.out.println(getSum(input1));
    }
}