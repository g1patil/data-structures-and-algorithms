package ood.customdatastructures.queue;

import lombok.Data;

public class CustomQueueImpl<T> implements CustomQueue<T> {

    private QNode head;
    private QNode tail;
    private int size;

    public CustomQueueImpl(){
        head = null;
        tail = null;
    }

    @Override
    public T peek(){
        return (T) head.getVal();
    }

    @Override
    public T poll(){
        QNode<T> tempHead = head;
        head = head.next;
        tempHead.next = null;
        size--;
        return tempHead.getVal();
    }

    @Override
    public boolean add(T tval){
        QNode<Integer> node = new QNode(tval);
        if(head == null)
            head = node;
        if(tail == null){
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean isEmpty(){
        return size == 0 ;
    }
}

@Data
class QNode<T> {
    QNode next;
    T val;

    public QNode(T val){
        this.next = null;
        this.val = val;
    }
}