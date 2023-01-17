package disjointset;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author https://leetcode.com/alexander
 * 721. Accounts Merge
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MergeAccountsUF {

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String,String> parents = new HashMap<>();
        Map<String,String> owner = new HashMap<>();

        Map<String , TreeSet<String>> resMap = new HashMap<>();

        //build the parent- parent map and owner map
        for(List<String> acc : acts){
            String o = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                parents.put(acc.get(i) , acc.get(i));
                owner.put(acc.get(i), o);
            }
        }

        //union all the emails, first will be the leader
        for (List<String> acc : acts){
            String parent = find(acc.get(1) , parents);
            for (int i = 2; i < acc.size(); i++) {
                parents.put( find(acc.get(i) , parents) , parent);
            }
        }

        for (List<String> acc : acts){
            String parent  = find(acc.get(1) , parents);

            if (!resMap.containsKey(parent)){
                resMap.put(parent , new TreeSet<>());
            }

            for (int i = 1; i < acc.size(); i++) {
                resMap.get(parent).add(acc.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String str : resMap.keySet()){
            List list = new ArrayList(resMap.get(str));
            list.add(0, owner.get(str));
            res.add(list);
        }
        return res ;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }

    @Test
    public void test_(){
        List<String> l1 = new ArrayList<>();
        l1.add("jivan");
        l1.add("1@g");
        l1.add("2@g");
        l1.add("5@g");

        List<String> l2 = new ArrayList<>();
        l2.add("jivan");
        l2.add("6@g");
        l2.add("7@g");
        l2.add("1@g");

        List<String> l3 = new ArrayList<>();
        l3.add("manoj");
        l3.add("3@g");
        l3.add("4@g");
        l3.add("9@g");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(accountsMerge(list));
    }
}
