package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author g1patil
 * 146. LRU Cache
 */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class LRUCache {

    private Map<Integer,Node> map = new HashMap<>();
    private Node head,tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node =  map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    private void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            deleteNode(map.get(key));
            addToHead(map.get(key));
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            if(size < capacity){
                size++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                addToHead(node);
                deleteNode(tail.prev);
            }

        }
    }

    private class Node {
        public int key;
        public int value;

        public Node next;
        public Node prev;

        public Node(int k , int v){
            this.key = k;
            this.value = v;
        }
    }

}

