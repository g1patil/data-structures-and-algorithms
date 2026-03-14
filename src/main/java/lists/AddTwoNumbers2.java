package lists;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int sum = 0 , carry = 0;

        while( l1 != null || l2 != null || carry!= 0){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum = carry +  x + y;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }

        return dummy.next;
    }
}
