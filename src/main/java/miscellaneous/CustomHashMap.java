package miscellaneous;

public class CustomHashMap {

    int[] storage = new int[1000000];

    public void put(String key,int value){
        int index = key.hashCode() % 1000;
        storage[index] = value;
    }

    public int get(String key){
        int index = key.hashCode() % 1000;
        return storage[index];
    }

    public static void main(String[] args){
        CustomHashMap map = new CustomHashMap();

        map.put("jivan",123);
        map.put("patil",1234);

        System.out.println(
                map.get("jivan")
        );

        System.out.println(
                map.get("patil")
        );
    }
}
