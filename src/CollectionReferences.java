import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionReferences {


    public static void main(String[] args) {


        Map<String ,String> map = new HashMap<>();
        map.put("key","value");
        map.remove("key");
        String someValue = map.get("key");
        boolean flag1 = map.containsKey("key");
        boolean flag2 = map.containsKey("value");

        //TODO add for all the collections
    }
}
