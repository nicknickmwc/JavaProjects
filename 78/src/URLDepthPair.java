import java.net.*;

public class URLDepthPair {

    public static void main(String[] args) {
        URLDepthPair myUDP = new URLDepthPair("https://www.berdov.com/works/teorver/integralnaya-teorema-muavra-laplasa/",5);
        System.out.println(myUDP.getDocPath());
        System.out.println(12);
    }

    private int currentDepth;
    private String currentURL;

    public URLDepthPair(String URL, int depth) {
        currentDepth = depth;
        currentURL = URL;
    }

    public String getURL() {
        return currentURL;
    }

    public int getDepth() {
        return currentDepth;
    }

    public String toString() {
        String stringDepth = Integer.toString(currentDepth);
        return stringDepth + '\t' + currentURL;
    }

    public String getDocPath() {
        try {
            URL url = new URL(currentURL);
            return url.getPath();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }

    public String getWebHost() {
        try {
            URL url = new URL(currentURL);
            return url.getHost();
        }
        catch (MalformedURLException e) {
            System.err.println("MalformedURLException: " + e.getMessage());
            return null;
        }
    }


}