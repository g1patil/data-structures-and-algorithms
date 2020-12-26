package miscellaneous;

import java.util.HashMap;
import java.util.Map;
/**
 * Some example around equals and hashcode interview questions.
 * By default the equals() method checks the equivalence relationship between the objects.
 * That means that it checks if the two objects point to same reference or not.
 * 
 * public boolean equals(Object obj) {
        return (this == obj);
    } 
 * 
 * If we create two objects with exact same properties, but using new keyword then above code will return false.
 * Since they are pointing to different locations in the memory.
 * 
 * Now consider the case where we want to make sure that objects having all the properties same, should be equal. Their comparison should result in true.
 * For this we have to override the equals() method. This way we can give our own implementation.
 * 
 * Special case: Its generally recommended that we override equals and hashcode() both method.
 * The reason is HashTable uses the hascode for getting and adding the object. And the their is contract between ewqulas and hashcode.
 *  For two equal objects, they have to return the same hashcode. Since if we fgive our own ummpemettion of the equals , mening that if we overirde the equals 
 * method thetn we have to overrisr the hashocde method as well so that we don;t break the contract. Whis means it rerurns the same results.
 *  If we don;t then hashtable will gilve the inconsidtent behaviuos
 * 
 * 
*/
public class EqualsAnsHashCode {
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.setId(1);
        n1.setName("first");
        
        Node n2 = new Node();
        n2.setId(1);
        n2.setName("first");

        Map<Node,Integer> map = new HashMap<>();
        
        map.put(n1, 1);
        map.put(n2, 10);

        /*Here this is wrong. This is returning 2, but it should be one only.*/
        System.out.println(map.size());

    }
}
