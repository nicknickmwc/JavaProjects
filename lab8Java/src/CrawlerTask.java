import java.net.MalformedURLException;
import java.util.LinkedList;

public class CrawlerTask implements Runnable {
    public UrlDepthPair depthPair;
    public UrlPool pool;


    public CrawlerTask (UrlPool newPool) {
        pool = newPool;
    }

    public void run() {
        depthPair = pool.get(); // получение пары из пула, ожидая в случае, если пара не будет сразу доступна.
        int depth = depthPair.depth;
        LinkedList<UrlDepthPair> linksList = null;
        linksList = Crawler.getAllLinks(depthPair.realUrl, depth); //
        for (UrlDepthPair newURL : linksList) {
            UrlDepthPair newDepthPair = null;
            try {
                newDepthPair = new UrlDepthPair(newURL.url, depth + 1);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            pool.put(newDepthPair);
        }
    }
}