package miscellaneous;
import java.util.*;

/**
 * @author jivanpatil
 * Code to build intervals from given two set.
 * */
public class Intervals {

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    /**
     * Checks whether from the provided intervals, if the interval begins first then other.
     * @param intervalOne first integer interval
     * @param intervalTwo second integer interval
     * @return true , if first interval completely covers the second interval
     * or first interval contains the start of the second interval
     * false , if second interval starts before first one
     *
     * */
    public boolean beginsFirst(final Integer[] intervalOne, final Integer[] intervalTwo){
        int oneStart = intervalOne[START_INDEX], oneEnd = intervalOne[END_INDEX];
        int twoStart = intervalTwo[START_INDEX], twoEnd = intervalTwo[END_INDEX];

        return (oneStart < twoStart && oneEnd > twoEnd) ||
                (oneStart < twoEnd && twoEnd < oneEnd);

    }

    /**
     * Merges the two overlapping intervals
     * @param firstInterval first integer interval
     * @param secondInterval second integer interval
     * @return combined interval of first and second , if two overlap, NULL otherwise
     * */
    private Integer[] mergeIntervals(Integer[] firstInterval,Integer[] secondInterval){
        int firstStart = firstInterval[START_INDEX], firstEnd = firstInterval[END_INDEX];
        int secondStart = secondInterval[START_INDEX],secondEnd = secondInterval[END_INDEX];

        if( !(firstEnd < secondStart || secondEnd < firstStart) ){
            return new Integer[]{Math.min(firstStart,secondStart) , Math.max(firstEnd,secondEnd)};
        }
        return null;
    }

    /**
     * Given two intervals, include and exclude, builds the new intervals from them.
     * Removes the intervals exclude from include and builds new set of intervals
     * @param include the intervals from which the exclude with be removed.
     * @param exclude the intervals which are needs to be removed
     * @return include interval with exclude interval removed from it.
     * */

    private List<Integer[]> buildInterval(final Integer[] include,final Integer[] exclude){

        List<Integer[]> result = new ArrayList<>();

        int includeStart = include[START_INDEX], includeEnd = include[END_INDEX];
        int excludeStart = exclude[START_INDEX],excludeEnd = exclude[END_INDEX];

        if(includeEnd <  excludeStart || excludeEnd < includeStart){result.add(include);return result;}

        if(includeStart == excludeStart && includeEnd == excludeEnd){return List.of();}

        if( includeStart <= excludeStart){

            if(includeStart != excludeStart){
                Integer[] first = {includeStart,excludeStart-1};
                result.add(first);
            }

            if( excludeEnd < includeEnd){
                Integer[] second = {excludeEnd+1,includeEnd};
                result.add(second);
            }
            return result;
        }

        if (excludeStart < includeStart){
            Integer[] first = {excludeEnd+1,includeEnd};
            result.add(first);
        }

        return result;
    }

    /**
     * @param exclude exclude intervals
     * @param include array of include intervals
     * @return merged intervals
     * */
    public List<Integer[]> mergeIntervals(List<Integer[]> include, List<Integer[]> exclude){
        int includeFlag = START_INDEX;
        int excludeFlag = START_INDEX;

        if(isInputValid(include) || isInputValid(exclude)){
            throw new InvalidInputException("Invalid input provided");
        }

        if( !include.isEmpty()) { include.sort(Comparator.comparingInt(o -> o[0])); }
        if( !exclude.isEmpty()) { exclude.sort(Comparator.comparingInt(o -> o[0])); }

        mergeOverlappingIntervals(include);

        while ( !include.isEmpty() && !exclude.isEmpty() && includeFlag < include.size()){
            List<Integer[]> newIntervals = buildInterval( include.get(includeFlag), exclude.get(excludeFlag));

            if(beginsFirst(include.get(includeFlag),exclude.get(excludeFlag))){
                exclude.remove(excludeFlag);
            }

            include.remove(includeFlag);
            include.addAll(includeFlag, newIntervals);

            includeFlag++;
        }
        return include;
    }

    /**
     * Merges the overlapping intervals from the given list of intervals.
     * @param intervalList list of integer intervals
     * */
    public void mergeOverlappingIntervals(List<Integer[]> intervalList){
        int flagIndex = START_INDEX;

        while ( flagIndex < intervalList.size()-1 ){
            Integer[] mergedInterval = mergeIntervals(intervalList.get(flagIndex),intervalList.get(flagIndex+1));
            if(mergedInterval != null){
                intervalList.remove(flagIndex);
                intervalList.remove(flagIndex);
                intervalList.add(flagIndex, mergedInterval);
            } else {
                flagIndex++;
            }
        }
    }

    public boolean isInputValid(List<Integer[]> interval){
        return interval.stream().filter(i -> i.length == 1).count() == 1;
    }

}


class InvalidInputException extends RuntimeException{
    public InvalidInputException(final String errorMessage){
        super(errorMessage);
    }
}
