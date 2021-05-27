package files;
import org.junit.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jivanpatil
 * This algorithm is used to find the pair of two itels from the given list.
 * The input is given in the txt file. The file contains the comma separated values.
 * Each line contains the product namd and product price.
 *
 * The two product are pairs if thier sum is less than equal to the target sum.
 * */
public class FindPairs {
    /***
     * @param fileName name of the file that contains the pairs.
     *                 Function prints the value of the pairs.
     * @param targetSum target sum
     */
    void findPairs(final String fileName,final Double targetSum) {
        Map<String , Double> productsMap = new HashMap<>();

        try {
            FileInputStream fis=new FileInputStream(fileName);
            Scanner sc=new Scanner(fis);

            while (sc.hasNextLine()) {
                String[] keyValue = sc.nextLine().split(",");
                String name = keyValue[0];
                Double value = Double.parseDouble(keyValue[1]);

                productsMap.put(name,value);
                printPairs(productsMap,targetSum,value,name);
            }

        } catch (Exception e){
            System.out.println("There was error. Message " + e.getMessage());
        }
    }

    void printPairs(final Map<String, Double> products,
                    final Double targetSum,
                    final Double currentProductPrice,
                    final String currentProductName){
        products.keySet().forEach(k->{
            if(products.get(k) + currentProductPrice <= targetSum && k!=currentProductName ){
                System.out.println( k + " " + currentProductName);
            }
        });
    }

    @Test
    public void test(){
        findPairs("src/files/InputFindPairs.txt", (double) 500);
    }

    @Test
    public void invalid(){
        findPairs("src/files/InvalidInputs.txt", (double) 50);
    }
}
