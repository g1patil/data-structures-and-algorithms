package miscellaneous;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {

    private final int capacity;
    private Map<Integer,Node> map ;
    private Map<Integer,LinkedHashSet<Node>> frequency ;
    private int minFreq = 0 ;
    public LFUCache(int _capacity) {
        this.map = new HashMap<>();
        this.capacity = _capacity;
        this.frequency = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        increamentFrequency(node);
        return node.value;
    }

    private void increamentFrequency(Node node){
        frequency.get(node.frequency).remove(node);

        if(node.frequency == this.minFreq && frequency.get(node.frequency).isEmpty() ){
            minFreq++;
        }
        node.frequency++;
        frequency.putIfAbsent(node.frequency, new LinkedHashSet<>());
        frequency.get(node.frequency).add(node);

    }
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            increamentFrequency(node);
        }
        else {
            if (map.size() == capacity) {
                Node removedNode = frequency.get(this.minFreq).iterator().next();
                frequency.get(this.minFreq).remove(removedNode);
                map.remove(removedNode.key);
            }

            this.minFreq = 1;
            Node node = new Node(key, value, 1);
            map.put(key, node);
            frequency.putIfAbsent(node.frequency, new LinkedHashSet<>());
            frequency.get(node.frequency).add(node);
        }
    }

    private class Node {
        public int key;
        public int value;
        public int frequency;

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }


}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
