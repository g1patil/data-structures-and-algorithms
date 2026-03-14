package miscellaneous;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Sort socks based on property.
 * This is initial version.
 * v1.0.0
 * */

public class PairingSocksFromPile {

    public Map<String, Set<Sock>> sortSock(List<Sock> sockList){
        Map<String,Set<Sock>> result = new HashMap<>();

        sockList.stream().forEach( sock -> {
            String key = sock.generateKey();
            result.putIfAbsent(key,new HashSet<>());
            result.get(key).add(sock);
        });
        return result;
    }

    @Test
    public void test(){
        List<Sock> sockList = new ArrayList<>();

        sockList.add(new Sock("red","pat_1","left"));
        sockList.add(new Sock("blue","pat_1","right"));
        sockList.add(new Sock("red","pat_2","left"));
        sockList.add(new Sock("red","pat_2","right"));
        sockList.add(new Sock("blue","pat_1","left"));
        sockList.add(new Sock("red","pat_1","right"));

        var result = sortSock(sockList);
        result.forEach((k,v)->{
            Assertions.assertEquals(2, v.size());
        });
        Assertions.assertEquals(3,result.size());
    }

}

@Data
@AllArgsConstructor
class Sock{
    private String color;
    private String pattern;
    private String leg;

    public String generateKey(){
        return color+"_"+pattern;
    }
}
