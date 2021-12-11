package strings;

import org.junit.Test;

/**
 * @author g1patil
 */
public class ZAlgorithm {

    int[] ZArray ;

    private void searchPattern(String input, String pattern){
        this.solve(pattern + "$" + input );
        for (int i = pattern.length() + 1; i < this.ZArray.length; i++) {
            if ( ZArray[i] == pattern.length())
                System.out.println( "match found at : " + (i - pattern.length() - 1) );
        }
    }
    private void solve(String string){
        int flag ;

        for (int i = 1; i < string.length(); i++) {
            flag = 0 ;
            int j = i ;

            while ( string.charAt( j ) == string.charAt(flag) && string.charAt( j ) != '$'){
                flag ++ ;
                j++ ;
            }

            this.ZArray[i] = flag ;
        }
    }

    @Test
    public void test(){
        String pattern = "Geek" ;
        String inputString  = "Geeks for Geeks";
        this.ZArray = new int[pattern.length() + inputString.length() + 1 ];
        this.searchPattern(inputString , pattern );
    }
}
