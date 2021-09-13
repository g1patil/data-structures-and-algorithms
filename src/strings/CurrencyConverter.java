package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CurrencyConverter {
    List<String> currencyList = new ArrayList<>();
    {
        String input = "USD/INR,GBP/RND,JPY/YAN,QWE/RTY,GBP/INR,UYT/TYU,POI/OOP,YAN/BYJ";
        for (String s : input.split(",")) {
            currencyList.add(s);
        }
    }

    public boolean contains(final String s , final  String d){
        if ( currencyList.contains( s + "/" + d ) || currencyList.contains( d + "/" + s )){
            return true;
        }
        return false;
    }
    private boolean canConvert(final String source, final String target){
        if ( contains(source , target)){
            return true;
        }
        HashSet<String> visited = new HashSet<>();
        return canConvert(source , target , visited);

    }

    private boolean canConvert(String source, String target, HashSet<String> visited) {
        if ( contains(source , target)){
            return true;
        }

        for (String s : currencyList.stream().filter(s -> s.contains(source)).collect(Collectors.toList())) {
            String newCurrency = s.replace(source,"").replace("/","");
            if (visited.contains(newCurrency)){
                return false;
            }
            visited.add( newCurrency );
            if( canConvert( newCurrency , target , visited)){
                System.out.println(newCurrency);
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        Assert.assertTrue(this.canConvert("USD","INR"));
    }

    @Test
    public void testTwo(){
//        Assert.assertTrue(this.canConvert("USD","GBP"));
//        Assert.assertTrue(this.canConvert("GBP","USD"));
        Assert.assertTrue(this.canConvert("USD","RND"));
    }
}
