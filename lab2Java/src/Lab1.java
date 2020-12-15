import java.util.Scanner;
public class Lab1 {
    public static void main(String[] args) {
        double x1,y1,z1,x2,y2,z2,x3,y3,z3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Х первой точки");
        x1 = scanner.nextDouble();
        System.out.println("Введите Y первой точки");
        y1 = scanner.nextDouble();
        System.out.println("Введите Z первой точки");
        z1 = scanner.nextDouble();
        System.out.println("Введите Х второй точки");
        x2 = scanner.nextDouble();
        System.out.println("Введите Y второй точки");
        y2 = scanner.nextDouble();
        System.out.println("Введите Z второй точки");
        z2 = scanner.nextDouble();
        System.out.println("Введите Х третьей точки");
        x3 = scanner.nextDouble();
        System.out.println("Введите Y третьей точки");
        y3 = scanner.nextDouble();
        System.out.println("Введите Z третьей точки");
        z3 = scanner.nextDouble();
        Point3d p1 = new Point3d(x1,y1,z1);
        Point3d p2 = new Point3d(x2,y2,z2);
        Point3d p3 = new Point3d(x3,y3,z3);
        if (Point3d.compar(p1,p2)==false || Point3d.compar(p1,p3)==false || Point3d.compar(p3,p2)==false) {
            System.out.println(computeArea(p1,p2,p3));
        }
        else  {
            System.out.println("Точки совпадают");
        }
    }
    public static double computeArea(Point3d var1, Point3d var2, Point3d var3) {
        double a = var1.distanceTo(var2);
        double b = var2.distanceTo(var3);
        double c = var3.distanceTo(var1);
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
