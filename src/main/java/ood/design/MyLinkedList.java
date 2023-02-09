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
public class MyLinkedList {

    private Node head;

    private static class Node {
        public int value;
        public Node next;

        public Node(int val){
            this.value = val;
        }
    }
    public MyLinkedList() {
        head = new Node(-1);
    }

    public int get(int index) {
        Node temp = head;
        int p1=0;
        while(p1 != index){
            p1++;
            temp = temp.next;
        }
        return temp.next.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
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
        if (temp.next !=null)
            temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        obj.get(5);
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}
