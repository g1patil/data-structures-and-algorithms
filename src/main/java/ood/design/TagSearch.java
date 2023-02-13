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
        String[] strings = input.split(" ");

        for(String feature : strings){
            String[] featureValue = feature.split(":");
            map.put(featureValue[0],new HashSet<>());
            map.get(featureValue[0]).addAll(List.of(featureValue[1].split(",")));
        }
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

    public Set<String> getTwoCommon(String t1,String t2){
        Set<String> s1 = getFeatureContains(t1);
        Set<String> s2 = getFeatureContains(t2);
        Set<String> result = new HashSet<>();
        for(String s : s1){
            if(s2.contains(s))
                result.add(s);
        }

        return result;
    }

    public static void main(String[] args){
        TagSearch search = new TagSearch("FeatureA:tag1,tag2 FeatureB:tag3,tag4 FeatureC:tag3,tag4 FeatureD:tag1,tag3 FeatureE:tag1");
        System.out.println(
                search.getTwoCommon("tag1","tag3")
        );

        search.tagSet.stream().forEach(
                s -> System.out.println(
                        search.getFeatureContains(s)
                )
        );
    }
}

