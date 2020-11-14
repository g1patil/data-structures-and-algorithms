import java.util.*;

public class FindCommonElements {

    public boolean isPresent(Integer[] integers,Integer target){
        for(Integer element : integers){
            if(target.equals(element)){
                return true;
            }
        }
        return false;
    }



    /*
    * Checks is element is present
    * */
    public Set<Integer> getCommonNumbers(Integer[] first,Integer[] second){
        Set<Integer> result = new HashSet<>();
        for(Integer element : first){
            if(isPresent(second,element)){
                result.add(element);
            }
        }
        return result;
    }
    public Set<Integer> commonElements(LinkedList<Integer[]> list){
        Integer[] first = list.getFirst();
        list.removeFirst();
        Set<Integer> result = new HashSet<>();

        list.forEach(element->{
            result.addAll(getCommonNumbers(first,element));
        });
        return result;
    }

    public static void main(String[] args) {
        Integer[] a1= {1,4,8,10,11,15,18,20};
        Integer[] a2= {3,7,34,9,91,4};
        Integer[] a3= {11,13,16,10};

        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        FindCommonElements findCommonElements = new FindCommonElements();
        System.out.println(findCommonElements.commonElements(list));

    }
}
