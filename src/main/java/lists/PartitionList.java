package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 86. Partition List Given a linked list and a value x, partition it such that
 * all children less than x come before children greater than or equal to x. You
 * should preserve the original relative order of the children in each of the two
 * partitions. Example: Input: head = 1->4->3->2->5->2, x = 3 Output:
 * 1->2->2->4->3->5
 */
@Platform(Site.LEETCODE)
@Quality(Stage.DOCUMENTED)
public class PartitionList {

    /**
     * Sort the list in a way that all the elements < x are on left side
     * and all the elements > x are on the right side of the linked list
     *
     * Create two separate LL , iterate over main list and keep adding the
     * elements to respective list based on the value
     * Attack the second list at the end of the first list,
     * and then return the first list.
     * @param x comparison value
     * @param head head of the list
     * @return returns the sorted list
     * */
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;

        ListNode finalListHead = new ListNode(Integer.MIN_VALUE);
        ListNode secondListHead = new ListNode(Integer.MIN_VALUE);
        ListNode listSmall = finalListHead;
        ListNode listBig = secondListHead;

        while (head!=null){
            if (head.val < x){
                listSmall.next = new ListNode(head.val);
                listSmall = listSmall.next;
            } else {
                listBig.next = new ListNode(head.val);
                listBig = listBig.next;
            }

            head = head.next;
        }

        listSmall.next = secondListHead.next;
        return finalListHead.next;
    }

    /***
     * Uses the collection framework of Java.
     * @param input input array
     * @param target element respect to which the list needs to be sorted
     * @return returns the sorted list. partitioned in a way that
     * smaller are on the left side of the target and bigger are on the right side
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


    @Test
    public void test_(){
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(10);

        n1.setNext(n2).setNext(n3).setNext(n4);

        partition(n1 , 6 );
    }
    
}