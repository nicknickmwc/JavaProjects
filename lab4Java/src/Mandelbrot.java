import java.awt.geom.Rectangle2D;
public class Mandelbrot extends FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int iteration = 0;
        double zreal = 0;
        double znotreal = 0;
        while (iteration < MAX_ITERATIONS && zreal * zreal + znotreal * znotreal < 4)
        {
            double zrealUpdated = zreal * zreal - znotreal * znotreal + x;
            double znotrealUpdated = 2 * zreal * znotreal + y;
            zreal = zrealUpdated;
            znotreal = znotrealUpdated;
            iteration += 1;
        }
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        return iteration;
    }
}
