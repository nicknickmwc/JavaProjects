import javafx.geometry.Point2D;

public class Point3d extends Point2d {
    private double zCoord;
    public Point3d (double x, double y, double z) {
        super(x,y);
        zCoord = z;
    }
    public Point3d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        super();
        zCoord=0;
    }
    public double getZ() {
        return zCoord;
    }
    private void setZ(double val){
        zCoord=val;
    }
    public static boolean compar(Object obj1, Object obj2) {
        return obj1==obj2;
    }
    public double distanceTo(Point3d var1) {
        return Double.parseDouble(String.format("%.2f",Math.sqrt(Math.pow(var1.getX()-this.getX(),2)+Math.pow(var1.getY()-this.getY(),2)+Math.pow(var1.getZ()-this.getZ(),2))).replace(',','.'));
    }
    public static void main(String[] args) {
        Point3d myPoint = new Point3d();
        Point3d myOtherPoint = new Point3d(0,0,0);
        Point3d aThirdPoint = new Point3d();
        Point3d myOtherPoint2 = new Point3d(3,3,3);
        System.out.println(myOtherPoint.distanceTo(myOtherPoint2));
    }
}
