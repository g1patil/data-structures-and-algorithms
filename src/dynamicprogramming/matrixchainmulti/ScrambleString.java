package dynamicprogramming.matrixchainmulti;

import org.junit.Test;

import java.util.HashMap;

public class ScrambleString {

    HashMap<String ,Boolean> booleanHashMap = new HashMap<>();

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

    private boolean solveMemoisation(String s1 , String s2){
        int length = s1.length() ;
        boolean flag = false ;

        if ( booleanHashMap.containsKey(s1 + s2))
            return booleanHashMap.get(s1+s2);

        if ( s1.length() != s2.length() )
            return false ;

        if ( s1.isBlank() && s2.isBlank())
            return false ;

        if ( s1.equals( s2))
            return true ;

        for (int i = 1; i <=  length - 1; i++) {
            String key_1 = s1.substring(0 ,  i ) ;
            String key_2 = s1.substring(i , length ) ;
            String key_3 = s2.substring( length - i  , length ) ;
            String key_4 = s2.substring(0, length - i) ;
            String key_5 = s2.substring(0, i) ;
            String key_6 = s2.substring(i , length ) ;

            boolean c1 = solve( key_1, key_3);
            boolean c2 = solve( key_2, key_4);
            boolean c3 = solve(key_1, key_5);
            boolean c4 =   solve( key_2, key_6);

            booleanHashMap.put(key_1 + key_3, c1 );
            booleanHashMap.put(key_2 + key_4, c2 );
            booleanHashMap.put(key_1 + key_5, c3 );
            booleanHashMap.put(key_2 + key_6, c4 );

            if ( (c1 && c2) || ( c3 && c4) ){
                return true;
            }
        }
        return flag ;
    }

    @Test
    public void test_(){

        System.out.println( this.solve("great", "rgeat" ));
        System.out.println( this.solveMemoisation("abcdefghijklmnopq", "abcdefghijklmnopq" ));
    }
}
