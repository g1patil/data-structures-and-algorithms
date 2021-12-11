package strings;

import org.junit.Test;

/**
 * @author g1patil
 *
 * Proper suffix is the suffix of the string which is not equal to the whole string.
 * jivan -> ji is the proper suffix. jivan is not the proper suffix of the jivan , but jiva is.
 *
 * In the KMP we are try to find the prefix , which is also the suffix in the string. Its like
 * finding the small pattern in the pattern input. We then keep the prefix length array.
 * So that while failure happens, we can resume. Here notice that the match failure happens
 * in the suffix area of the pattern, so that we can skip the prefix part.
 *
 */
public class KMP {


    /**
     * Keep in mind the following example.
     * 0 1 2 3 4 5 6 7 8 9 10
     *   a b c x x x a b c y
     *-1 0 0 0 0 0 0 1 2 3 0
     *
     * Function which build the prefix failure function.
     * @param pattern string input
     * @return prefix int array
     * */
    private int[] buildFailureFunction(String pattern){
        int patternLength = pattern.length();
        int[] prefixArray = new int[ patternLength + 1];

        prefixArray[0] = -1 ;

        int pointer = 1;
        int prefixLength = 0 ;

        while ( pointer < patternLength){

            if ( pattern.charAt(pointer) == pattern.charAt( prefixLength)){
                prefixLength ++ ;
                pointer ++ ;
                prefixArray[pointer] = prefixLength ;

            } else if ( prefixLength > 0 ){
                prefixLength = prefixArray[ prefixLength ] ;
            } else {
                pointer ++ ;
                prefixArray[pointer] = 0 ;
            }

        }

        return  prefixArray;
    }

    private int solveKMP(String inputString , String pattern){
        int pointerInput = 0 ;
        int pointerPattern = 0 ;

        int[] prefixArray = buildFailureFunction(pattern);

        while ( pointerInput < inputString.length()){
            // if the char at both pointer location match then increment both the pointers
            if ( inputString.charAt(pointerInput) == pattern.charAt(pointerPattern)){
                pointerInput++;
                pointerPattern++;

                // when we reach the end of the pattern then hault
                if ( pointerPattern == pattern.length()){
                    System.out.println( pointerInput - pointerPattern);
                    break;
                }
            } else {
                //if there is mismatch, the reset the pattern pointer. The reset value should be retrieved from prefix array
                //prefix array can save time when failure happened at the suffix. If not then it will go at the beginning.
                // make sure to increment both after that. Also it might become -1 , so assure that.
                pointerPattern = prefixArray[pointerPattern];
                if ( pointerPattern < 0 ){
                    pointerPattern++;
                    pointerInput ++ ;
                }
            }
        }
        return inputString.length() - pattern.length();
    }

    @Test
    public void test_(){
        String text = "---abcxxxab------abcxxxabcy---";
        String pattern = "abcxxxabcy";

        System.out.println("text="+text);
        System.out.println("pattern=" + pattern);

        System.out.println(solveKMP(text, pattern));
    }

    @Test
    public void test_2(){
        String text = "ABABABACCABC";
        String pattern = "ABC";

        System.out.println("text="+text);
        System.out.println("pattern=" + pattern);

        System.out.println(solveKMP(text, pattern));
    }
}
