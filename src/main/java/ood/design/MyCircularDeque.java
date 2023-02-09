package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 641. Design Circular Deque
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MyCircularDeque {

    private Node head,tail;
    private int capacity,size;

    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if(size == capacity)
            return false;

        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size == capacity)
            return false;
        Node tailPrev = tail.prev;
        Node newNode = new Node(value);

        tailPrev.next = newNode;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = tailPrev;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0)
            return false;

        Node tempHead = head;
        Node toDelete = head.next;

        tempHead.next = toDelete.next;
        toDelete.next.prev = toDelete.prev;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0)
            return false;
        Node delete = tail.prev;

        delete.prev.next = tail;
        tail.prev = delete.prev;
        size--;
        return true;
    }

    public int getFront() {
        return size == 0 ? -1 : head.next.value;
    }

    public int getRear() {
        return size == 0 ? -1 : tail.prev.value;
    }

    public boolean isEmpty() {
        return size == 0 && size < capacity;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private static class Node{
        public int value;
        public Node next,prev;

        public Node(int v){this.value = v; }
    }

    public static void main(String[] args){
        MyCircularDeque myCircularDeque = new MyCircularDeque(5);
        myCircularDeque.insertFront(5);
        myCircularDeque.insertFront(4);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(2);
        myCircularDeque.insertFront(1);
        System.out.println(
                myCircularDeque.insertFront(1)
        );
    }
}
