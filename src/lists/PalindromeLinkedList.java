package lists;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 *234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class PalindromeLinkedList {

    /**
     * @param head current node
     * @return true/false - true if the list is palindrome - false if otherwise
     * */
    private boolean isPalindrome(Node head) {
        if(head == null || head.next== null){
            return true;
        }

        Stack<Integer> integerStack = new Stack<>();

        while (head!=null){
            if(integerStack.isEmpty()){
                integerStack.push(head.data);
            } else if(integerStack.peek() == head.data){
                integerStack.pop();
            } else {
                integerStack.push(head.data);
            }
            head = head.next;
        }

        return integerStack.isEmpty();
    }

    private boolean isPalindromeOptimal(Node head) {
        if(head == null || head.next== null){
            return true;
        }

        Stack<Integer> integerStack = new Stack<>();

        while (head!=null){
            if(integerStack.isEmpty()){
                integerStack.push(head.data);
            } else if(integerStack.peek() == head.data){
                integerStack.pop();
            } else {
                integerStack.push(head.data);
            }
            head = head.next;
        }

        return integerStack.isEmpty();
    }

    @Test
    public void test(){
        Node head = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);

        head.setNext(n2).setNext(n3);

        Assertions.assertFalse(isPalindrome(head));
    }


    @Test
    public void test2(){
        Node head = new Node(4);
        Node n2 = new Node(5);
        Node n3 = new Node(6);
        Node n3a = new Node(6);
        Node n4 = new Node(5);
        Node n5 = new Node(4);

        head.setNext(n2).setNext(n3).setNext(n3a).setNext(n4).setNext(n5);

        Assertions.assertTrue(isPalindrome(head));
    }
}
