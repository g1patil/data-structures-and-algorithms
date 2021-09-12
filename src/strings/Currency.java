package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Currency {
    List<String> currencyList = new ArrayList<>();
    {
        String input = "USD/INR,GBP/RND,JPY/YAN,QWE/RTY,GBP/INR,UYT/TYU,POI/OOP,YAN/BYJ";
        for (String s : input.split(",")) {
            currencyList.add(s);
        }
    }

    boolean containsSole(String c){
        return currencyList.stream().filter(s->s.contains(s)).findFirst().isEmpty();
    }
    boolean contains(String source, String destination){
        return currencyList.contains(source + "/" + destination) ||
        currencyList.contains(destination + "/" +source );
    }

    boolean canConvert(String source, String destination){

        List<String> result = currencyList.stream().filter(s-> s.contains(source)).collect(Collectors.toList());
        if(result.isEmpty() || currencyList.isEmpty())
            return false;

        for (String s : result) {
            currencyList.remove(s);
            String newSource =  s.replace(source,"").replace("/", "");
            return canConvert(newSource, destination) && !result.isEmpty();
        }

        if(source == null )
            return false;
        if (contains(source,destination))
            return true;
        String newSource = getCurrency(source);
        return canConvert(newSource, destination) && !containsSole(source);
    }

    private String getCurrency(String source) {
        List<String> result = currencyList.stream().filter(s-> s.contains(source)).collect(Collectors.toList());
        if(result.isEmpty() || currencyList.isEmpty())
            return null;

        for (String s : result) {
            currencyList.remove(s);
            return s.replace(source,"").replace("/", "");
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println( new Currency().canConvert("INR","RND"));
    }
}
