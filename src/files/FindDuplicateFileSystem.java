package files;

import annotation.Platform;
import annotation.Site;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author g1patil
 * 609. Find Duplicate File in System
 *
 * Given a list paths of directory info, including the directory path,
 * and all the files with contents in this directory,
 * return all the duplicate files in the file system in terms of their paths.
 * You may return the answer in any order.
 *
 * inout :
 * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
 * Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 *
 */
@Platform(Site.LEETCODE)
public class FindDuplicateFileSystem {

    HashMap<String , List<String>> contentMap = new HashMap();

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();

        //build the content map
        for (String path : paths){
            String[] files = path.split(" ");
            String root = files[0];

            for (int i = 1; i < files.length; i++) {
                String content = files[i].substring(files[i].indexOf('(') + 1, files[i].indexOf(')'));
                String fileName = files[i].substring(0 , files[i].indexOf('(') );

                if (contentMap.containsKey(content)){
                    contentMap.get( content).add(root + "/" + fileName);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(root + "/" + fileName);
                    contentMap.put(content , list);
                }
            }
        }

        contentMap.keySet().stream().filter( k-> contentMap.get(k).size() > 1).forEach( k->{
            result.add(contentMap.get(k));
        });

        System.out.println(result);
        return result;

    }

    @Test
    public void test_(){
        String[] strings = new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"
        };
        findDuplicate(strings);
    }
}
