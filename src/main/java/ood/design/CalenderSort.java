package ood.design;

import java.util.Map;
import java.util.TreeMap;

public class CalenderSort {

    private final Map<Calendar,Integer> db;

    public CalenderSort(){
        this.db = new TreeMap<>((a,b)->{
            if(b.end != a.end){
                return a.end - b.end;
            } else if( b.start != a.start){
                return a.start - b.start;
            } else return a.name.compareTo(b.name);
        });
    }

    public void addTime(Calendar calendar){
        db.put(calendar,0);
    }

    private static class Calendar{
        public int start,end;
        public String name;

        public Calendar(int s, int e, String n){
            this.start = s;this.end=e;this.name=n;
        }

        @Override
        public String toString(){
            return "\nCalendar{"+
                    "start="+start+
                    ", end="+end+
                    ", name='"+name+'\''+
                    '}';
        }
    }

    public static void main(String[] args){
        CalenderSort sort = new CalenderSort();

        sort.addTime(new Calendar(1, 5, "a"));
        sort.addTime(new Calendar(2, 3, "b"));
        sort.addTime(new Calendar(1, 5, "c"));
        sort.addTime(new Calendar(1, 4, "d"));
        sort.addTime(new Calendar(1, 6, "e"));
        sort.addTime(new Calendar(3, 4, "f"));
        sort.addTime(new Calendar(2, 5, "g"));
        sort.addTime(new Calendar(1, 5, "h"));
        sort.addTime(new Calendar(2, 4, "i"));
        sort.addTime(new Calendar(3, 5, "j"));
        System.out.println(sort.db);
    }
}
