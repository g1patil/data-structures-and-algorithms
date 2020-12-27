package lists;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
 *
 * Hard
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * */
public class MergeSortedLists {

    List<Integer> mergeTwo(List<Integer> first, List<Integer> second){
        int i =0;int j=0;
        List<Integer> integerList = new ArrayList<>();

        for (int k = 0; k < first.size() + second.size(); k++) {
            while (!first.isEmpty() && !second.isEmpty()){
                if(first.get(i) < second.get(j)){
                    integerList.add(first.get(0));
                    first.remove(0);
                } else {
                    integerList.add(second.get(0));
                    second.remove(0);
                }
            }
        }
        integerList.addAll(first);
        integerList.addAll(second);

        return integerList;
    }

    /**
     * @param listList k sorted lists . K is the size of the listList
     * @return sorted one list of all the elements in sorted order
     * */
    private List<Integer> mergeLists(List<List<Integer>> listList){

        if(listList.size()==1){
            return listList.get(0);
        }

        if(listList == null){
            return null;
        }
        List<Integer> integerList = new ArrayList<>(listList.remove(0));

        for (List<Integer> list : listList) {
            integerList = mergeTwo(integerList,list);
        }
        return integerList;
    }

    @Test
    public void test(){
        List<Integer> l1 = new LinkedList<>();
        l1.add(4);
        l1.add(7);
        l1.add(9);

        List<Integer> l2 = new LinkedList<>();
        l2.add(1);
        l2.add(6);
        l2.add(10);

        List<Integer> mergedList = mergeLists(List.of(l1,l2));
        Assert.assertEquals(l1.size() + l2.size() , mergedList.size());
    }

    @Test
    public void test1(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(7);
        l1.add(9);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(6);
        l2.add(10);

        List<Integer> mergedList = mergeTwo(l1,l2);
    }

    @Test
    public void test2(){

        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(7);
        l1.add(9);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(6);
        l2.add(10);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(5);
        l3.add(8);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        Assert.assertEquals(l1.size()+l2.size()+l3.size(),mergeLists(lists).size());
    }

}
