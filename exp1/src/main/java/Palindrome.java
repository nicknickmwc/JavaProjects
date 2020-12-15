import java.awt.geom.Point2D;

public class Palindrome {
    public static void main(String[] args) {
            String s = "kayak";
            if (isPalindrome(s)==true) {
                System.out.println(s);
            }
    }
    public static String reverseString(String s) {
        int len = s.length();
        String reverse_s = "";
        int x = len-1;
        for (int i=0; i<len;i++) {
            reverse_s+=s.charAt(x);
            x-=1;
        }
        return reverse_s;
    }
    public static boolean isPalindrome(String s) {
       return s.equals(reverseString(s));
    }
}
