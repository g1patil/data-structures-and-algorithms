package trees.binary.leetcode;

import model.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 *
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Algorithm :
 *  First , choose the root node
 *          the optimal and the best choice is the mid of the array.
 *          Since mid of the array can have the equal distribution
 *          of children less than and greater than it.
 *          Now after mid , we have left sub array and right sub array.
 *          Now again, root for left will be mid of the left sub array and
 *          so on for right.
 *
 *          So create helper method, pass the staring and end index to it.
 *          Calculate the mid, add the mid to the tree and recursively call the
 *          function on the left sub array and right sub array using the start and
 *          end index.
 */
public class ConvertSortedArrayBST {

    TreeNode result ;
    int[] nums;

    /**
     * @param root root node where val element will go
     * @param data val that needs to be added
     * */
    private TreeNode addNode(TreeNode root , int data){
        if (root == null){
            return new TreeNode(data);
        }

        if (root.getVal() == data)
            return root;
        if ( data < root.getVal())
            root.left = addNode(root.left , data);
        else root.right = addNode(root.right, data);

        return root;
    }

    /**
     * Main function will builds the tree from sorted array.
     * */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return sortedArrayToBSTHelper(nums , 0 , nums.length );
    }

    /**
     * Given sorted array, and two indexes , build the binary tree
     * @param i_ lower bound of the array
     * @param j_ higher bound of the sorted array
     * @param nums int array from which the tree needs to be build
     * */
    public TreeNode sortedArrayToBSTHelper(int[] nums , int i_ , int j_ ) {
        /* if two pointers cross each other, then break */
        if (j_ < i_)
            return result;

        //calculate mid
        int midIndex = ( i_ + j_) / 2  ;

        //if mid, crosses the array then return
        if ( midIndex >= nums.length)
            return result;
        // add the mid to the tree
        result = addNode(result , nums[midIndex]);

        //recursively call the function on right and left sub array
        sortedArrayToBSTHelper(nums , i_ , midIndex -1 );
        sortedArrayToBSTHelper(nums , midIndex + 1  , j_ );
        return result;
    }

    public TreeNode sortedArrayToBSTOptimal(int[] nums){
        this.nums = nums;
        return sortedArrayToBSTOptimalHelper(0 , nums.length -1 ) ;
    }

    public TreeNode sortedArrayToBSTOptimalHelper(int i , int j){

        if (i  > j )
            return null;

        int mid = (i + j)/2;
        TreeNode root = new TreeNode(this.nums[mid]);

        root.left = sortedArrayToBSTOptimalHelper( i , mid -1);
        root.right = sortedArrayToBSTOptimalHelper( mid + 1 , j );

        return root;
    }

    @Test
    public void test_(){
        TreeNode treeNode = sortedArrayToBSTOptimal(new int[]{0,1,2,3,4,5,6});
        treeNode.printTree(treeNode);
    }
}
