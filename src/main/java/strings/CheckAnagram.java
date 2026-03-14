import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

    boolean isAnagram(String source,String target){

        Map<Character,Character> map = new HashMap<>();

        for (int index=0; index<source.length();index++){
            map.put(source.charAt(index),'a');
        }

        for (int index=0; index<target.length();index++){
            if(map.containsKey(target.charAt(index))){
                map.remove(target.charAt(index));
            }
        }
      return map.isEmpty();
    };

    public static void main(String[] args) {
        System.out.println(new CheckAnagram().isAnagram("jivan","vanji"));
    }
}
