import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */
public class TestClass {



    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap();
        List<List<String>> result = new ArrayList();
        for(String path : paths){

            String[] p = path.split(" ");


            for(int i  = 1 ; i < p.length ; i ++){
                String dir = p[0];
                String content = p[i].substring( p[i].indexOf('(') + 1 , p[i].indexOf(')') );

                if(!map.containsKey(content)){
                    List<String> list = new ArrayList();
                    list.add( dir + "/" + p[i].substring(0, p[i].indexOf('(')));
                    map.put(content , list);
                } else {
                    map.get(content).add(dir + "/" + p[i].substring(0, p[i].indexOf('(')));
                }
            }

        }

        map.keySet().stream().filter( k-> map.get(k).size() > 1).forEach(
                k-> result.add(map.get(k)));

        return result;
    }

    @Test
    public void test_(){
        String[] path = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(path));
    }

}
