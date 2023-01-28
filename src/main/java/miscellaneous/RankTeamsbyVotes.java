package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RankTeamsbyVotes   {


    public String rankTeams(String[] votes) {
        Map<Character,int[]> votesMap = new HashMap<>();
        int length = votes[0].length();
        StringBuilder sb = new StringBuilder();

        for(String vote : votes){
            for(int i = 0; i < length; i++) {
                Character c = vote.charAt(i);
                votesMap.putIfAbsent(c , new int[length]);
                votesMap.get(c)[i]++;
            }
        }
        List<Character> list = new ArrayList<>(votesMap.keySet());
        list.sort((a,b)->{
            for(int i = 0; i < length; i++) {
                if(votesMap.get(a)[i] != votesMap.get(b)[i]){
                    return votesMap.get(b)[i] - votesMap.get(a)[i];
                }
            }
            return a - b ;
        });
        list.stream().forEach(c->sb.append(c));
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