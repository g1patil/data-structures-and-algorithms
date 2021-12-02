package practice_material.cracking_coding_interview.chapter_1_string_array;

import org.junit.Test;

/**
 * @auther g1patil
 *
 * Print the repeating chars in the string.
 */
public class UniqueChar {

    static final int ASCII_MAX = 128 ;

    private void checkUnique(String string){
        boolean[] flags = new boolean[ASCII_MAX];

        for (int i = 0; i < string.length(); i++) {
            if (flags[string.charAt(i)]){
                System.out.print ( string.charAt( i ) + " ");
            }
            flags[string.charAt(i)] = true ;
        }
    }
    @Test
    public void test_(){
        this.checkUnique("jivanj is the best things that can heppen to you ");
    }
}
