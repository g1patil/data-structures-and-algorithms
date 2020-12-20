package regex;

import org.junit.Assert;
import org.junit.Test;

public class RegExTest {

    RegEx regEx = new RegEx();

    @Test
    public void test1(){
        Assert.assertTrue(regEx.checkRegEx("Joe"));
    }

    @Test
    public void test1a(){
        Assert.assertTrue(regEx.checkRegEx(" Joe "));
    }

    @Test
    public void test2(){
        Assert.assertTrue(regEx.checkRegEx("Jim"));
    }

    @Test
    public void test2a(){
        Assert.assertTrue(regEx.checkRegEx(" Jim "));
    }

    @Test
    public void test3(){
        Assert.assertTrue(regEx.checkRegEx("my name is Jim."));
    }

    @Test
    public void test4(){
        Assert.assertTrue(regEx.checkRegEx("my name is Jim.And you ?"));
    }

    @Test
    public void test5(){
        Assert.assertTrue(regEx.checkRegEx("my name is Joe.And you ?"));
    }

    @Test
    public void test6(){
        Assert.assertTrue(regEx.checkRegEx("my name is Jim Joe."));
    }

    @Test
    public void test7(){
        Assert.assertTrue(regEx.checkRegEx("Jim Joe"));
    }

    @Test
    public void test8(){
        Assert.assertFalse(regEx.checkRegEx("mynameisJimandyou"));
    }

    @Test
    public void test9(){
        Assert.assertFalse(regEx.checkRegEx("mynameisJimandyou"));
    }



}
