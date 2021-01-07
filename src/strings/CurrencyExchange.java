package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Given the string of currencies, check if the conversion of one to other is possible or not.
 *
 * Possible string :  EUR/INR,INR/GBP,GBP/USD etc
 *
 * input fromCurrency, toCurrency
 *
 * return true or false
 * */
public class CurrencyExchange {

    List<Set<String>> setArrayList = new ArrayList<>();
     {
        String input = "USD/INR,INR/GBP,GBP/INR,GBP/RND,JPY/YAN,QWE/RTY,UYT/TYU,POI/OOP,YAN/BYJ";
        Set<String> stringSet = new HashSet<>();
        String[] inputArray = input.split(",");
        setArrayList.add(stringSet);

        for(String string:inputArray){
            String[] currency = string.split("/");

            setArrayList.forEach(set->{
                if(set.contains(currency[0]) || set.contains(currency[1])){
                    set.add(currency[0]);
                    set.add(currency[1]);
                    currency[0] = null;
                }
            });

            if( currency[0] !=null){
                Set<String> someSet = new HashSet<>();
                someSet.add(currency[0]);
                someSet.add(currency[1]);
                setArrayList.add(someSet);
            }

        }

        setArrayList.remove(0);

    }

    /**
    * Takes the two currencies as input and returns true or false if they can be converted from one to other
    * @param from from currency
     * @param to to currency
     * @return true/false
    * */
    private boolean canConvert(final String from, final String to){
        return setArrayList.stream().filter(set -> set.contains(from) && set.contains(to)).count() == 1;
    }

    @Test
    public void test(){
         Assert.assertTrue( canConvert("USD","INR"));
         Assert.assertTrue( canConvert("USD","RND"));
         Assert.assertTrue( canConvert("JPY","BYJ"));
    }

    @Test
    public void test1(){
         Assert.assertFalse( canConvert("USD","YAN"));
    }

    @Test
    public void test2(){
         Assert.assertFalse( canConvert("GBP","POI"));
    }
}
