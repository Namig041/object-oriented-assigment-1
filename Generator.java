/*
 * Name: Namig Amralizada
 * Student ID: 14042
 * Project: Random Number Generator Analysis
 * Class: [Object Oriented Analy.&Design (CSCI-3612 - 20964)]
 * Date: [09.02.2026]
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    // attributes
    private static final int JAVA_RANDOM = 1;
    private static final int MATH_RANDOM = 2;
    private static final int THREAD_LOCAL_RANDOM = 3;

    // Creates and returns an ArrayList of n random numbers
    public ArrayList<Double> populate(int n, int randNumGen) {
        ArrayList<Double> values = new ArrayList<>();

        // OBJECT INSTANTIATION
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            double value = 0.0;

            if (randNumGen == JAVA_RANDOM) {
                value = rand.nextDouble();
            } else if (randNumGen == MATH_RANDOM) {
                value = Math.random();
            } else if (randNumGen == THREAD_LOCAL_RANDOM) {
                value = ThreadLocalRandom.current().nextDouble();
            }

            values.add(value);
        }

        return values;
    }

    /*
     * Calculates n, mean, sample standard deviation, min, and max
     * Returns results in the order:
     * [n, mean, stddev, min, max]
     */
    public ArrayList<Double> statistics(ArrayList<Double> randomValues) {
        ArrayList<Double> results = new ArrayList<>();

        int n = randomValues.size();
        double sum = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double v : randomValues) {
            sum += v;
            if (v < min) min = v;
            if (v > max) max = v;
        }

        double mean = sum / n;

        double varianceSum = 0.0;
        for (double v : randomValues) {
            varianceSum += Math.pow(v - mean, 2);
        }

        double stddev = Math.sqrt(varianceSum / (n - 1)); // sample std dev

        results.add((double) n);
        results.add(mean);
        results.add(stddev);
        results.add(min);
        results.add(max);

        return results;
    }

    // Displays results in tabular format
    public void display(ArrayList<Double> results, boolean headerOn) {

        // ACCESSIBILITY EXAMPLE: public method
        if (headerOn) {
            System.out.printf("%-6s %-10s %-10s %-10s %-10s%n",
                    "n", "Mean", "StdDev", "Min", "Max");
            System.out.println("------------------------------------------------");
        }

        System.out.printf("%-6.0f %-10.4f %-10.4f %-10.4f %-10.4f%n",
                results.get(0),
                results.get(1),
                results.get(2),
                results.get(3),
                results.get(4));
    }

    // Executes the full experiment
    public void execute() {
        int[] sampleSizes = {10, 100, 1000};
        int[] generators = {JAVA_RANDOM, MATH_RANDOM, THREAD_LOCAL_RANDOM};

        for (int gen : generators) {
            System.out.println("\nRandom Generator: " +
                    (gen == 1 ? "java.util.Random" :
                            gen == 2 ? "Math.random()" :
                                    "ThreadLocalRandom"));

            boolean headerPrinted = false;

            for (int n : sampleSizes) {
                ArrayList<Double> data = populate(n, gen);
                ArrayList<Double> stats = statistics(data);
                display(stats, !headerPrinted);
                headerPrinted = true;
            }
        }
    }

    // main  method
    public static void main(String[] args) {
        Generator g = new Generator();
        g.execute();
    }
}