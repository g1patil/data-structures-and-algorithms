package lists;

import java.util.LinkedList;
import java.util.List;

/**
 * 86. Partition List Given a linked list and a value x, partition it such that
 * all nodes less than x come before nodes greater than or equal to x. You
 * should preserve the original relative order of the nodes in each of the two
 * partitions. Example: Input: head = 1->4->3->2->5->2, x = 3 Output:
 * 1->2->2->4->3->5
 */
public class PartitionList {

    /***
     * 
     * @param input input array
     * @param target element respect to which the list needs to be sorted
     * @return returns the sorted list. partitioned in a way that smaller are on the left side of the target and bigger are on the right side 
    */
    public static List<Integer> partitionList(List<Integer> input, int target){
        List<Integer> smallerList = new LinkedList<>();
        List<Integer> biggerList = new LinkedList<>();

        for(Integer element : input){
            if(element < target){
                smallerList.add(element);
            } else if (element > target){
                biggerList.add(element);
            }
        }
        smallerList.add(target);
        smallerList.addAll(biggerList);

        return smallerList;
    }

    public static void main(String[] args) {
        System.out.println(partitionList(List.of(1,9,3,8,5,10,2,4), 5));
    }
    
}