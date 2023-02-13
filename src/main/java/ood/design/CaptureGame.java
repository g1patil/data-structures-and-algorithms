package ood.design;

import java.util.*;

public class CaptureGame {

    private final Map<String,Integer> scoreMap ;
    private final Map<String,Integer> pointmap;
    Map<Integer,List<String>> topScores;


    public CaptureGame(){
        pointmap = new HashMap<>();
        pointmap.put("banana",3);
        pointmap.put("apple",5);
        pointmap.put("berry",7);
        pointmap.put("tomato",1);

        scoreMap = new HashMap<>();
        topScores = new TreeMap<>(Comparator.reverseOrder());
    }

    public void capture(String player, String fruit){
        int oldScore = scoreMap.getOrDefault(player,0);
        int newScore = oldScore + pointmap.get(fruit);

        if(topScores.containsKey(oldScore)){
            topScores.get(oldScore).remove(player);
            if(topScores.get(oldScore).isEmpty())
                topScores.remove(oldScore);
        }
        topScores.putIfAbsent(newScore,new ArrayList<>());
        topScores.get(newScore).add(player);

        scoreMap.putIfAbsent(player,0);
        scoreMap.put(player, newScore);
    }

    public List<String> getTopPlayer(){
        int highest = topScores.keySet().stream().findFirst().get();
        return topScores.get(highest);
    }

    public static void main(String[] args){
        CaptureGame game = new CaptureGame();
        game.capture("ravi","banana");
        game.capture("ravi","apple");
        game.capture("jivan","tomato");

        System.out.println(
                game.getTopPlayer()
        );
    }
}
