package lists;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given list of emplyees, pair each emplyee.
 * If the method is called twice, they should not be paired again.
 * */
public class EmployeePair {

    private static final Map<String,Set<String>> pairsMap = new HashMap<>();

    public List<List<String>> makePair(List<String> employeeList){
        Collections.shuffle(employeeList);
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < employeeList.size(); i+=2) {
            String a = employeeList.get(i);
            String b = employeeList.get(i+1);
            if(!alreadyPaired(a,b)){
                addToPairHistory(a,b);
                result.add( List.of(a,b) );
            } else {
                if(pairsMap.get(employeeList.get(0)).size() == employeeList.size() - 1)
                    return result;
                return makePair(employeeList);
            }
        }

        return result;
    }

    private void addToPairHistory(String a , String b){
        pairsMap.putIfAbsent(a,new HashSet<>());
        pairsMap.putIfAbsent(b,new HashSet<>());
        pairsMap.get(a).add(b);
        pairsMap.get(b).add(a);
    }


    private boolean alreadyPaired(String a , String b){
        return pairsMap.getOrDefault(a , Set.of()).contains(b)
                || pairsMap.getOrDefault(b, Set.of()).contains(a);
    }

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");

        for(int i = 0; i < 6; i++) {
            System.out.println(
                    makePair(list)
            );
        }
    }
}
