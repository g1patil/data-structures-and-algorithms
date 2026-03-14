package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 734. Sentence Similarity
 * */
@Quality(value = Stage.FAILING,details = "39/49 - I dont have time to fix this ")
@Platform(Site.LEETCODE)
public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        Map<String,String> map = buildSimilarityMap(similarPairs);
        if(sentence1.length != sentence2.length)
            return false;

        for(int i = 0; i < sentence1.length; i++) {
            if( ! areEqual(sentence1[i],sentence2[i], map))
                return false;
        }
        return true;
    }

    private boolean areEqual(String s , String d , Map<String,String> map){
        return  s.equals(d) || s.equals(map.get(d)) || d.equals(map.get(s));
    }

    private Map<String,String> buildSimilarityMap(List<List<String>> similarPairs){
        Map<String,String> map = new HashMap<>();
        for(List<String> pair :  similarPairs){
            map.put(pair.get(0),pair.get(1));
        }
        return map;
    }
}
