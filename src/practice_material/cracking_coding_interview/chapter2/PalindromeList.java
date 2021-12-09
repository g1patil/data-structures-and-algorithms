package practice_material.cracking_coding_interview.chapter2;

import lists.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @auther g1patil
 */
public class PalindromeList {

    private boolean isPalindrome(ListNode root){
        Stack<Integer> integerStack = new Stack<>();

        ListNode p1 = root ;

        while ( p1!=null){
            integerStack.push( p1.data );
            p1 = p1.next ;
        }

        p1 = root ;

        while (!integerStack.isEmpty()){
            if ( p1.data != integerStack.pop()){
                return false;
            }
            p1 = p1.next;
        }
        return true ;
    }

    @Test
    public void test_(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(3);

        n1.setNext(n2).setNext(n3).setNext(n4).setNext(n5).setNext(n6);
        n1.printList();
        System.out.println();
        System.out.println(isPalindrome(n1));

    }

    @Test
    public void test_2(){
        ListNode n1 = new ListNode(3);

        n1.printList();
        System.out.println();
        System.out.println(isPalindrome(n1));

    }

    @Test
    public void test_3(){
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);

        n1.setNext(n2);
        n1.printList();
        System.out.println();
        System.out.println(isPalindrome(n1));

    }
}
