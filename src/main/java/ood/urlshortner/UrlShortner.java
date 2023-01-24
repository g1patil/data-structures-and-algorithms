package ood.urlshortner;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * My attempt for url shortening OOD question
 * */
public interface UrlShortner {
    String shorten(String url);
    String shorten(String url, String passord);
    String expand(String shortedUrl, String password);
}

class UrlShortnerImpl implements UrlShortner{

    private final Map<String,String> database = new HashMap<>();
    private static final String DOMAIN = "https://url.com/";

    @Override
    public String shorten(String url){
        String[] uuids =  UUID.randomUUID().toString().split("-");
        String key = uuids[ new Random().nextInt(uuids.length)];
        database.put( key , url );
        return DOMAIN + key;
    }

    @Override
    public String shorten(String url, String passord){
        String[] uuids =  UUID.randomUUID().toString().split("-");
        String key = uuids[ new Random().nextInt(uuids.length)];
        PasswordService.getInstance().addPassword(key,passord);
        database.put( key , url );
        return DOMAIN + key;
    }

    @Override
    public String expand(String shortedUrl, String password){
        String key = shortedUrl.replace(DOMAIN, "");
        if(PasswordService.getInstance().validatePassword(key,password))
            return null;
        return database.get(key);
    }

    @Test
    public void test(){
        String shortened = shorten("https://google.com/testafsdfasdf/asdfasdfasdfasf");
        System.out.println(shortened);

    }
}

class PasswordService {

    private Map<String,String> passwordStorage = new HashMap<>();
    private static PasswordService passwordService = new PasswordService();

    private PasswordService(){}

    public static PasswordService getInstance(){
        return passwordService;
    }

    public void addPassword(final String key , final String password){
        getInstance().passwordStorage.put(key,password);
    }

    public boolean validatePassword(final String _password , final String key){
        return passwordStorage.containsKey(key) && passwordStorage.get(key).equals(_password);
    }


}
