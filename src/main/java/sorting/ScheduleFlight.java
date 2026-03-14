package sorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleFlight {

    private static final int delay = 10;
    public List<Schedule> sortScheule(List<Schedule> scheduleList){
        scheduleList.sort(Comparator.comparing(o -> o.time));

        for(int i = 1; i < scheduleList.size(); i++ ) {
            Schedule previous = scheduleList.get(i-1);
            Schedule current = scheduleList.get(i);

            if(current.time.equals(previous.time) || current.time.isBefore(previous.time)){
               int diff = previous.time.getMinute() - current.time.getMinute() ;
                adjustTime(current, diff + delay);
            }
        }
        return scheduleList;
    }

    private void adjustTime(Schedule s2,int delay){
        s2.time = s2.time.plusMinutes(delay);
    }

    public static void main(String[] args){

        Schedule s0 = new Schedule("1",LocalTime.of(05,10),100);
        Schedule s1 = new Schedule("1",LocalTime.of(05,10),100);
        Schedule s2 = new Schedule("2",LocalTime.of(04,10),100);
        Schedule s3 = new Schedule("3",LocalTime.of(03,10),100);
        Schedule s4 = new Schedule("4",LocalTime.of(03,10),100);
        Schedule s5 = new Schedule("5",LocalTime.of(03,10),100);
        Schedule s6 = new Schedule("6",LocalTime.of(03,10),100);
        Schedule s7 = new Schedule("7",LocalTime.of(03,10),100);

        List<Schedule> li = new ArrayList<>();
        li.add(s0);
        li.add(s1);
        li.add(s2);
        li.add(s3);
        li.add(s4);
        li.add(s5);
        li.add(s6);
        li.add(s7);


        new ScheduleFlight().sortScheule(li).forEach(System.out::println);


    }
    private static class Schedule{
        public String name;
        public LocalTime time;
        public int passengers;

        public Schedule(String n , LocalTime t , int p){
            this.name = n;
            this.time = t;
            this.passengers = p;
        }

        @Override
        public String toString(){
            return "Schedule{"+
                    "name='"+name+'\''+
                    ", time="+time+
                    ", passengers="+passengers+
                    '}';
        }
    }
}


