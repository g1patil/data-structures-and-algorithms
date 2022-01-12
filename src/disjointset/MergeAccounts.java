package disjointset;

import java.util.*;

/**
 * @author g1patil
 * 721. Accounts Merge
 */
public class MergeAccounts {

    Map<String,Integer> stringIntegerMap = new HashMap<>();
    List<List<String>> result ;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        accounts = result ;

        for (int i = 0; i < accounts.size(); i++) {
            List<String> contact = accounts.get(i);
            for (int j = 0; j < contact.size(); j++) {
                if (stringIntegerMap.containsKey(contact.get(j))){
                    mergeTwoList( stringIntegerMap.get(contact.get(j)) , i );
                } else stringIntegerMap.put(contact.get(j), i );
            }
        }
        return null;
    }

    public void mergeTwoList(int sourceIndex , int targetIndex){
        result.get(sourceIndex).addAll(result.get(targetIndex));
    }
}
