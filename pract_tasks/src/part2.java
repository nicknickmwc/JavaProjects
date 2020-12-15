import java.util.Arrays;

public class part2 {
    public static void repeat(String word, int volOfRepeat) {
        String res = "";
        int volOfWord = word.length();
        int x = 0;
        while (volOfWord > 0) {
            for (int i = 0; i < volOfRepeat; i++) {
                res += word.charAt(x);
            }
            volOfWord -= 1;
            x += 1;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        //repeat("pow",3);
        //double[] mass = {3,5,8,2,0,10};
        //System.out.println(differenceMaxMin(mass));
        //int[] mass = {1, 2, 3};
        //System.out.println(cumulativeSum(mass));
        //cumulativeSum(mass);
        //System.out.println(getDecimalPlaces("432.00967"));
        //System.out.println(Fibonacci(12));
        System.out.println(isValid("34545"));
    }

    public static double differenceMaxMin(double[] mass) {
        double min = 1.7 * Math.pow(10, 308);
        double max = -1.7 * Math.pow(10, 308);
        for (int i = 0; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
            }
            if (max < mass[i]) {
                max = mass[i];
            }
        }
        return max - min;
    }

    public static boolean isAvgWhole(double[] mass) {
        double sum = 0;
        for (int i = 0; i < mass.length; i++) {
            sum += mass[i];
        }
        return sum / mass.length - Math.floor(sum / mass.length) == 0;
    }

    public static void cumulativeSum(int[] mass) {
        int sum = 0;
        int elem;
        for (int i = mass.length - 1; i >= 0; i--) {
            for (int z = 0; z < i; z++) {
                sum += mass[z];
            }
            mass[i] += sum;
            System.out.println(mass[i]);
            sum = 0;
        }
    }

    public static int getDecimalPlaces(String numb) {
        int i = 0;
        char s = '.';
        while (numb.charAt(i)!=s) {
            i++;
            if (numb.length()-i==1) {
                return 0;
            }
        }
        return numb.length()-i-1;
    }
    public static int Fibonacci(int numb) {
        int[] seq= new int[numb+1];
        seq[0]=1;
        seq[1]=1;
        for (int i=2; i<=numb; i++) {
            seq[i]=seq[i-1]+seq[i-2];
        }
        return seq[numb];
    }
    public static boolean isValid(String ind) {
        for (int i=0;i<ind.length();i++) {
            if (i>4 || ind.length()<5) {
                return false;
            }
            if (ind.charAt(i)<48 || ind.charAt(i)>57) {
                return false;
            }
        }
        return true;
    }
    public static boolean isStrangePair(String s1, String s2) {
        if (s1.charAt(0)==s2.charAt(s2.length()-1) && s2.charAt(0)==s2.charAt(s1.length()-1)) {
            return true;
        }
        return false;
    }
}
