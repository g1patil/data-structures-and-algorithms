package strings;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 */

public class EncodeandDecodeStrings {

    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();

        for(String line : strs) {
            for(char c : line.toCharArray()) {
                sb.append((int) c);
                sb.append("#");
            }
            sb.append("@");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String encoded){
        String[] lines = encoded.split("@",-1);
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();

        for(String s : lines) {
            if(s.isEmpty()){
                result.add("");
                continue;
            }
            for(String _s : s.split("#")) {
                sb.append((char) Integer.parseInt(_s));
            }
            result.add(sb.toString());
            sb = new StringBuilder();
        }

        return result;
    }

    @Test
    public void test(){
        String encoded = encode(List.of("", ""));
        System.out.println(
                decode(encoded)
        );
    }
}
