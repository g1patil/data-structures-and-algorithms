package ood.design;

import annotation.Platform;
import annotation.Site;

import java.util.*;

/**
 * One to one element mapping
 * */
@Platform(Site.RANDOM)
public class PairSocks {

    public List<List<Sock>> pairSocks(List<Sock> socks,List<Rule> rules){
        List<List<Sock>> result = new ArrayList<>();

        Map<String,Sock> map = buildMap(socks);
        Map<String,String> ruleMap = buildRuleMap(rules);

        for(Sock s : socks){
            String pairsWith = ruleMap.get(s.getKey());
            if(map.containsKey(pairsWith)){
                result.add(List.of(s,map.get(pairsWith)));
                map.remove(pairsWith);
                map.remove(s.getKey());
            }
        }
        return result;
    }

    private Map<String, String> buildRuleMap(List<Rule> rules){
        Map<String, String> map = new HashMap<>();
        for(Rule r : rules){
            map.put("left"+r.leftColor,"right"+r.rightColor);
            map.put("right"+r.rightColor,"left"+r.leftColor);
        }
        return map;
    }

    private Map<String, Sock> buildMap(List<Sock> socks){
        Map<String,Sock> map = new HashMap<>();
        for(Sock s : socks){
            map.put(s.leg+s.color , s);
        }
        return map;
    }

    public static void main(String[] args){
        List<Sock> socks = Arrays.asList(
                new Sock(1, "red","left"),
                new Sock(2, "red","right"),
                new Sock(3, "blue","left"),
                new Sock(4,  "black","right"),
                new Sock(5, "black","left"),
                new Sock(6, "red","right")
        );

        System.out.println(new PairSocks().pairSocks(
                socks,
                List.of(new Rule("blue", "black"),new Rule("black", "red"))
        ));
    }

    private static class Sock{
        public int id;
        public String leg,color;

        public Sock(int i , String c, String l){
            this.id = i ; this.leg = l;this.color = c;
        }

        public String getKey(){
            return leg+color;
        }

        @Override
        public String toString(){
            return "Sock{"+
                    "id="+id+
                    ", leg='"+leg+'\''+
                    ", color='"+color+'\''+
                    '}';
        }
    }

    private static class Rule {
        public String leftColor, rightColor;

        public Rule(String l,String r){
            this.leftColor = l;this.rightColor = r;
        }
    }
}
