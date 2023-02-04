package ood.customdatastructures.map;

import lombok.Getter;

public interface CMap<K,V> {
    void put(K key,V value);
    V get(K key);
    void remove(Object key);
}

class CMapImpl<K,V> implements CMap<K,V>{

    transient Node<K,V>[] table;
    private static final int CAPACITY = 100;

    public CMapImpl(){
        table = new Node[CAPACITY];
    }
    @Override
    public void put(K key, V value){
        int index = (key.hashCode() & 0x7fffffff) % CAPACITY;


        if(table[index] == null){
            Node<K,V> node = new Node<>(key,value);
            table[index] = node;
        } else {
            Node<K,V> head = table[index];
            while(head.getNext()!=null)
                head = head.next;
            head.next = new Node<>(key,value);
        }
    }

    @Override
    public V get(K key){
        int index = (key.hashCode() & 0x7fffffff) % CAPACITY;
        Node<K,V> node = table[index];
        return node.value;
    }

    @Override
    public void remove(Object key){

    }

    @Getter
    private static class Node<K,V> {
        private final K key;
        V value;
        private Node<K,V> next;

        public Node(K k,V v){
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }
}

class CMapImplTest{
    public static void main(String[] args){
        CMap<Integer,Integer> map = new CMapImpl<>();
        map.put(1,50);
        System.out.println(
                map.get(1)
        );

        CMap<String,Integer> map2 = new CMapImpl<>();
        map2.put("jivan",50);
        map2.put("jivan1",51);
        map2.put("jivan2",52);

        System.out.println(
                map2.get("jivan")
        );
        System.out.println(
                map2.get("jivan1")
        );
        System.out.println(
                map2.get("jivan2")
        );

    }
}
