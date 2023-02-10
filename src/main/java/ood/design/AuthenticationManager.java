package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * 1797. Design Authentication Manager
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class AuthenticationManager {

    private final int ttl;
    private final Map<String, Integer> tokens;

    public AuthenticationManager(int timeToLive){
        this.ttl = timeToLive;
        tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime){
        tokens.put(tokenId, ttl+currentTime);
    }

    public void renew(String tokenId, int currentTime){
        if(tokens.containsKey(tokenId) && tokens.get(tokenId) <= currentTime)
            return;
        tokens.put(tokenId, currentTime+ttl);
    }

    public int countUnexpiredTokens(int currentTime){
        int count = 0;

        for(String token : tokens.keySet()) {
            if(tokens.get(token) > currentTime)
                count++;
        }
        return count;
    }

    public static void main(String[] args){
        AuthenticationManager obj = new AuthenticationManager(28);
        obj.countUnexpiredTokens(2);
        obj.renew("xokiw", 6);
        obj.generate("ofn", 7);
        obj.renew("dses", 15);
        System.out.println(
                obj.countUnexpiredTokens(17)
        );
        obj.renew("ofzu", 19);
        obj.generate("dses", 20);
        obj.countUnexpiredTokens(23);
        obj.countUnexpiredTokens(27);
        obj.countUnexpiredTokens(30);

    }
}
