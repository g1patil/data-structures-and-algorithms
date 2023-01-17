package strings;

import org.junit.jupiter.api.Test;

/**
 * @author g1patil
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if(needle.isBlank() || haystack == "")
            return 0;

        if(needle.length() > haystack.length())
            return -1;
        for(int i = 0 ; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(match(haystack , needle , i))
                    return i;
            }
        }

        return -1;
    }

    public boolean match(String s , String t , int index){
        int j = 0;
        while(j < t.length()){
            if(s.charAt(index)!=t.charAt(j))
                return false;
            index++;
            j++;
        }
        return true;
    }

    @Test
    public void test_(){
        String s = "mississippi";
        String t = "issipi";
        System.out.println(strStr(s,t));
    }
}
