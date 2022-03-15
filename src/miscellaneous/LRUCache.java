package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author g1patil
 * 146. LRU Cache
 */
@Quality(value = Stage.TESTED)
@Platform(Site.LEETCODE)
public class LRUCache {

    int size , capacity;
    Map<Integer,Node> cache;
    Node head , tail ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.pre = head;
    }

    public void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            delete(node);
            addToHead(node);
        } else {
            Node node = new Node(key,value);
            cache.put(key , node);

            if(size < capacity){
                size++;
                addToHead(node);
            } else {
                cache.remove(tail.pre.key);
                delete(tail.pre);
                addToHead(node);
            }
        }
    }

    private class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

}

