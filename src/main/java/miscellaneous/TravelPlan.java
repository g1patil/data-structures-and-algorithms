package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {

    @Test
    public void test(){
        Flight f1 = new Flight("a","b",2);
        Flight f2 = new Flight("b","c",1);
        Flight f3 = new Flight("c","d",0);
        Flight f4 = new Flight("b","d",1);
        Flight f5 = new Flight("d","a",2);

        List<Flight> flights = List.of(f1,f2,f3,f4,f5);
        System.out.println(
                getTravelPlan(flights,"a",5)
        );
    }

    private List<String> result = new ArrayList<>();

    private List<String> getTravelPlan(List<Flight> flights, String source, int budget){
        Map<String,List<Flight>> map = buildMap(flights);
        getTravelPlanHelper(map,source,source,budget,"");
        return result;
    }

    private void getTravelPlanHelper(Map<String, List<Flight>> map, String origin , String current, int budget , String route){

        route = route + ":" + current;

        for(Flight next : map.get(current)){
            if(next.d.equals(origin) && budget - next.price >= 0){
                result.add(route + ":"+origin);
                return;
            }
            if(budget - next.price > 0)
                getTravelPlanHelper(map,origin , next.d , budget - next.price, route);
        }
    }

    private Map<String, List<Flight>> buildMap(List<Flight> flights){
        Map<String,List<Flight>> map = new HashMap<>();
        flights.stream().forEach(
                f->{
                    map.putIfAbsent(f.s,new ArrayList<>());
                    map.get(f.s).add(f);
                }
        );
        return map;
    }

    private static class Flight{
        public String s;
        public String d;
        public int price;

        public Flight(String _s,String _d,int _price){
            this.s = _s;this.d = _d;this.price = _price;
        }
    }
}
