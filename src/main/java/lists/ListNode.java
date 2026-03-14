package lists;

/**
 * @author g1patil
 */
public class ListNode {
    public int val;
    public String d;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(String val){
        this.d = val;
        this.next = null;
    }


    public ListNode setNext(ListNode next){
        this.next = next;
        return next;
    }

    public ListNode setVal(int val){
        this.val = val;
        return this;
    }

    public int size(){
        int size = 0;
        if (this == null) return 0;

        ListNode temp = this ;
        while (temp!=null){
            size ++;
            temp = temp.next;
        }
        return size;
    }

    public void printList(){
        ListNode p1 = this ;

        while (p1 != null){
            System.out.print( p1.val + " -> ");
            p1 = p1.next ;
        }
        System.out.print( "null" );
    }
}
