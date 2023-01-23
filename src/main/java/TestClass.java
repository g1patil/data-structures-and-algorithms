import lists.ListNode;
import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    // 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while( slow != fast){
            if(fast == null || fast.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(
        );
    }

}
