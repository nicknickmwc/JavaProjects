import java.net.MalformedURLException;
import java.net.URL;

public class UrlDepthPair {
    public String url;
    public int depth;
    public URL realUrl;

    public UrlDepthPair (String url, int depth) throws MalformedURLException // сообщаем что данный метод может генерировать исключение, которое он не обрабатывает
    {
        realUrl = new URL(url);
        this.url = url;
        this.depth = depth;
    }
}