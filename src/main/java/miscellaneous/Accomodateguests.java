package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * given a list of hotel roomand number ofguests
 * find Combaination that can accomodate number of guests at lowest price
 * */
public class Accomodateguests {

    @Test
    public void test(){
        Room r1 = new Room(1,50,1);
        Room r2 = new Room(2,80,2);
        Room r3 = new Room(3,100,3);
        Room r4 = new Room(4,30,1);

        List<Room> roomList = new ArrayList<>();
        roomList.add(r1);
        roomList.add(r2);
        roomList.add(r3);
        roomList.add(r4);

        System.out.println(
                accomodateGuests(roomList,4)
        );
    }

    private List<Room> accomodateGuests(List<Room> roomList, int i){
        Queue<Room> roomQueue = new PriorityQueue<>(Comparator.comparing(o->o.price/o.guests));
        roomQueue.addAll(roomList);
        List<Room> result = new ArrayList<>();
        int price = 0;

        int remaining = i;

        while(!roomQueue.isEmpty() && remaining > 0){
            Room room = roomQueue.poll();
            remaining-=room.guests;
            price+=room.price;
            result.add(room);
        }

        return result;
    }

    private static class Room{
        public int id;
        public int price;
        public int guests;

        public Room(int i,int p,int g){
            this.id = i;this.price = p;this.guests = g;
        }

        @Override
        public String toString(){
            return "Room{"+
                    "id="+id+
                    ", price="+price+
                    ", guests="+guests+
                    '}';
        }
    }
}
