package arrays;

import java.net.http.HttpClient;

public class FizzBuzz {
    static String[] fizzBuzz(int number){
        String[] result = new String[number];
        IOUtils

        for (int index = 0 ; index < number;index++){
            int target = index+1;
                boolean isBy3 = (target%3==0);
                boolean isBy5 = (target%5==0);

            if(isBy3 && isBy5){
                result[index] = "FizzBuzz";
            } else if (isBy3){
                result[index] = "Fizz";
            } else if(isBy5){
                result[index] = "Buzz";
            } else {
                result[index] = Integer.toString(target);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();
        String[] answer = fizzBuzz(15);
     for(String s : answer){
        System.out.println(s);
     }
    }
}