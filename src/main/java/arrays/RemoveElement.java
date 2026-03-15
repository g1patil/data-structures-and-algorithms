package arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int result = -1 ;
        for(int p1 = 0, p2 = p1; p1 < nums.length; p1++){
            
            if( nums[p1] !=val)
                continue;
            p2 = getFirstNoEqual(nums, val, p1);

            if(p2 == -1){
                return p1 ;
            }
            // swap values
            nums[p1] = nums[p2];
            nums[p2] = val;


            result = p1 ;
        }

        if(result == -1)
            return nums.length;

        return result  ;
    }

    public int getFirstNoEqual(int[] nums, int targetVal, int index){
        for(int i = index ; i < nums.length ; i++){
            if(targetVal != nums[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int index = removeElement.removeElement(nums, 2);

        for (int i = 0; i < index; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
