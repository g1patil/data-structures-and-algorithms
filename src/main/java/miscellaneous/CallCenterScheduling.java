package miscellaneous;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * An attempt for this (from some article )
 * To operate a call center, at any given day, a min of 3 english speaking, 2 dutch speaking and 1 spanish speaking employee need to be there. (you can have one employee speaking two or more languages)
 * An employee can atmost work for 5 days. For simplicity let's say an employee works for a standard of 8 hrs every day. (not sure if hours were relevant)
 * The call center operates 7 days a week.
 * Given employees and the languages they speak, can you atleast come up with a schedule for the first week ?
 *
 * Employee 1 : English, Dutch
 * Employee 2 : English, Dutch
 * Employee 3: Spanish, Dutch
 * Employee 4: English, Dutch, Spanish
 * Employee 5: Dutch, Spanish
 * Employee 6: English, Dutch
 * Employee 7: English, Spanish
 *
 * */
public class CallCenterScheduling {

    static class Employee{
        public int id;
        public int worked;
        Set<String> languages;

        public Employee(int i , int d,Set<String> set){
            this.id = i;this.worked = d;this.languages = set;
        }

        @Override
        public String toString(){
            return "Employee{"+
                    "id="+id+
                    '}';
        }
    }

    static class DaySchedule{
        public HashSet<Employee> english,spanish,dutch,employees;
        public DaySchedule(
                HashSet<Employee> e,
                HashSet<Employee> s,
                HashSet<Employee> d
                ){
            this.english = e;this.spanish=s;this.dutch=d;
            employees = new HashSet<>();
        }

        @Override
        public String toString(){
            return "DaySchedule{"+
                    "employees="+employees+
                    '}';
        }
    }

    public static void main(String[] args){

        List<Employee> employees = Arrays.asList(
                new Employee(1, 0,Set.of("English", "Dutch")),
                new Employee(2,0,Set.of("English", "Dutch")),
                new Employee(3,0,Set.of("Spanish", "Dutch")),
                new Employee(4,0,Set.of("English", "Dutch", "Spanish")),
                new Employee(5, 0,Set.of("Dutch", "Spanish")),
                new Employee(6, 0,Set.of("English", "Dutch")),
                new Employee(7, 0,Set.of("English", "Dutch"))
        );

        DaySchedule[] schedule = new DaySchedule[7];

        for(int i = 0; i < schedule.length; i++) {

            for(Employee employee : employees){
                if(employee.worked == 5)
                    continue;

                if(schedule[i] == null)
                    schedule[i] = new DaySchedule(new HashSet<>(),new HashSet<>(),new HashSet<>());

                DaySchedule d = schedule[i];
                if(d.english.size() < 3 && employee.languages.contains("English")){
                    d.employees.add(employee);
                    addEmployeeEoDay(employee,d);
                    employee.worked++;
                } else if(d.dutch.size() < 2 && employee.languages.contains("Dutch")){
                    d.employees.add(employee);
                    addEmployeeEoDay(employee,d);
                    employee.worked++;
                }else if(d.spanish.size() < 1 && employee.languages.contains("Spanish")){
                    d.employees.add(employee);
                    addEmployeeEoDay(employee,d);
                    employee.worked++;
                }
            }
        }

        for(int i = 0; i < schedule.length; i++) System.out.println(schedule[i]);
    }

    private static void addEmployeeEoDay(Employee employee, DaySchedule d){
        employee.languages.stream().forEach(
                l-> {
                    if(l.equals("English")){
                        d.english.add(employee);
                    }
                    if(l.equals("Dutch")){
                        d.dutch.add(employee);
                    }
                    if(l.equals("Spanish")){
                        d.spanish.add(employee);
                    }
                }
        );
    }
}
