package miscellaneous;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

interface HistoricKV {
    int get(int k , int time);
    void put(int k , int v, int time);
}
public class HistoricKVImpl implements HistoricKV{

    Map<Integer,Node> map = new HashMap<>();

    @Override
    public int get(int k, int time){
        Node n = map.get(k);
        int timeResult = 0;
        for( Map.Entry<Integer,Integer> entry : n.history.entrySet()){
            if(entry.getKey() <= time){
                timeResult = entry.getKey();
            }
        }

        return n.history.get(timeResult);
    }

    @Override
    public void put(int k, int v ,int time){
        if(map.containsKey(k)){
            Node node = map.get(k);
            node.history.put(time,v);
        } else {
            Node n = new Node(k);
            n.history.put(time,v);
            map.put(k,n);
        }
    }

    private static class Node {
        public int key;
        public LinkedHashMap<Integer,Integer> history;

        public Node(int key){
            this.key = key;
            history = new LinkedHashMap<>();
        }
    }

    public static void main(String[] args){
        HistoricKVImpl map = new HistoricKVImpl();
        map.put(1,1,0);
        map.put(1,10,7);
        map.put(1,15,12);

        System.out.println(
                map.get(1,12)
        );
    }
}
