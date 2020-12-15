public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;
    public Point3d (double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
    public Point3d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0,0);
    }
    public double getX() {
        return xCoord;
    }
    public double getY() {
        return yCoord;
    }
    public double getZ() {
        return zCoord;
    }
    public void setX(double val){
        xCoord=val;
    }
    public void setY(double val){
        yCoord=val;
    }
    public void setZ(double val){
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
