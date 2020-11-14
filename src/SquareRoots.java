import java.util.ArrayList;
import java.util.List;

public class SquareRoots {

    boolean containsElement(int[] source,int target){
        for (int element: source){
            if(element == target){
                return true;
            }
        }
        return false;
    }

    List<Integer> getSquareRoots(int[] source,int[] target){
        List<Integer> result = new ArrayList<>();
        for (int element : target){
            if(containsElement(source,(int) Math.sqrt(element))){
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char letter = 'd';
        System.out.println('c' > 'b');
        System.out.println(new SquareRoots().getSquareRoots(new int[]{2,5,7,12}, new int[]{4, 25, 12,87,90,144}));
    }
}
