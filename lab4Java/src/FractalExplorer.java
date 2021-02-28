import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
public class FractalExplorer {
    private int displaySize;

    private JImageDisplay display;

    private FractalGenerator fractal;

    private Rectangle2D.Double range;

    public FractalExplorer(int size){
        displaySize = size;
        display = new JImageDisplay(displaySize, displaySize);
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
    }

    public void createAndShowGUI(){
        display.setLayout(new BorderLayout());
        JFrame disFrame = new JFrame("My Fractal");
        disFrame.add(display, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear");

        ResetHandler handler = new ResetHandler();
        clearButton.addActionListener(handler);


        disFrame.add(clearButton, BorderLayout.SOUTH);


        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        disFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        disFrame.pack();
        disFrame.setVisible(true);
        disFrame.setResizable(false);
    }
    private void drawFractal()
    {
        for (int x=0; x<displaySize; x++){
            for (int y=0; y<displaySize; y++){

                double xCoord = fractal.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = fractal.getCoord(range.y,
                        range.y + range.height, displaySize, y);

                int iteration = fractal.numIterations(xCoord, yCoord);

                if (iteration == -1){
                    display.drawPixel(x, y, 0);
                }

                else {
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);

                    display.drawPixel(x, y, rgbColor);
                }

            }
        }

        display.repaint();
    }

    private class ResetHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            fractal.getInitialRange(range);
            drawFractal();
        }
    }

    private class MouseHandler extends MouseAdapter
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
                    range.x + range.width, displaySize, x);

            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
                    range.y + range.height, displaySize, y);


            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }

    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
