import java.util.Random;
import java.util.Scanner;
import java.awt.Color;

/**
 * @brief This program implements a basic screen saver application
 * involving shape drawing and animation in a canvas. It uses Java arrays
 * to keep track of the different object's data. It requires that
 * class StdDraw be located in the same source folder to run properly.
 *
 * @author Paul Pauca
 */
public class ScreenSaver {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();
        int numObjects;
        double[] obj_x;
        double[] obj_y;
        double[] obj_rad;
        // Floats (32 bits) are needed for defining colors
        float[] red;
        float[] green;
        float[] blue;

        int i;
        final int STEPS = 1000;

        // The user needs to specify the number of objects they
        // wish to see
        System.out.print("Number of objects desired: ");
        numObjects = kb.nextInt();

        // Create the arrays needed to store the x and y locations
        // of the objects in the screen. Use additional arrays for
        // other needed data (e.g. if the objects are circles or ovals
        // then, you will also need to store the radius of each circle)
        obj_x = new double[numObjects];
        obj_y = new double[numObjects];
        obj_rad = new double[numObjects];
        red = new float[numObjects];
        green = new float[numObjects];
        blue = new float[numObjects];

        // Give each object an initial random position in the 2-dimensional
        // plane. Also give each object random radius and color
        for (int j = 0; j < obj_x.length; j++) {
            obj_x[j] = rand.nextDouble(); // between 0 and 1
            obj_y[j] = rand.nextDouble(); // between 0 and 1
            obj_rad[j] = rand.nextDouble() * 0.05 + 0.01; // radius
            // random red, green and blue make up a new color
            red[j] = rand.nextFloat();
            green[j] = rand.nextFloat();
            blue[j] = rand.nextFloat();
        }


        StdDraw.enableDoubleBuffering();

        // Set the size and scale of the drawing canvas
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(0, 1);

        // Loop STEPS number of times and at each iteration do:
        for (int k = 0; k < STEPS; k++) {

            // print the objects' data arrays to the console
            for (int j = 0; j < obj_x.length; j++) {
                System.out.printf("Circle %d: (%.4f, %.4f), radius = %.4f\n",j+1, obj_x[j], obj_y[j], obj_rad[j]);
            }
            System.out.println();


            // Draw the objects in the canvas
            for (int j = 0; j < obj_x.length; j++) {
                StdDraw.setPenColor(new Color(red[j], green[j], blue[j]));
                StdDraw.filledCircle(obj_x[j], obj_y[j], obj_rad[j]);
            }
            StdDraw.setPenColor(Color.blue);
            StdDraw.text(0.5, 0.02, "Step: " + k);
            StdDraw.show();
            StdDraw.pause(100);  // Pause for 100 milliseconds
            StdDraw.clear();  // Then clear the canvas

            // Move the objects by changing their array data
            for (int j = 0; j < obj_x.length; j++) {
                obj_x[j] = obj_x[j] + rand.nextDouble() * 0.02 - 0.01;
                obj_y[j] = obj_y[j] + rand.nextDouble() * 0.02 - 0.01;
                //obj_y[j] += 0.01;
            }

        }

    }

}
