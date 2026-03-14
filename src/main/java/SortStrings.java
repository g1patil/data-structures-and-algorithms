import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Sort the list of string based on the last and first char of the string.
 * Ex :  [jivan, manoj, nanam] should be
 *  [jivan, nanam ,manoj]
 * */
public class SortStrings {

    public String getStringWithInitialChar(List<String> source, char target){
        return source
                .stream()
                .filter(s->target == s.charAt(0))
                .collect(Collectors.toList()).get(0);

    }

    public String getStringWithLastChar(List<String> source, char target){
        return source
                .stream()
                .filter(s->target == s.charAt(s.length()))
                .collect(Collectors.toList()).get(0);

    }
    LinkedList<String> sortedList(LinkedList<String> names){
        LinkedList<String> result = new LinkedList<>();
        result.add(names.getFirst());
        names.removeFirst();

        names.stream().forEach(name->{
            String next = getStringWithInitialChar(
                    names,
                    result.getLast().charAt(result.getLast().length()-1));
            result.add(next);
        });
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();

        names.add("jivan");
        names.add("manoj");
        names.add("nanap");
        names.add("poojam");
        SortStrings sortStrings = new SortStrings();
        System.out.println(sortStrings.sortedList(names));

    }
}
