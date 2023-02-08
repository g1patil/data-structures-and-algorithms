package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 707. Design Linked List
 * */
@Quality(value = Stage.FAILING,details = "8/64")
@Platform(Site.LEETCODE)
public class DesignLinkedList {

    private Node head,tail;

    private static class Node {
        public int value;
        public Node next;

        public Node(int val){
            this.value = val;
        }
    }
    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
    }

    public int get(int index) {
        Node temp = head.next;
        int p1=0;
        while(p1 != index){
            p1++;
            temp = temp.next;
        }
        return temp.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void addAtIndex(int index, int val) {
        int p1=0;
        Node temp = head;
        while(p1!=index){
            p1++;
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteAtIndex(int index) {
        int p1=0;
        Node temp = head;
        while(p1!=index){
            p1++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
}
