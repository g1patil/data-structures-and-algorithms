package regex;

public class RegEx {

    //65. Valid Number
    public boolean validNumber(String string){
//        String regEx = "^[+-]?(\\d+(\\.\\d*)?)(e?[+-]?[0-9]+)";
        String regEx = "^[+-]?([0-9]+(\\.?[0-9]+)?|(\\.\\d+))(e[+-]?\\d+)?";
        return string.matches(regEx);
    }

    /**
     * Task: Write a regular expression which matches a text line
     * if this text line contains either the word "Joe" or the word "Jim" or both.
     * */
    public boolean checkRegEx(String input){
//        String pattern = ".*(Jim|Joe).*";
        String pattern = ".*\\b(Jim|Joe)\\b.*";
        return input.matches(pattern);
    }

    // returns true if the string matches exactly "true" or "True"
    // or "yes" or "Yes"
    public boolean isTrueOrYes(String s){
        return s.matches("([tT]rue)([yY]es)");
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
