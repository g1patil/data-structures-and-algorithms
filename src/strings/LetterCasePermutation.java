package strings;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author g1patil
 * 784. Letter Case Permutation
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        ArrayDeque<StringBuilder> queue = new ArrayDeque<>();
        HashSet<String> stringSet = new HashSet<>();

        queue.add(new StringBuilder(s));
        
        int charCount = 0;
        
        for (char c : s.toCharArray()){
            if (Character.isLetter(c))
                charCount++;
        }

        while (!queue.isEmpty() && stringSet.size() != Math.pow(2 , charCount)){

            StringBuilder currentString = new StringBuilder(queue.poll());

            for (int i = 0; i < currentString.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(currentString);

                if (stringBuilder.charAt(i) >= '0' && stringBuilder.charAt(i) <= '9' )
                    continue;

                if (Character.isLowerCase(stringBuilder.charAt(i))){
                    stringBuilder.setCharAt( i , Character.toUpperCase(stringBuilder.charAt(i)));
                } else {
                    stringBuilder.setCharAt( i , Character.toLowerCase(stringBuilder.charAt(i)));
                }
                if (!stringSet.contains(stringBuilder.toString())){
                    queue.addLast(stringBuilder);
                    stringSet.add(stringBuilder.toString());
                }
            }
            if (!stringSet.contains(currentString.toString())){
                queue.addLast(currentString);
                stringSet.add(currentString.toString());
            }
        }

        List<String> result = new ArrayList<>();
        stringSet.iterator().forEachRemaining(result::add);

        return result;
    }

    /**
     * Reference : https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation
     * */
    public List<String> letterCasePermutationOptimal(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }

        return new LinkedList<>(queue);
    }

    @Test
    public void test_(){
        System.out.println(letterCasePermutationOptimal("a1b1c1"));
    }
}
