/**
 * @author Anubhab
 * @reference https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
 */

// Importing necessary classes
import java.util.Random;
import java.io.Serializable;

public class Pi implements Task<Double>, Serializable {

    private static final long serialVersionUID = 227L;

    /** Number of random points considered by the algorithm */
    private final int randomPoints;
    
    /**
     * Construct a task to calculate pi with specified number of random points
     * precision.
     */
    public Pi(int randomPoints) {
        this.randomPoints = randomPoints;
    }

    /**
     * Calculate pi.
     */
    public Double execute() {
        return computePi(randomPoints);
    }

    /**
     * Compute the value of pi to the specified number of digits after the 
     * decimal point using Monte Carlo technique.
     */
	public static Double computePi(int randomPoints) {
        double rand_x, rand_y, origin_dist;
        Double pi = 0.0;
        int circle_points = 0, square_points = 0;
      
        Random rd = new Random();
      
        for (int i = 0; i < randomPoints; i++) {
      
            // Randomly generated x and y values
            rand_x = rd.nextDouble();
            rand_y = rd.nextDouble();
      
            // Distance between (x, y) from the origin
            origin_dist = rand_x * rand_x + rand_y * rand_y;
      
            // Checking if (x, y) lies inside the defined circle with radius = 1
            if (origin_dist <= 1)
                circle_points++;
      
            // Total number of points generated
            square_points++;
        }
        // Final Estimated Value
        pi =  (double)(4 * circle_points) / square_points;
        System.out.println("Calculated value of Pi using Monte Carlo approach.");
        return pi;
    }
    
}