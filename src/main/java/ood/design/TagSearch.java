package ood.design;

import java.util.*;

public class TagSearch {

    private Map<String,Set<String>> dict ;
    private Set<String> tagSet ;

    public TagSearch(String input){
        this.tagSet = new HashSet<>();
        this.dict = buildDisctonary(input);
        for(String f : dict.keySet()){
            tagSet.addAll(dict.get(f));
        }
    }
    public Map<String, Set<String>> buildDisctonary(String input){
        Map<String, Set<String>> map = new HashMap<>();
        for(String s : input.split("\n")){
            String[] feature = s.split(":");
            String _feature = feature[0].strip();
            map.putIfAbsent(_feature,new HashSet<>());

            for(String t : feature[1].split(" ")){
                if(t.isBlank())
                    continue;
                map.get(_feature).add(t.strip());
            }
        }
        this.dict = map;
        return map;
    }

    public Set<String> getFeatureContains(String tag){
        Set<String> features = new HashSet<>();

        for(String f : dict.keySet()){
            if(dict.get(f).contains(tag)){
                features.add(f);
            }
        }
        return features;
    }

    public Set<String> getEitherCommon(String t1,String t2){
        Set<String> s1 = getFeatureContains(t1);
        Set<String> s2 = getFeatureContains(t2);
        Set<String> result = new HashSet<>();
        s1.addAll(s2);
        return s1;
    }

    public Set<String> getContainsAll(String t1,String t2){
        Set<String> s1 = getFeatureContains(t1);
        Set<String> s2 = getFeatureContains(t2);
        Set<String> result = new HashSet<>();
        for(String s : s1){
            if(s2.contains(s))
                result.add(s);
        }
        return result;
    }

    public Set<List<String>> getWhichHaveCommon() {
        Set<List<String>> pairs = new HashSet<>();
        for (String outer : dict.keySet()) {
            for (String inner : dict.keySet()) {
                if (outer.compareTo(inner) < 0) {
                    if (haveCommon(dict.get(outer), dict.get(inner))) {
                        pairs.add(List.of(outer, inner));
                    }
                }
            }
        }
        return pairs;
    }


    public boolean haveCommon(Set<String> s1,Set<String> s2){
        for(String s : s1)
            if(s2.contains(s))
                return true;
        return false;
    }

    public static void main(String[] args){
        String test = "feature1 : string categorical\nfeature2 : numeric\nfeature3 : numeric categorical\nfeature4 : string splittable\nfeature5 : string";
        TagSearch search = new TagSearch(test);


        System.out.println(
                search.getWhichHaveCommon()
        );

    }
}

