package ood.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * My impl of the custom hash set.
 * The internal data structure is array of size 500.
 * Each value in the array is of type Node (linked list).
 * We calculate custom index, based on hash.
 * If no hash collision, then complexity is O(1),
 * collision -> linked list -> O(n)
 * */
public class MyHashSet {

    private Node[] nodes;

    public MyHashSet() {
        nodes = new Node[501];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(-1);
        }
    }

    public void add(int key) {
        if(contains(key))
            return;
        int index = getHashIndex(key);
        Node temp = nodes[index];

        while( temp.next != null)
            temp = temp.next;
        temp.next = new Node(key);
    }

    private int getHashIndex(int val){
        return Math.abs(Integer.hashCode(val)) % 1000;
    }

    public void remove(int key) {
        if(!contains(key))
            return;
        Node temp = nodes[key];
        while(temp.next.value != key){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public boolean contains(int key) {
        Node temp = nodes[key];
        while(temp != null){
            if(temp.value == key){
                return true;
            } else temp = temp.next;
        }
        return false;
    }

    private static class Node{
        public int value;
        public Node next;

        public Node(int v){
            this.value = v;
        }
    }

    @Test
    public void test(){
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertTrue(set.contains(1));
        Assertions.assertTrue(set.contains(2));
        Assertions.assertTrue(set.contains(3));

        set.remove(1);
        set.remove(2);

        Assertions.assertFalse(set.contains(1));
        Assertions.assertFalse(set.contains(2));
        Assertions.assertTrue(set.contains(3));


    }
}
