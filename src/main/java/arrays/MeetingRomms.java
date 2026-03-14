package arrays;

import java.util.ArrayList;
import java.util.List;

/***
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1: Input: [[0, 30],[5, 10],[15, 20]] Output: 2
 * 
 * Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: 1
 * 
 * 
 */
public class MeetingRomms {


    boolean isIntersection(Integer[] one,Integer[] two){
        if(one[0]<two[0]){
            if ((one[0] < two[0] && two[0] < one[1])){
                return true;
            }
        }
        
        if (two[0]< one[0]){
            if ((two[0] < one[0] && one[0] < two[1])){
                return true;
            }
        }
        return false;
    }
    boolean canAccomodate(Room room, Integer[] interval){
        boolean answer = false;
        for(Integer[] roomInterval : room.intervals){

            if(isIntersection(roomInterval, interval)){
                return false;
            } else {
                answer = true;
            }

        }
 
        return answer;
    }

    int createRooms(Integer[][] intervals){
        List<Room> rooms = new ArrayList<>();
        Room room = new Room();
        room.intervals.add(intervals[0]);
        rooms.add(room);
        
        for(int index = 1; index < intervals.length; index ++){
            boolean canAccomodate = false;
            Room roomWhichCanAccomodate = null;

            for(Room roomElement : rooms){
                canAccomodate = canAccomodate(roomElement, intervals[index]);
                if(canAccomodate){
                    roomWhichCanAccomodate = roomElement;
                   break;     
                }
            }
            if(canAccomodate){
                roomWhichCanAccomodate.intervals.add(intervals[index]);
            }

            if(!canAccomodate){
                Room newRoom = new Room();
                newRoom.intervals.add(intervals[index]);
                rooms.add(newRoom);  
            }
        }
        return rooms.size();

    }


    public static void main(String[] args) {
        Integer[][] rooms = {{2,10},{3,5},{5,15},{12,17},{20,25},{3,6},{3,7}};


        System.out.println(new MeetingRomms().createRooms(rooms));
    }
    
}

class Room{
    List<Integer[]> intervals = new ArrayList<>();
}