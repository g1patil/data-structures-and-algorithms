package graph.practice;

import javax.swing.*;
import java.util.Arrays;
import java.util.Comparator;

public class WateringGrass {

    int n , l , w ;
    int[][] inputs;

    public static class Sprinkler{
        double left ,right ;

        Sprinkler(){}

        Sprinkler( double _left , double _right){
            this.left = _left;
            this.right = _right;
        }
    }

    void answer(int[][] ints){
        this.inputs = ints;
        Sprinkler[] sprinklers = new Sprinkler[ints.length];

        for ( int i = 0 ; i < this.inputs.length ; i++){
            double range = Math.sqrt(  inputs[i][1]*inputs[i][1] - (w*w)/4.0 );
            sprinklers[i] = new Sprinkler( inputs[i][0] - range, inputs[i][0] + range);
        }

        Arrays.sort( sprinklers , Comparator.comparingDouble(o->o.left));

        double current = 0, best = 0;
        int ans = 0;

        for( int i = 0; i < n; i++ ) {
            if( sprinklers[i].left <= current ) {
                if( sprinklers[i].right > best )
                    best = sprinklers[i].right;
            }
            else {
                if( best == current || best >= l )
                    break;
                i--;
                current = best;
                ans++;
            }
        }

        if( best != current )
            ans++;

        if( best >= l )
            System.out.println( ans);
        else System.out.println( -1 );

    }
    public static void main(String[] args) {
        int[][] ints = {
               new int[]{5,3},
               new int[]{4,1},
               new int[]{1,2},
               new int[]{7,2},
               new int[]{10,2},
               new int[]{13,3},
               new int[]{16,2},
               new int[]{19,4}
        };

        WateringGrass wg = new WateringGrass();
        wg.n = 8;
        wg.l = 20;
        wg.w = 2 ;

        wg.answer(ints);
    }
}
