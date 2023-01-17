package strings;

import matrix.MatrixUtility;

/**
 * @author g1patil
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

    /**
     * Builds the transition table for the given pattern
     * */
    private void buildTransitionTable(){
        for (int STATE = 0; STATE < PATTERN_LENGTH + 1; STATE++) {
            for (int CHAR = 97; CHAR < 101 ; CHAR++) {
                transitionTable[STATE][CHAR] = getNextState(STATE , CHAR );
            }
        }
    }

    /**
     * Returns the next state for the given char based on the current state
     * @param currentState current state in the pattern
     * @param character current character
     * */
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

    /**
     * Solves the given pattern input string
     * @param inputText input string text
     * */
    private int solvePattern(String inputText){
        this.buildTransitionTable();
        MatrixUtility.print(this.transitionTable , 97 , 101 );
        int currentState = 0 , charIndex = 0 ;
        while ( charIndex < inputText.length()){
            currentState = this.transitionTable[currentState][ inputText.charAt(charIndex)];
            if ( currentState == PATTERN_LENGTH) {
                System.out.println("We found the match");
                System.out.println( "Pattern present at index " + (charIndex- 1  - PATTERN_LENGTH) );
            }
            System.out.print( currentState  + " " );
            charIndex ++ ;
        }

        return charIndex ;
    }

    /**
     * Main driver function
     * */
    public static void main(String[] args) {
        FiniteAutomata finiteAutomata = new FiniteAutomata("bada" );
        finiteAutomata.solvePattern("aababadaba");
    }
}
