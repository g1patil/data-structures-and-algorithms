/**
 Problem  :
 Given the string with repeating chars , remove the repeating chars when the
 consecutive count for any character goes more than 2.

 Example :
 input : aaaaaaaabbbbbcccc
 output : aabbcc

 input abbbbbbvvvvvv
 output : abbvv

 input abc
 output : abc

 */
public class SomeTestClass {

    public static String removeRepeatingChars(String input){

        int start = 0;
        int end = 0;

        String result = "";

        while (end < input.length()) {
            System.out.println("Start: " + start);
            System.out.println("End: " + end);
            char startCharacter = input.charAt(start);
            System.out.println("StartChar: " + startCharacter);
            char endCharacter  = input.charAt(end);
            System.out.println("endChar: " + endCharacter);
            if (end - start >= 2 && startCharacter == endCharacter ) {
                end++;
            } else {
                if (startCharacter == endCharacter) {
                    result +=   startCharacter;
                    end++;
                }else {
                    // result += startCharacter;
                    start = end;
                    end = start+1;
                }
            }
            System.out.println("Result:" + result);
        }
        // result += input.charAt(end-1);
        return result;
    }
    public static void main(String[] args) {
        System.out.println( removeRepeatingChars("aaaaaaaabbbbbcccc"));
        System.out.println( removeRepeatingChars("abbbbbbvvvvvv") );
        System.out.println( removeRepeatingChars("abc") );
    }
}
