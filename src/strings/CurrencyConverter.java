package strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CurrencyConverter {
    List<String> currencyList = new ArrayList<>();
    {
        String input = "USD/INR,GBP/RND,JPY/YAN,QWE/RTY,GBP/INR,UYT/TYU,POI/OOP,YAN/BYJ";
        for (String s : input.split(",")) {
            currencyList.add(s);
        }
    }

    private boolean canConvert(final String source, final String target, final String oldSource){
        List<String> conversions = getConvertedCurrency(source , oldSource) ;
        if(conversions.get(0).equals(target)){
            return true;
        }

        for (String conversion : conversions) {
            return canConvert( conversion , target , oldSource );
        }
        return false;
    }
    private List<String> getConvertedCurrency(final String source, final String except){
        List<String> conversion = currencyList.stream()
               .filter( s-> s.contains(source) && !s.contains(except)  ).collect(Collectors.toList());
        for (String s :
             conversion) {
            s.replace(source , "");
        }
        conversion.stream().forEach(s-> s.replace("/", ""));
        return conversion;

    }

    @Test
    public void test(){
        Assert.assertTrue(this.canConvert("USD","INR", " "));
    }

    @Test
    public void testTwo(){
        Assert.assertTrue(this.canConvert("USD","GBP", " "));
        Assert.assertTrue(this.canConvert("GBP","USD", " "));
    }
}
