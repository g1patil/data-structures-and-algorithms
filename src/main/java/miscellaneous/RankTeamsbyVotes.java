package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RankTeamsbyVotes   {


    public String rankTeams(String[] votes) {
        Map<Character,int[]> map = new HashMap<>();
        int length = votes[0].length();

        for(String vote : votes){
            for(int i = 0; i < length; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent( c , new int[length]);
                map.get(c)[i]++;
            }
        }

        List<Character> characters = new ArrayList<>(map.keySet());

        Collections.sort(characters, (a,b)->{
            for(int i = 0; i < length; i++) {
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : characters){
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(
                rankTeams(
                        new String[]{
                                "ABC","ACB","ABC","ACB","ACB"
                        }
                )
        );
    }
}