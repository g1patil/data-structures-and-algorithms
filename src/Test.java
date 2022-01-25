
/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class Test {

    public String longestPalindromeHelper(String source, String target , int[][] lcs){
        //build the iterative solution

        for (int i  = 1 ; i <= source.length() ; i ++){
            for (int j = 1; j <= source.length(); j++) {

                if (source.charAt(i -1) == target.charAt(j -1)){
                    lcs[i][j] = 1 + lcs[ i -1][ j -1];
                } else {
                    lcs[i][j] = Math.max( lcs[ i -1][ j] , lcs[ i][ j - 1]);
                }
            }
        }

        System.out.println(lcs[source.length()][target.length()]);
        int lcsLength = lcs[source.length()][target.length()];
        int sPointer = source.length(), tPointer = target.length();
        StringBuilder lcsString = new StringBuilder();

        while (lcsLength!= 0){

            if (source.charAt(sPointer - 1) == target.charAt(tPointer - 1)){
                lcsString.append(source.charAt(sPointer -1));
                sPointer--;
                tPointer--;
                lcsLength--;
            } else {
                if (lcs[sPointer][tPointer - 1] == lcsLength){
                    lcsLength = lcs[sPointer][tPointer - 1];
                    tPointer--;
                } else {
                    lcsLength = lcs[sPointer - 1][tPointer];
                    sPointer--;
                }
            }

        }


        return lcsString.toString();
    }

    public String longestPalindrome(String s) {
        String source = s ;
        int[][] lcs = new int[s.length() + 1][s.length() + 1];
        return longestPalindromeHelper(s, new StringBuilder(s).reverse().toString() , lcs);

    }






    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.longestPalindrome("aacabdkacaa"));
    }
}
