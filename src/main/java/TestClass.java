import org.junit.jupiter.api.Test;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    // 344. 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c-'a']++;
        }
        for(char c : t.toCharArray()){
            chars[c-'a']--;
        }

        for(int i : chars){
            if(i != 0)
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(
                isAnagram("jivan","vanjia")
        );
    }

}
