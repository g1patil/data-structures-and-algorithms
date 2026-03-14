import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortedLists {

    public LinkedList<Integer> mergeLists(LinkedList<Integer> first,LinkedList<Integer> second){
        LinkedList<Integer> merged = new LinkedList<>();


        int bigger = first.size() + second.size();


        for (int index = 1;index<=bigger;index++){
            if (!first.isEmpty() || !second.isEmpty()){
                int firstElement = first.getFirst();
                int secondElement = second.getFirst();

                if (firstElement<secondElement){
                    merged.add(firstElement);
                    first.removeFirst();
                } else {
                    merged.add(secondElement);
                    second.removeFirst();
                }
            }
            if(first.isEmpty()){
                merged.addAll(second);
                break;
            }
            if(second.isEmpty()){
                merged.addAll(first);
                break;
            }
        }

        return merged;

    }

    public List<Integer> sortedLists(LinkedList<LinkedList<Integer>> lists){
        LinkedList<Integer> result = lists.getFirst();
        lists.removeFirst();

        for(LinkedList<Integer> list : lists){
            result = mergeLists(result,list);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();

        LinkedList<Integer> l1 = new LinkedList<>(Arrays.asList(3, 7, 55));
        LinkedList<Integer> l2 = new LinkedList<>(Arrays.asList(1, 4, 19));
        LinkedList<Integer> l3 = new LinkedList<>(Arrays.asList(2, 9, 20));

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        SortedLists sortedLists = new SortedLists();
        System.out.println(sortedLists.sortedLists(lists));
    }
}
