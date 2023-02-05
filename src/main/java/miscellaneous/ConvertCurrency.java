package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertCurrency {



    @Test
    public void test(){
        List<Conversion> rates = List.of(
          new Conversion("EUR","GBP",1.5f),
          new Conversion("GBP","USD",1.1f),
          new Conversion("CAD","AED",0.85f)
        );

        System.out.println(
                getConversionRate(rates,"EUR","USD",1000)
        );
    }

    private float getConversionRate(List<Conversion> ratesList,String from, String to, float total){
        Map<String,List<Conversion>> rates = buildConversionMap(ratesList);
        return getConversionRateHelper(rates,from,to,total);
    }

    private float getConversionRateHelper(Map<String, List<Conversion>> rates, String from, String to, float total){
        if(from.equals(to))
            return total;

        for(Conversion c : rates.get(from)){
            float result = getConversionRateHelper(
                    rates, c.to,to, total * c.rate
            );
            if(result != -1)
                return result;
        }
        return -1;
    }

    private Map<String, List<Conversion>> buildConversionMap(List<Conversion> list){
        Map<String,List<Conversion>> result = new HashMap<>();
        list.stream().forEach(
                c ->{
                    result.put(c.from,new ArrayList<>());
                    result.get(c.from).add(c);
                }
        );
        return result;
    }

    private static class Conversion{
        public String from;
        public String to;
        public float rate;

        public Conversion(String f,String t, float r){
            this.from = f;this.to = t;this.rate = r;
        }
    }
}
