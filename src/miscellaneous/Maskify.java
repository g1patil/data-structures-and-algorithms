package miscellaneous;

import org.junit.Test;

public class Maskify {

    private String maskify(String credit){
        if ( credit == ""){
            return credit;
        }

        if ( credit.length() < 7){
            return credit;
        }

        char first = credit.charAt(0);
        char[] masked = credit.replaceAll("[^$#][^!][^-a-zA-Z](?=.{4})", "#").toCharArray();
        masked[0] = first;
        return String.valueOf(masked);
    }

    @Test
    public void main(){

        String i = maskify("A1!2/(3)[4]^%56789");
    }
}
