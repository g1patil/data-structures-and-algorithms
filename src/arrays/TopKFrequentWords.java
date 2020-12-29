package arrays;

import org.junit.Assert;
import org.junit.Test;
import java.util.*;

/**
 * 692. Top K Frequent Words
 *
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 *
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 *
 * Try to solve it in O(n log k) time and O(n) extra space.
 * */
public class TopKFrequentWords {

    /**
     * @param words array of string elements
     * @param k , target number of string
     * @return list of k frequent words
     * */
    private List<String> topKFrequent(final String[] words, final int k) {

        if(words.length < k){
            return null;
        }

        List<String> stringList = new ArrayList<>();

        Map<String,Integer> stringIntegerMap = new HashMap<>();

        for(String word : words){
            if ( stringIntegerMap.containsKey( word ) ) {
                stringIntegerMap.put( word , stringIntegerMap.get( word) + 1);
            } else {
                stringIntegerMap.put( word ,1 );
            }
        }

        Queue<String> stringQueue = new PriorityQueue<>( (s1,s2) -> stringIntegerMap.get(s1) - stringIntegerMap.get(s2));

        stringIntegerMap.keySet().forEach(s->{
            stringQueue.add(s);
            if(stringQueue.size() > k){
                stringQueue.poll();
            }
                }
        );

        stringList.addAll(stringQueue);

        return stringList;
    }


    @Test
    public void test(){
        List<String> stringList = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
        Assert.assertNotNull(stringList);
        Assert.assertEquals(2,stringList.size());
    }

    @Test
    public void test2(){

    }
}
