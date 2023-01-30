package strings;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class CaesarCipher {


    public String caesarCipherEncryption(String string,int _d){
        StringBuilder md = new StringBuilder();

        for(char c : string.toCharArray()){
            int number = (c - 'a' + _d ) % 26 ;
            md.append((char) (number + 'a'));
        }

        return md.toString();
    }

    @Test
    public void test(){
        System.out.println(
                caesarCipherEncryption(
                        "abc",29
                )
        );
    }

    @Test
    public void test2() throws URISyntaxException{
        System.out.println(
                new URI("jivan.com").getHost()
        );
    }
}
