package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 1244. Design A Leaderboard
 * map : userId -> score
 * treeMap : score -> frequency
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Leaderboard {

    private final Map<Integer, Integer> map;
    private final TreeMap<Integer, Integer> sorted;

    public Leaderboard(){
        this.map = new HashMap<>();
        sorted = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score){
        if(map.containsKey(playerId)){
            int oldScore = map.get(playerId);
            sorted.put(oldScore, sorted.get(oldScore)-1);
            sorted.remove(oldScore, 0);
            int newScore = oldScore+score;
            map.put(playerId, newScore);
            sorted.put(newScore, sorted.getOrDefault(newScore, 0)+1);
        } else{
            map.put(playerId, score);
            sorted.put(score, sorted.getOrDefault(score, 0)+1);
        }
    }

    public int top(int K){
        int count = 0;
        int sum = 0;
        for(int score : sorted.keySet()) {
            int times = sorted.get(score);
            for(int i = 0; i < times; i++) {
                sum += score;
                count++;

                if(count == K)
                    break;
            }
            if(count == K)
                break;
        }
        return sum;
    }

    public void reset(int playerId){
        int oldScore = map.get(playerId);
        sorted.put(oldScore, sorted.get(oldScore)-1);
        map.put(playerId, 0);
        sorted.remove(oldScore, 0);
        map.remove(playerId);
    }

    @Test
    public void test(){
        Leaderboard lb = new Leaderboard();
        lb.addScore(1, 73);
        lb.addScore(2, 56);
        lb.addScore(3, 39);
        lb.addScore(4, 51);
        lb.addScore(5, 4);
        lb.top(1);
        lb.reset(1);
        lb.reset(2);
        lb.addScore(2, 51);
        lb.top(3);

    }
}
