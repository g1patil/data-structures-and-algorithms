package lists;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class MakeChain {

    List<String> strings = new ArrayList<>();
    String mainSource;

    private boolean makeChain(String source , Stack<String> stringStack, Set<String> visited){

        stringStack.push( source );
        visited.add( source );
        List<String> nextSource = getNextSource(source, visited);

        if ( stringStack.size() == strings.size()){
            return true;
        }
        if ( stringStack.size() != strings.size() && nextSource.isEmpty() ){
            return false;
        }

        for ( String newSource : nextSource){
            String temp = newSource;
            boolean result = makeChain( newSource , stringStack , visited);
            if ( result){
                System.out.println( stringStack );
                return true;
            }
            if ( !result && stringStack.size() != strings.size() ){

                while ( stringStack.peek() != temp){
                    stringStack.pop();
                }
            }
        }

        return stringStack.size() == strings.size()
                && stringStack.peek().charAt( stringStack.peek().length()-1) == mainSource.charAt(0) ;
    }

    private List<String> getNextSource(String s_, Set visited) {
        return strings.stream()
                .filter( s-> s.charAt(0) == s_.charAt(s_.length() -1 ) && !visited.contains(s)).
                collect(Collectors.toList());
    }

    @Test
    public void test(){
        mainSource = "jivan";
        this.strings = List.of("jivan","navo", "ijj" , "sa","jjjsdiii", "iisdfjjjj", "omkar", "ommm" , "rrroo", "mrrr","ravi");
        // jivan - navo - omkar - rrroo - ommm - mrrr - ravi - ijj
        System.out.println( makeChain( "jivan" , new Stack<>(), new HashSet<>()));
    }

    @Test
    public void test2(){
        mainSource = "jivan";
        this.strings = List.of("ja","jb", "ijj" , "sa","jjjsdiii", "iisdfjjjj", "omkar", "ommm" , "rrroo", "mrrr","ravi");
        // jivan - navo - omkar - rrroo - ommm - mrrr - ravi - ijj
        System.out.println( makeChain( "jivan" , new Stack<>(), new HashSet<>()));
    }
}
