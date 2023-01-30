package sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortSocks {

    private List<Sock> sortSocks(List<Sock> sockList){
        Map<Sock,int[]> map = new HashMap<>();
        init(map,sockList);

        List<Sock> result = new ArrayList<>(map.keySet());
        result.sort( (o1,o2) ->{
            if(map.get(o1)[0] != map.get(o2)[0])
                return map.get(o1)[0] - map.get(o2)[0];
            return map.get(o1)[1] - map.get(o2)[1];
        });
        return result;
    }

    private void init(Map<Sock,int[]> map,List<Sock> sockList){
        sockList.forEach(
                s ->{
                    map.put(s , new int[2]);
                    map.get(s)[0] = getIndexColor(s.color);
                    map.get(s)[1] = getIndexLeg(s.leg);
                }
        );
    }

    private int getIndexLeg(String leg){
        return leg.equals("left") ? 1 : 0;
    }

    private int getIndexColor(String color){
        return switch(color){
            case "blue" -> 1;
            case "red" -> 2;
            case "yellow" -> 3;
            default -> 10;
        };
    }

    @Test
    public void test(){
        System.out.println(
                sortSocks(
                        List.of(
                                new Sock("yellow","right"),
                                new Sock("blue","right"),
                                new Sock("red","right"),
                                new Sock("blue","left"),
                                new Sock("red","left"),
                                new Sock("blue","right"),
                                new Sock("red","right"),
                                new Sock("blue","left"),
                                new Sock("red","left"),
                                new Sock("yellow","left")

                        )
                )
        );
    }
}

class Sock{
    public String color;
    public String leg;
    public Sock(String c,String l){
        this.color = c;
        this.leg = l;
    }

    @Override
    public String toString(){
        return "Sock{"+
                "color='"+color+'\''+
                ", leg='"+leg+'\''+
                '}';
    }
}
