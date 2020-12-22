package miscellaneous;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of coordinates (pair of two digits),
 * return the number of rectangle combination those can
 * formed from these coordinates
 *
 * */
public class NumberOfRectangles {

    int getDiagonals(List<Coordinate> coordinateList, final int x, final int y){
        return (int) coordinateList
                .stream()
                .filter(c -> c.x < x && c.y < y)
                .count();
    }
    private int getNumberOfRectangles(List<Coordinate> coordinateList){
        return coordinateList.stream().mapToInt(
                coordinate -> getDiagonals(coordinateList, coordinate.x, coordinate.y))
                .sum();
    }

    /**
     *
     *    *__*__*__*__*
     *    *__*__*__*__*
     *    *__*__*__*__*
     * */
    @Test
    public void test1(){
        Coordinate c1 = new Coordinate(0,0);
        Coordinate c2 = new Coordinate(1,0);
        Coordinate c3 = new Coordinate(2,0);
        Coordinate c4 = new Coordinate(3,0);
        Coordinate c5 = new Coordinate(4,0);

        Coordinate c6 = new Coordinate(0,1);
        Coordinate c7 = new Coordinate(1,1);
        Coordinate c8 = new Coordinate(2,1);
        Coordinate c9 = new Coordinate(3,1);
        Coordinate c10 = new Coordinate(4,1);

        Coordinate c11 = new Coordinate(0,2);
        Coordinate c12 = new Coordinate(1,2);
        Coordinate c13 = new Coordinate(2,2);
        Coordinate c14 = new Coordinate(3,2);
        Coordinate c15 = new Coordinate(4,2);

        List<Coordinate> coordinates = new ArrayList<>();

        coordinates.add(c1);
        coordinates.add(c2);
        coordinates.add(c3);
        coordinates.add(c4);
        coordinates.add(c5);
        coordinates.add(c6);
        coordinates.add(c7);
        coordinates.add(c8);
        coordinates.add(c9);
        coordinates.add(c10);
        coordinates.add(c11);
        coordinates.add(c12);
        coordinates.add(c13);
        coordinates.add(c14);
        coordinates.add(c15);

        System.out.println(getNumberOfRectangles(coordinates));
    }

    /**
     *
     *      *__*__*
     *      *__*__*
     * */
    @Test
    public void test2(){
        Coordinate c1 = new Coordinate(0,0);
        Coordinate c3 = new Coordinate(2,0);
        Coordinate c5 = new Coordinate(4,0);

        Coordinate c6 = new Coordinate(0,1);
        Coordinate c8 = new Coordinate(2,1);
        Coordinate c10 = new Coordinate(4,1);

        List<Coordinate> coordinates = new ArrayList<>();

        coordinates.add(c1);
        coordinates.add(c3);
        coordinates.add(c5);
        coordinates.add(c6);
        coordinates.add(c8);
        coordinates.add(c10);

        System.out.println(getNumberOfRectangles(coordinates));
    }
}

