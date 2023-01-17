package miscellaneous;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
 * The reason is HashTable uses the hashcode for getting and adding the object. And the their is contract between equals and hashcode.
 *  For two equal objects, they have to return the same hashcode. Since if we have our own ummpemettion of the equals , meaning that if we override the equals
 * method thetn we have to override the hashcode method as well so that we don;t break the contract. Which means it return the same results.
 *  If we don;t then hashtable will give the inconsistent behaviour
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

        Map<EqualsAnsHashCodeNode,Integer> integerHashMap = new HashMap<>();

        integerHashMap.put(new EqualsAnsHashCodeNode(10),10);
        integerHashMap.put(new EqualsAnsHashCodeNode(10),10);

        //Following is correct since we are overriding the equals and hashcode method.
        Assertions.assertEquals(1,integerHashMap.size());
    }

}

class EqualsAnsHashCodeNode{
    private int data;
    public EqualsAnsHashCodeNode(final int data){ this.data = data; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsAnsHashCodeNode that = (EqualsAnsHashCodeNode) o;
        return data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
