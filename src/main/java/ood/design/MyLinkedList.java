package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 707. Design Linked List
 * */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class MyLinkedList {

    private Node head;
    private int size;

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
        if (index<0)
            return -1;
        Node temp = head;
        int p1=0;
        while(p1 != index){
            p1++;
            temp = temp.next;
        }
        return temp == null || temp.next == null ? -1 : temp.next.value;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0)
            return;
        Node temp = head;
        Node node = new Node(val);
        if (size == index){
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
            size++;
        } else {
            int p1=0;
            while(p1!=index){
                p1++;
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index>=size)
            return;
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
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        obj.get(1);
        obj.deleteAtIndex(1);
        obj.get(1);
        obj.get(3);
        obj.deleteAtIndex(3);
        obj.deleteAtIndex(0);
        obj.get(0);
        obj.deleteAtIndex(0);
        obj.get(0);
    }
}
