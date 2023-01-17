package miscellaneous;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * @author g1patil
 * 1152. Analyze User Website Visit Pattern
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AnalyzeUserWebsiteVisitPattern {

    class Visit{
        String site;
        int time;

        public Visit(String s , int t){
            this.site = s ; this.time = t ;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String , List<Visit>> freqMap = new HashMap<>();
        String result = "";
        int n = username.length;

        for (int i = 0; i < n; i++) {
            freqMap.putIfAbsent(username[i] , new ArrayList<>());
            freqMap.get(username[i]).add(new Visit(website[i] , timestamp[i]));
        }

        Map<String,Integer> count = new HashMap();
        for(String user : freqMap.keySet()){
            List<Visit> visits = freqMap.get(user);
            Set<String> set = new HashSet();
            visits.sort(Comparator.comparingInt(o->o.time));
            int len = visits.size();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1 ; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        String patt = visits.get(i)+" "+visits.get(j)+" "+visits.get(k);
                        if(!set.contains(patt)){
                            count.put(patt , count.getOrDefault(patt , 0) + 1);
                            set.add(patt);
                        }

                        if(result == "" || count.get(result) < count.get(patt) || ( count.get(result) == count.get(patt) && result.compareTo(patt) > 0 )){
                            result = patt;
                        }
                    }
                }
            }
        }

        String[] response = result.split(" ");
        List<String> list= new ArrayList<>();
        for (String s : response)
            list.add(s);

        return list;
    }
}
