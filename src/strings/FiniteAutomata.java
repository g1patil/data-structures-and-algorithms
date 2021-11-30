package strings;

import matrix.MatrixUtility;

/**
 * @auther g1patil
 */
public class FiniteAutomata {

    int[][] transitionTable ;
    int PATTERN_LENGTH ;
    String patternString;
    static final int CHAR_COUNT = 256;

    public FiniteAutomata(String _pattern){
        this.patternString = _pattern;
        PATTERN_LENGTH = this.patternString.length();
        this.transitionTable = new int[PATTERN_LENGTH + 1 ][CHAR_COUNT];
    }

    private void buildTransitionTable(){
        for (int STATE = 0; STATE < PATTERN_LENGTH + 1; STATE++) {
            for (int CHAR = 97; CHAR < 100 ; CHAR++) {
                transitionTable[STATE][CHAR] = getNextState(STATE , CHAR );
            }
        }
    }

    private int getNextState(int currentState, int character) {
        if (currentState < PATTERN_LENGTH && patternString.charAt(currentState) == character)
            return currentState + 1 ;

        int p1 = 0 , p2  =  1 ;
        int length = 0 ;

        //create two pointers
        for (p2 = 1; p2 <= currentState -1  ; p2++) {
            if ( patternString.charAt(p1) == patternString.charAt(p2)){
                p1++;
                length ++;
            } else {
                p1 = 0 ;
                length = 0 ;
            }
        }

        //handle the edge case
        if ( patternString.charAt(p1) == character ){
            length++ ;
        } else length = 0;

        if ( length == 0 && patternString.charAt(0) == character)
            return 1 ;
        return length ;
    }

    public static void main(String[] args) {
        FiniteAutomata finiteAutomata = new FiniteAutomata("ababaca" );
        finiteAutomata.buildTransitionTable();
        MatrixUtility.print(finiteAutomata.transitionTable , 97 , 100 );
    }
}
