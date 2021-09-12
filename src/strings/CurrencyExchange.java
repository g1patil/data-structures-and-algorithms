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
 *
 * Algorithm : The algorithm is to split the related currencies in groups.
 * The check for each group, if particular group contains both from and to currencies or not.
 * */
public class CurrencyExchange {

    Map<String,String> currencyMap = new HashMap<>();
    List<Set<String>> setArrayList = new ArrayList<>();
     {
        String input = "USD/INR,GBP/RND,JPY/YAN,QWE/RTY,GBP/INR,UYT/TYU,POI/OOP,YAN/BYJ,INR/GBP";
        Set<String> stringSet = new HashSet<>();
        String[] inputArray = input.split(",");
        Arrays.sort(inputArray);
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


    private void buildData(){

        String input = "USD/INR,GBP/RND,JPY/YAN,QWE/RTY,GBP/INR,UYT/TYU,POI/OOP,YAN/BYJ,INR/GBP";
        String[] inputArray = input.split(",");

        for (String pair:inputArray) {
            String[] currency = pair.split("/");
            if(!currencyMap.containsKey(currency[0])){
                currencyMap.put(currency[0],currency[1]);
            }
            if(!currencyMap.containsKey(currency[1])){
                currencyMap.put(currency[1],currency[0]);
            }
        }
    }

    private boolean canConverNew(final String s,final String d){

        if(currencyMap.containsKey(s) && currencyMap.get(s).equals(d)){
            return true;
        }

        if(currencyMap.values().contains(s)){
            //currencyMap.ge
        }
        return false;
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
