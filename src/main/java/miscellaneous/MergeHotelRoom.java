package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MergeHotelRoom {

    public List<int[]> mergeHotelRooms(List<int[]> rooms){
        rooms.sort((a,b)->a[0]-b[0]);
        Map<Integer, LinkedList<int[]>> map = new HashMap<>();

        for(int[] room : rooms){
            int start = room[0];
            int end = room[1];

            if(map.containsKey(start-1)){
                int[] lastRoom = map.get(start-1).pollLast();
                if(map.get(start-1).isEmpty()) map.remove(start-1);

                map.putIfAbsent(end,new LinkedList<>());
                map.get(end).addLast(new int[]{ lastRoom[0] , end });
            } else {
                map.putIfAbsent(end,new LinkedList<>());
                map.get(end).addLast(room);
            }
        }

        List<int[]> result = new ArrayList<>();

        for(int roomId : map.keySet()){
            LinkedList<int[]> intervals = map.get(roomId);

            while(!intervals.isEmpty()){
                result.add(intervals.pollFirst());
            }
        }

        return result;
    }

    @Test
    public void test(){
        int[][] arr={{1,5}, {14, 17}, {6,9}, {10,13}, {4,7}, {8,12}};
        mergeHotelRooms(
                Arrays.asList(arr)
        ).stream().forEach(i-> System.out.println("[" +i[0]+ "," +i[1]+"]"));
    }
}
