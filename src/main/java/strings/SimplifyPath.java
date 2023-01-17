package strings;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 71. Simplify Path
 *
 */
@Platform(Site.LEETCODE)
public class SimplifyPath {

    public String simplifyPath(String path) {
        List<String> skipList = new ArrayList<>(Arrays.asList(".." , ".", ""));
        Deque<String> stringDeque = new LinkedList<>();

        for (String _path : path.split("/")){
            if (_path.equals("..") && !stringDeque.isEmpty()) stringDeque.pop();
            else if (!skipList.contains(_path)) stringDeque.push(_path);
        }

        String result = "";
        for(String s : stringDeque){
            result = "/" + s + result ;
        }

        return result.length() == 0  ? "/" : result.toString();
    }

    @Test
    public void test_(){

        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
