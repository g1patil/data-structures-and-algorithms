package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Longest itinery
 * */
public class LongestItinerary {

    Set<String> set;
    Map<String, TreeSet<Flight>> flights;
    Map<String,Integer> hotelPrice;


    private void buildMap(){
        this.hotelPrice = new HashMap<>();

        hotelPrice.put("AMS",100);
        hotelPrice.put("LON",200);
        hotelPrice.put("PAR",300);

        this.flights = new HashMap<>();

        flights.put("AMS",new TreeSet<>());
        flights.put("LON",new TreeSet<>());
        flights.put("PAR",new TreeSet<>());

        flights.get("AMS").add(new Flight(10,300,"AMS","PAR"));
        flights.get("LON").add(new Flight(15,410,"LON","PAR"));
        flights.get("PAR").add(new Flight(13,300,"PAR","LON"));
        flights.get("LON").add(new Flight(17,400,"LON","AMS"));

        this.set = new HashSet();

        set.add("AMS");
        set.add("LON");
        set.add("PAR");
    }

    private List<String> getItinery(){
        buildMap();
        this.set.stream().forEach(
                city -> {
                    getItineryHelper(city, flights.get(city).first().date,"",5000);
                }
        );
        return null;
    }

    private void getItineryHelper(String city, int today,String result , int balance){

        for(Flight nextFlight : flights.get(city)){

            int hotelCharges = getHotelCharges(city,today,nextFlight.date);
            int possibleExpenses = hotelCharges + nextFlight.price;
            if(balance-possibleExpenses >= 0 && today <= nextFlight.date){
                if(hotelCharges > 0)
                    result+= " hotel stay  in "+ city +" -> ";
                result+= " flight date :"+ nextFlight.date + " "+ city + " -> " + nextFlight.dest ;
                getItineryHelper(nextFlight.dest,nextFlight.date,  result,balance-possibleExpenses);
            }
        }
        System.out.println(result);
    }

    private int getHotelCharges(String city,int date, int date1){
        return (date1-date) * hotelPrice.get(city);
    }

    private static class Flight implements Comparable<Flight>{
        public String source,dest;
        public int date;
        public int price;

        public Flight(int d, int p,String s,String dest){
            this.date = d;
            this.price = p;
            this.source = s;this.dest =dest;
        }

        @Override
        public int compareTo(Flight o){
            return this.date - o.date;
        }
    }

    @Test
    public void test(){
        System.out.println(
                getItinery()
        );
    }
}
