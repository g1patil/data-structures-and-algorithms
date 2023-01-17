package regex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegExTest {

    RegEx regEx = new RegEx();

    @Test
    public void test1(){
        Assertions.assertTrue(regEx.checkRegEx("Joe"));
    }

    @Test
    public void test1a(){
        Assertions.assertTrue(regEx.checkRegEx(" Joe "));
    }

    @Test
    public void test2(){
        Assertions.assertTrue(regEx.checkRegEx("Jim"));
    }

    @Test
    public void test2a(){
        Assertions.assertTrue(regEx.checkRegEx(" Jim "));
    }

    @Test
    public void test3(){
        Assertions.assertTrue(regEx.checkRegEx("my name is Jim."));
    }

    @Test
    public void test4(){
        Assertions.assertTrue(regEx.checkRegEx("my name is Jim.And you ?"));
    }

    @Test
    public void test5(){
        Assertions.assertTrue(regEx.checkRegEx("my name is Joe.And you ?"));
    }

    @Test
    public void test6(){
        Assertions.assertTrue(regEx.checkRegEx("my name is Jim Joe."));
    }

    @Test
    public void test7(){
        Assertions.assertTrue(regEx.checkRegEx("Jim Joe"));
    }

    @Test
    public void test8(){
        Assertions.assertFalse(regEx.checkRegEx("mynameisJimandyou"));
    }

    @Test
    public void test9(){
        Assertions.assertFalse(regEx.checkRegEx("mynameisJimandyou"));
    }

    @Test
    public void testValidNumber(){
        Assertions.assertTrue(regEx.validNumber("0"));
        Assertions.assertTrue(regEx.validNumber("1"));
        Assertions.assertTrue(regEx.validNumber("-1"));
        Assertions.assertTrue(regEx.validNumber("+1"));
        Assertions.assertFalse(regEx.validNumber("a"));
        Assertions.assertFalse(regEx.validNumber("1a"));
        Assertions.assertTrue(regEx.validNumber("0.1"));
        Assertions.assertFalse(regEx.validNumber("0..1"));
        Assertions.assertFalse(regEx.validNumber("0."));
        Assertions.assertFalse(regEx.validNumber("."));
        Assertions.assertTrue(regEx.validNumber(".2"));
        Assertions.assertFalse(regEx.validNumber("3."));

    }



}
