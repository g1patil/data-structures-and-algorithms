package lists;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given list of emplyees, pair each emplyee.
 * If the method is called twice, they should not be paired again.
 */
public class EmployeePair<T> {

    private final Map<Object, Set<Object>> pairsMap = new HashMap<>();

    public List<List<T>> makePair(List<T> employeeList){
        Collections.shuffle(employeeList);
        List<List<T>> result = new ArrayList<>();

        for(int i = 0; i < employeeList.size(); i += 2) {
            T a = employeeList.get(i);
            T b = employeeList.get(i+1);
            if(!alreadyPaired(a, b)){
                addToPairHistory(a, b);
                result.add(List.of(a, b));
            } else{
                if(pairsMap.get(employeeList.get(0)).size() == employeeList.size()-1)
                    return result;
                return makePair(employeeList);
            }
        }

        return result;
    }

    private void addToPairHistory(T a, T b){
        pairsMap.putIfAbsent(a, new HashSet<>());
        pairsMap.putIfAbsent(b, new HashSet<>());
        pairsMap.get(a).add(b);
        pairsMap.get(b).add(a);
    }

    private boolean alreadyPaired(T a, T b){
        return pairsMap.getOrDefault(a, Set.of()).contains(b)
                || pairsMap.getOrDefault(b, Set.of()).contains(a);
    }

    @Test
    public void test(){
        EmployeePair<Integer> employeePair = new EmployeePair<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i = 0; i < 4; i++) {
            System.out.println(
                    employeePair.makePair(list)
            );
        }
    }
}
