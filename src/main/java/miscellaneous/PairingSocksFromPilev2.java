package miscellaneous;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class PairingSocksFromPilev2 {


    public Map<String, Set<Sockv2>> sort(Set<Sockv2> sockv2List){
        Set<String> uniqueProperties = getUniqueProperties(sockv2List);
        Set<String> partitionedProperties = new LinkedHashSet<>();
        Map<String, Set<Sockv2>> result = new HashMap<>();

        Queue<Partition> queue = new PriorityQueue<>();

        uniqueProperties.forEach(
                property -> {
                    partitionedProperties.add(property);
                    if(queue.isEmpty()){
                        distributeBasedOnProperty(queue, sockv2List, partitionedProperties);
                    } else{
                        int size = queue.size();
                        for(int i = 0; i < size && queue.peek().isCanBePartitioned(); i++) {
                            Partition oldPartition = queue.poll();
                            distributeBasedOnProperty(queue, oldPartition.getPartition(), partitionedProperties);
                        }
                    }
                }
        );

        queue.forEach(
                q -> result.put(q.getName(), q.getPartition())
        );

        return result;
    }

    public void distributeBasedOnProperty(Queue<Partition> partitions, Set<Sockv2> unsorted, Set<String> property){

        Map<String, Set<Sockv2>> result = new HashMap<>();
        unsorted.stream().forEach(
                sock -> {
                    String propvalue = sock.buildProperty(property);
                    result.putIfAbsent(propvalue, new HashSet<>());
                    result.get(propvalue).add(sock);
                }
        );
        result.forEach((String k, Set<Sockv2> v) -> {
            partitions.add(new Partition(k, v , !(partitions.size() == v.size())));
        });
    }

    private Set<String> getUniqueProperties(Set<Sockv2> sockv2List){
        return new HashSet<>(sockv2List.stream().findFirst().get().getProperties().keySet());
    }

    @Test
    public void test(){
        Sockv2 s1 = new Sockv2(1L);
        s1.getProperties().put("color", "red");
        s1.getProperties().put("pattern", "simple");
        s1.getProperties().put("type", "regular");
        s1.getProperties().put("leg", "left");

        Sockv2 s2 = new Sockv2(2L);
        s2.getProperties().put("color", "red");
        s2.getProperties().put("pattern", "simple");
        s2.getProperties().put("type", "regular");
        s2.getProperties().put("leg", "right");

        Sockv2 s3 = new Sockv2(2L);
        s3.getProperties().put("color", "blue");
        s3.getProperties().put("pattern", "simple");
        s3.getProperties().put("type", "regular");
        s3.getProperties().put("leg", "left");

        Sockv2 s4 = new Sockv2(2L);
        s4.getProperties().put("color", "blue");
        s4.getProperties().put("pattern", "simple");
        s4.getProperties().put("type", "regular");
        s4.getProperties().put("leg", "right");

        Sockv2 s5 = new Sockv2(2L);
        s5.getProperties().put("color", "blue");
        s5.getProperties().put("pattern", "simple");
        s5.getProperties().put("type", "office");
        s5.getProperties().put("leg", "left");

        Sockv2 s6 = new Sockv2(2L);
        s6.getProperties().put("color", "blue");
        s6.getProperties().put("pattern", "simple");
        s6.getProperties().put("type", "office");
        s6.getProperties().put("leg", "right");

        Set<Sockv2> sockv2List = new HashSet<>();

        sockv2List.add(s4);
        sockv2List.add(s2);
        sockv2List.add(s1);
        sockv2List.add(s5);
        sockv2List.add(s3);
        sockv2List.add(s6);

        System.out.println(
                sort(
                        sockv2List
                )
        );
    }
}

@Data
@AllArgsConstructor
class Partition implements Comparable<Partition> {
    private String name;
    private Set<Sockv2> partition;
    private boolean canBePartitioned = true;

    @Override
    public int compareTo(Partition o){
        return this.name.compareTo(o.getName());
    }
}

@Data
class Sockv2 {
    private Long id;
    private Map<String, String> properties;

    public Sockv2(Long id){
        this.id = id;
        properties = new HashMap<>();
    }

    public String buildProperty(Set<String> properties){
        return properties.stream()
                .map(p -> this.properties.get(p))
                .collect(Collectors.joining());
    }
}