package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

public class ScrambleString {

    private boolean solve(String s1 , String s2){
        int length = s1.length() ;
        boolean flag = false ;

        if ( s1.length() != s2.length() )
            return false ;

        if ( s1.isBlank() && s2.isBlank())
            return false ;

        if ( s1.equals( s2))
            return true ;

        for (int i = 1; i <=  length - 1; i++) {
            if (
                    (
                            solve( s1.substring(0 ,  i ), s2.substring( length - i  , length )) &&
                            solve( s1.substring(i , length ), s2.substring(0, length - i))
                    ) ||
                    (
                            solve( s1.substring(0 ,  i ), s2.substring(0 ,  i  )) &&
                                    solve( s1.substring(i , length ), s2.substring(i , length ))
                    )
            ){
                return true;
            }
        }
        return flag ;
    }
    @Test
    public void test_(){

        System.out.println( this.solve("jivan", "vanji" ));
        System.out.println( this.solve("abcde", "caebd" ));
    }
}
