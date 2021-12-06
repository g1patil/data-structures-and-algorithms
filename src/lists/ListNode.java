package lists;

/**
 * @auther g1patil
 */
public class ListNode {
    public int data;
    public String d;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }

    public ListNode(String data){
        this.d = data;
        this.next = null;
    }


    public ListNode setNext(ListNode next){
        this.next = next;
        return next;
    }

    public ListNode setData(int data){
        this.data = data;
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
            System.out.print( p1.data + " -> ");
            p1 = p1.next ;
        }
        System.out.print( "null" );
    }
}
