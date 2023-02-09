package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;

/**
 * 2353. Design a Food Rating System
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class FoodRatings {

    private Map<String, TreeMap<Integer, TreeSet<String>>> map ;
    private final Map<String, String> foodCousineMap ;
    private final Map<String, Integer> foodRatingMap ;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        int length = foods.length;
        foodCousineMap = new HashMap<>();
        foodRatingMap = new HashMap<>();

        for(int i = 0; i < length; i++) {
            foodCousineMap.put(foods[i],cuisines[i]);
            foodRatingMap.put(foods[i],  ratings[i]);

            map.putIfAbsent(cuisines[i] , new TreeMap<>(Comparator.reverseOrder()));
            map.get(cuisines[i]).putIfAbsent( ratings[i],new TreeSet<>());
            map.get(cuisines[i]).get( ratings[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodRatingMap.get(food);
        String cousine = foodCousineMap.get(food);

        map.get(cousine).get(oldRating).remove(food);
        if(map.get(cousine).get(oldRating).isEmpty())
            map.get(cousine).remove(oldRating);
        map.get(cousine).putIfAbsent(newRating,new TreeSet<>());
        map.get(cousine).get(newRating).add(food);
        foodRatingMap.put(food,newRating);
    }

    public String highestRated(String cuisine) {
        int highestRating = map.get(cuisine).keySet().stream().findFirst().get();
        return map.get(cuisine).get(highestRating).first();
    }

    public static void main(String[] args){
        FoodRatings obj = new FoodRatings(new String[] {"biihw"}, new String[] {"okxsrcqn"}, new int[] {13});
        obj.changeRating("biihw", 9);
        obj.changeRating("biihw", 6);


    }
}
