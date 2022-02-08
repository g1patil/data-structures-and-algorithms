package disjointset;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 721. Accounts Merge
 *  TODO WTIP
 */
public class MergeAccounts {

    Map<String,Integer> stringIntegerMap = new HashMap<>();
    List<List<String>> result ;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> names = new HashMap<>();
        int index = 0 ;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> contact = accounts.get(i);
            for (int j = 1; j < contact.size(); j++) {
                if ( stringIntegerMap.containsKey(contact.get(j)) ){
                    mergeTwoList(  contact , j , stringIntegerMap.get(contact.get(j)) );
                    names.put(contact.get(0) , stringIntegerMap.get(contact.get(j)) );
                    continue;
                } else {
                    names.put(contact.get(0) , index);
                    stringIntegerMap.put(contact.get(j), index );
                }
            }
            index++;
        }

        result = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            result.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
            result.get(entry.getValue()).add(entry.getKey());
        }

        for (Map.Entry<String, Integer> entry : names.entrySet()){
            result.get(entry.getValue()).add(0 , entry.getKey());
        }

        result.stream().forEach(l->Collections.sort(l));
        return result.stream().filter(l-> !l.isEmpty()).collect(Collectors.toList());
    }

    public void mergeTwoList(List<String> list , int intersect , int newIndex){
        for (int i = 1; i < intersect; i++) {
            stringIntegerMap.put(list.get(i) , newIndex);
        }
        for (int i = intersect + 1 ; i < list.size(); i++) {
            stringIntegerMap.put(list.get(i) , newIndex);
        }
    }

    @Test
    public void test_(){
        List<String> l1 = new ArrayList<>();
        l1.add("Mary");
        l1.add("1@g");
        l1.add("2@g");
        l1.add("5@g");

        List<String> l2 = new ArrayList<>();
        l2.add("Mary");
        l2.add("6@g");
        l2.add("7@g");
        l2.add("1@g");

        List<String> l3 = new ArrayList<>();
        l3.add("John");
        l3.add("3@g");
        l3.add("4@g");
        l3.add("9@g");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(accountsMerge(list));
    }
}
