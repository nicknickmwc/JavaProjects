public class part1 {
    public static void main(String[] args) {
        System.out.println(abcmath(42,5,10));
    }
    public static int remainder(int numerator, int denominator) {
        return  numerator%denominator;
    }
    public static int triArea(int base, int elevation) {
        return (base*elevation)/2;
    }
    public static int animals(int chickens, int cows, int pigs) {
        return chickens*2+cows*4+pigs*4;
    }
    public static boolean profitableGamble(double prob, double prize, double pay) {
        if (prob*prize>pay) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String operation(int N, int a, int b) {
        if (a+b==N) {
            return "added";
        }
        if (a-b==N) {
            return "subtracted";
        }
        if (a/b==N) {
            return "divided";
        }
        if (a*b==N) {
            return "multiplied";
        }
        return "none";
    }
    public static int ctoa(char character) {
        int ascii = character;
        return ascii;
    }
    public static int addUpTo(int num) {
        int sum=0;
        for (int i=1; i<=num;i++) {
            sum+=i;
        }
        return sum;
    }
    public static double nextEdge(int side1, int side2) {
        return Math.floor(Math.sqrt(Math.pow(side1,2)+Math.pow(side2,2)-2*side1*side2*Math.cos(179)));
    }
    public static int sumOfCubes(int[] mass) {
        int sum=0;
        for (int i=0; i< mass.length; i++) {
            sum+=Math.pow(mass[i],3);
        }
        return sum;
    }
    public static boolean abcmath(int a, int b, int c) {
        for (int i=0; i<b;i++) {
            a+=a;
        }
        if (a%c==0) {
            return true;
        }
        else {
            return false;
        }
    }
}
