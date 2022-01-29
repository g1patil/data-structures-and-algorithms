package arrays;

/**
 * @author g1patil
 * See main solution at the bottom
 */


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/* main solution
class Solution {
    int sum = 0 ;

    public void depthSumHelper(List<NestedInteger> nestedList , int depth){

        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum+= depth*ni.getInteger();
            } else{
                depthSumHelper(ni.getList() , depth+1);
            }

        }
    }

    public int depthSum(List<NestedInteger> nestedList) {
        depthSumHelper(nestedList , 1);
        return sum;
    }
}
*/
