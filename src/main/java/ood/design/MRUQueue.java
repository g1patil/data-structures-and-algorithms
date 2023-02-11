package ood.design;

import java.util.LinkedList;
import java.util.stream.Stream;

public class MRUQueue {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public MRUQueue(int n) {
        Stream.iterate(1, i -> i + 1).limit(n).forEach(e->linkedList.add(e));
    }

    public int fetch(int k) {
        int value = linkedList.remove(k-1);
        linkedList.addLast(value);
        return value;
    }

    public static void main(String[] args){
        MRUQueue queue = new MRUQueue(8);
        System.out.println(queue.fetch(3));
        System.out.println(queue.fetch(5));
        System.out.println(queue.fetch(2));
        System.out.println(queue.fetch(8));
    }
}
