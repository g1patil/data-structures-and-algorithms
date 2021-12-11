package miscellaneous;

import org.junit.jupiter.api.Test;

public class JavaMath {

    private double getRadian(final double height , final double base){
        return Math.atan2( height , base );
    }

    private int getLowerCounts(final double[] radians , final double lowerBound ,final double upperBound){
        int answer = 0;
        for ( double d : radians){
            if ( d <= upperBound && d >= lowerBound ){
                answer ++ ;
            }
        }
        return answer;
    }

    private int getNumberOfVisiblePoints(double[][] points ,  final double radianInput ){
        int answer = 0;
        double[] radians = new double[points.length];

        for ( double[] point : points){
            if ( getRadian( point[1] , point[0]) < radianInput){
                answer++ ;
            }
        }

        for ( int index = 0 ; index < points.length ; index ++){
            radians[index] = getRadian( points[index][1] , points[index][0]);
        }
        int r = 0 ;
        for (int i = 0; i < radians.length; i++) {
            r = Math.max( getLowerCounts( radians , radians[i] , radians[i] + radianInput ) , r );
        }
        return r;
    }

    private double[] getOffset(final double x , final double y ){
        if ( x > 0 && y > 0 ){ return new double[]{ -x ,-y} ; }
        if ( x > 0 && y < 0 ){ return new double[]{ x ,-y} ; }
        if ( x < 0 && y < 0 ){ return new double[]{ x, y } ; }
        if ( x < 0 && y > 0 ){ return new double[]{ -x, y } ; }

        return new double[]{ 0 , 0 } ;
    }
    @Test
    public void test(){
        double[][] doubles = new double[][]{
                new double[]{3,2},
                new double[]{3.8,2.8},
                new double[]{4.2,2.2},
                new double[]{2,3},
                new double[]{3,4}
        };
        System.out.println(  this.getNumberOfVisiblePoints(doubles , Math.PI/4 ));
    }
}
