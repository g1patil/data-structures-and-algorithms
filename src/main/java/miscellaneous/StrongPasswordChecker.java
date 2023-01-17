package miscellaneous;
/**
 * A password is considered strong if the below conditions are all met:
 *
 * It has at least 6 characters and at most 20 characters.
 * It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It does not contain three repeating characters in a row (i.e., "...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * Given a string password, return the minimum number of steps required to make password strong. if password is already strong, return 0.
 *
 * In one step, you can:
 *
 * Insert one character to password,
 * Delete one character from password, or
 * Replace one character of password with another character.
 *
 *
 * Example 1:
 *
 * Input: password = "a"
 * Output: 5
 * Example 2:
 *
 * Input: password = "aA1"
 * Output: 3
 * Example 3:
 *
 * Input: password = "1337C0d3"
 * Output: 0
 *
 *
 * */
public class StrongPasswordChecker {

    int checkNumberOfChar(String input,int min,int max){
        return input.length() > min && input.length()  < max ? 0 : 1;
    }

    int checkCasing(String input){
        return input.replaceAll("[^0-9]", "").length() > 0
                && input.replaceAll("[^a-z]", "").length() > 0
                && input.replaceAll("[^A-Z]", "").length() > 0 ?
                0 : 1;
    }

    int checkRepeatingSeq(String input){
        int count = 0;
        char[] inputChar = input.toCharArray();
        for(int index = 0 ; index < inputChar.length -1 ; index ++){
            if (inputChar[index] == inputChar[index+1]) {
                count++;
            } else {
                count = 0;
            }
        }

        return count == 2 ? 1 : 0;
    }

    int checkPassword(String password){
        return checkRepeatingSeq(password) + checkCasing(password) + checkNumberOfChar(password,3,20);
    }
    public static void main(String[] args) {
        System.out.println(new StrongPasswordChecker().checkPassword("@#"));
    }
}
