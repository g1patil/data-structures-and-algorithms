package multithreading;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author https://leetcode.com/odanylevskyi/
 *
 * 1242. Web Crawler Multithreaded
 *
 * Adding the code from one of the solutions posted to learn something new.
 * This code is not my work. Just code reference for learing :-)
 * Link to original auther link in the @auther section.
 */
public class WebCrawler {

    Set<String> seen = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());
    Set<String> resultList = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        seen.add(startUrl);
        resultList.add(startUrl);
        List<Thread> threadList = new LinkedList<>();

        for(String link: htmlParser.getUrls(startUrl)) {
            if (isHostnameEquals(startUrl, link) && !seen.contains(link)) {
                Thread th = new Thread(() -> {
                    crawl(link, htmlParser);
                });
                threadList.add(th);
                th.start();
            }
        }
        for(Thread thread: threadList) {
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new LinkedList<>(resultList);
    }

    public boolean isHostnameEquals(String origin, String child) {
        try {
            URL originUrl = new URL(origin), childUrl = new URL(child);
            return originUrl.getHost().equals(childUrl.getHost());
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
