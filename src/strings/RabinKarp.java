package strings;

import org.junit.Test;

/**
 * @auther g1patil
 */
public class RabinKarp {

    int PRIME = 3 ;

    /**
     * Generates the hash for the given string. This is custom hash function and not should not be used in the
     * production.
     * @param string  input string
     * @return hash of the string
     * */
    private int generateHash(String string){
        int hash = 0 ;

        for (int i = 0; i < string.length(); i++) {
            hash = hash + ( (int) string.charAt(i) )* PRIME^i ;
        }
        return hash;
    }


    /**
     * Checks if the given pattern exists in the input string.
     * @param inputString inoput string
     * @param patternString pattern the needs to be checked
     * From the beginning, get the substring of the length which is equal to the
     *                      lenght of the pattern, generate the hash of it. and match it with
     *                      input pattern hash.
     * */
    private int matchThePattern(String inputString , String patternString){

        int hashOfPattern = generateHash(patternString);
        for (int i = 0; i <= inputString.length() - patternString.length(); i++) {
            if ( generateHash(inputString.substring(i , i + patternString.length())) == hashOfPattern){
                return i ;
            }
        }

        return -1 ;
    }

    @Test
    public void test_(){
        System.out.println(this.matchThePattern("abedabc","abc"));
    }

}
