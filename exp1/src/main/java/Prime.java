public class Prime {

    public static void main(String[] args) {
       // System.out.println("Prime");
        for(int i = 3;i<100;i++) {
            if (IsPrime(i)==true) {
                System.out.println(i);
            }
        }
    }
    public static boolean IsPrime(int n) {
        for(int i = 2; i<n; i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }
}
