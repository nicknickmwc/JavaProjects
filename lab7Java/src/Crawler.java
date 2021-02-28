import java.net.*;
import java.util.*;
import java.io.*;

public class Crawler {


    public static void main(String[] args) {

        int depth = 0;
        Scanner in = new Scanner(System.in);
        String url = in.next();
        depth = in.nextInt();
        LinkedList<URLDepthPair> pendingURLs = new LinkedList<URLDepthPair>();

        LinkedList<URLDepthPair> processedURLs = new LinkedList<URLDepthPair>();

        URLDepthPair currentDepthPair = new URLDepthPair(url, 0);

        pendingURLs.add(currentDepthPair);

        ArrayList<String> seenURLs = new ArrayList<String>();
        seenURLs.add(currentDepthPair.getURL());

        while (pendingURLs.size() != 0) {

            URLDepthPair depthPair = pendingURLs.pop();
            processedURLs.add(depthPair);
            int myDepth = depthPair.getDepth();
           // System.out.println("+");

            LinkedList<String> linksList = new LinkedList<String>();
            linksList = Crawler.getAllLinks(depthPair);

            if (myDepth < depth) {
                for (int i=0;i<linksList.size();i++) {
                    String newURL = linksList.get(i);
                    if (seenURLs.contains(newURL)) {
                        continue;
                    }
                    else {
                        URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
                        pendingURLs.add(newDepthPair);
                        seenURLs.add(newURL);
                        System.out.println(newDepthPair.getWebHost());
                       // System.out.println("+");
                    }
                }
            }
        }
        Iterator<URLDepthPair> iter = processedURLs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    private static LinkedList<String> getAllLinks(URLDepthPair myDepthPair) {

        LinkedList<String> URLs = new LinkedList<String>();

        Socket sock;

        try {
            sock = new Socket(myDepthPair.getWebHost(), 80);
        }
        catch (UnknownHostException e) {
            System.err.println("UnknownHostException: " + e.getMessage());
            return URLs;
        }
        catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
            return URLs;
        }

        try {
            sock.setSoTimeout(3000);
        }
        catch (SocketException exc) {
            System.err.println("SocketException: " + exc.getMessage());
            return URLs;
        }

        String docPath = myDepthPair.getDocPath();
        String webHost = myDepthPair.getWebHost();

        OutputStream outStream;

        try {
            outStream = sock.getOutputStream();
        }
        catch (IOException exce) {
            System.err.println("IOException: " + exce.getMessage());
            return URLs;
        }

        PrintWriter myWriter = new PrintWriter(outStream, true);

        myWriter.println("GET " + docPath + " HTTP/1.1");
        myWriter.println("Host: " + webHost);
        myWriter.println("Connection: close");
        myWriter.println();

        InputStream inStream;

        try {
            inStream = sock.getInputStream();
        }
        catch (IOException excep){
            System.err.println("IOException: " + excep.getMessage());
            return URLs;
        }
        InputStreamReader inStreamReader = new InputStreamReader(inStream);
        BufferedReader BuffReader = new BufferedReader(inStreamReader);

        while (true) {
            String line;
            try {
                line = BuffReader.readLine();
            }
            catch (IOException except) {
                System.err.println("IOException: " + except.getMessage());
                return URLs;
            }
            if (line == null)
                break;


            int beginIndex = 0;
            int endIndex = 0;
            int index = 0;

            while (true) {

                String URL_INDICATOR = "a href=\"";

                String END_URL = "\"";


                index = line.indexOf(URL_INDICATOR, index);
                if (index == -1)
                    break;

                index += URL_INDICATOR.length();
                beginIndex = index;

                endIndex = line.indexOf(END_URL, index);
                index = endIndex;

                String newLink = line.substring(beginIndex, endIndex);
                URLs.add(newLink);
            }

        }
        return URLs;
    }

}