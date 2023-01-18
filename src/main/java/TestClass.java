import lists.ListNode;
import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    // 160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA ,tempB = headB;
        int sizeA = size(headA),sizeB = size(headB);
        int diff= Math.abs( sizeA - sizeB );

        if(sizeA > sizeB){
            while( diff != 0){
                tempA = tempA.next;
                diff--;
            }
        } else {
            while( diff != 0){
                tempB = tempB.next;
                diff--;
            }
        }

        while(tempA != tempB && tempA != null & tempB != null){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;

    }

    private int size(ListNode root){
        ListNode temp = root;
        int size = 0 ;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    @Test
    public void test(){
        System.out.println(
                fib(3)
        );
    }

}
