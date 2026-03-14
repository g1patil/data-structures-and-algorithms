package miscellaneous.jobscheduler;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;
    private final SortedMap<Integer, String> ring = new TreeMap<>();

    public ConsistentHash(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
        hashFunction = Hashing.md5();
    }

    public void addWorker(String worker) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int replicaKey = hashFunction.hashUnencodedChars(worker + i).asInt();
            ring.put(replicaKey, worker);
        }
    }

    public void removeWorker(String worker) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int replicaKey = hashFunction.hashUnencodedChars(worker + i).asInt();
            ring.remove(replicaKey);
        }
    }

    public String getWorker(String key) {
        int keyHash = hashFunction.hashUnencodedChars(key).asInt();
        if (!ring.containsKey(keyHash)) {
            SortedMap<Integer, String> tailMap = ring.tailMap(keyHash);
            keyHash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();
        }
        return ring.get(keyHash);
    }

    public static void main(String[] args){

        ConsistentHash h = new ConsistentHash(5);
        h.addWorker("worker1");
        h.addWorker("worker2");
        h.addWorker("worker3");
        h.addWorker("worker4");
        h.addWorker("worker5");

        String worker_s1 = h.getWorker("jivan");
        String worker_s2 = h.getWorker("jivan");
        String worker_s3 = h.getWorker("jivan");
        String worker_s4 = h.getWorker("jivan");
        String worker_s5 = h.getWorker("jivan");

        System.out.println(worker_s1);
        System.out.println(worker_s2);
        System.out.println(worker_s3);
        System.out.println(worker_s4);
        System.out.println(worker_s5);

    }
}


