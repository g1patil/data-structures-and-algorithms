package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class PalindromePartitionRecursive {

    int[][] memoization ;

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

    /**
     * Recursive approach
     * */
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

    /**
     * Top down approach
     * */
    public int multiplyMatrixTopDown(String string , int i , int j ){

        if (this.memoization[i][j] != -1)
            return this.memoization[i][j] ;

        if ( i >= j || isPalindrome(string, i, j))
            return 0 ;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j  ; k++) {
            int temp  = multiplyMatrixTopDown(string , i , k) +
                    multiplyMatrixTopDown(string , k+1 , j ) + 1 ;

            min = Math.min( temp , min );
        }
        return this.memoization[i][j] = min ;
    }

    /**
     * Top down approach optimized
     * */
    public int multiplyMatrixTopDownOptimized(String string , int i , int j ){

        if (this.memoization[i][j] != -1)
            return this.memoization[i][j] ;

        if ( i >= j || isPalindrome(string, i, j))
            return 0 ;

        int left = 0 , right = 0  ;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j  ; k++) {

            if(memoization[i][k] != -1){
                left = memoization[i][k] ;
            } else left = multiplyMatrixTopDown(string , i , k) ;

            if(memoization[k +1 ][j] != -1){
                right = memoization[k+1][j] ;
            } else right = multiplyMatrixTopDown(string , k+1 , j )  ;

            int temp  = left + right + 1 ;

            min = Math.min( temp , min );
        }
        return this.memoization[i][j] = min ;
    }

    @Test
    public void test_(){
        String name = "AABBBCCCCqqqqqqqqyxxyyyyyyyyyqqqqqqqqqqqqqqqqqqjjjjjjjkkkkkkkllllbbbbbbbbbbbbbbppppppppppppppppppppppppxxxpppppppvvvvvvvvvvvvvvvveeeeeeeeewwwwwww" ;
        System.out.println( this.multiplyMatrix( name, 0 , name.length()  ) );
    }

    @Test
    public void test_2(){
        String name = "AABBBCCCCqqqqqqqqyxxyyyyyyyyyqqqqqqqqqqqqqqqqqqjjjjjjjkkkkkkkllllbbbbbbbbbbbbbbppppppppppppppppppppppppxxxpppppppvvvvvvvvvvvvvvvveeeeeeeeewwwwwwwzxcvbnm" ;
        this.memoization = new int[name.length() + 1][ name.length() + 1] ;

        for (int i = 0; i <= name.length() ; i++) {
            for (int j = 0; j <= name.length() ; j++) {
                this.memoization[i][j] = -1 ;
            }
        }

        long startTime = System.currentTimeMillis();
        System.out.println( this.multiplyMatrixTopDown( name, 0 , name.length()  ) );
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }
}
