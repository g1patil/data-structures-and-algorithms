package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class PalindromePartitionRecursive {

    public boolean isPalindrome(String string , int i , int j){
        if ( j >= string.length())
            return  false ;
        while(i < j)
        {
            if(string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public int multiplyMatrix(String string , int i , int j ){

        if ( i >= j || isPalindrome(string, i, j))
            return 0 ;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j  ; k++) {
            int temp  = multiplyMatrix(string , i , k) +
            multiplyMatrix(string , k+1 , j ) + 1 ;

            min = Math.min( temp , min );
        }
        return min ;
    }

    @Test
    public void test_(){
        String name = "AABBBCCCCqqqqqqqqyxx" ;
        System.out.println( this.multiplyMatrix( name, 0 , name.length()  ) );
    }
}
