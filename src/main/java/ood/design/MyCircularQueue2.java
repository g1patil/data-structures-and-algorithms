package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 622. Design Circular Queue
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MyCircularQueue2 {

    private Node head;
    private int size,capacity;

    public MyCircularQueue2(int k) {
        head = new Node(-1);
        this.capacity = k;
        this.size = 0;

        head.next = head;
        head.prev = head;
    }

    public boolean enQueue(int value) {
        if(size == capacity)
            return false;

        Node last = head.prev;
        Node newNode = new Node(value);

        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;

        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0)
            return false;

        Node delete = head.next;
        head.next = delete.next;
        delete.next.prev = head;
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : head.next.value;
    }

    public int Rear() {
        return size == 0 ? -1 : head.prev.value;
    }

    public boolean isEmpty() {
        return size == 0;
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
        MyCircularQueue2 deque = new MyCircularQueue2(3);
        deque.enQueue(1);
        deque.enQueue(2);
        deque.enQueue(3);
    }
}
