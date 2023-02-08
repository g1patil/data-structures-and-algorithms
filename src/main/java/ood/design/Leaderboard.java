package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * 1244. Design A Leaderboard
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class Leaderboard {

    private static class Player {
        public int id;
        public int score;

        public Player(int i){
            this.id = i;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if( o == null || getClass()!= o.getClass() ) return false;
            Player p = (Player) o;
            return this.id == p.id;
        }

        @Override
        public int hashCode(){
            return Objects.hashCode(id);
        }
    }

    private List<Player> list;
    private Map<Integer,Player> players;
    public Leaderboard() {
        list = new ArrayList<>();
        players = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        players.putIfAbsent(playerId,new Player(playerId));
        if(!list.contains(players.get(playerId))){
            list.add(players.get(playerId));
        }
        players.get(playerId).score= players.get(playerId).score + score;
    }

    public int top(int K) {
        if(list.isEmpty())
            return 0;
        list.sort((a,b)->b.score-a.score);
        int sum = 0;
        for(int i=0;i < K ; i++){
            sum+=list.get(i).score;
        }
        return sum;
    }

    public void reset(int playerId) {
        players.get(playerId).score = 0;
    }
}
