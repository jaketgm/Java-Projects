import java.util.Random;
import java.util.Arrays;

/******************************************************************************
 * @author Jake Brockbank
 * Sep Oct. 15th, 2023
 * Main method which tests Quick Find, Quick Union, Weighted Quick Union,
 * and Weighted Quick Union with Path Compression algorithms, tests this for
 * 20000 integers, as well as calulating the respective time each algorithm
 * takes to run on this large set of data. Whilst also testing average 
 * connections via union methods.
******************************************************************************/
public class Main 
{
    public static void main(String[] args) 
    {
        int numberOfTests = 20;
        int size = 20000;

        long[] quickFindTimes = new long[numberOfTests];
        long[] quickUnionTimes = new long[numberOfTests];
        long[] weightedQuickUnionTimes = new long[numberOfTests];
        long[] weightedQuickUnionPathCompressionTimes = new long[numberOfTests];

        int[] quickFindConnectedCounts = new int[numberOfTests];
        int[] quickUnionConnectedCounts = new int[numberOfTests];
        int[] weightedQuickUnionConnectedCounts = new int[numberOfTests];
        int[] weightedQuickUnionPathCompressionConnectedCounts = new int[numberOfTests];

        for (int test = 0; test < numberOfTests; test++) 
        {
            QuickFind quickFind = new QuickFind(size);
            QuickUnion quickUnion = new QuickUnion(size);
            WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(size);
            WeightedQuickUnionPathCompression weightedQuickUnionPathCompression = new WeightedQuickUnionPathCompression(size);
            Random random = new Random();

            long quickFindStart = System.nanoTime();
            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                quickFind.union(p, q);
            }

            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                quickFind.isConnected(p, q);
            }
            // Calculates the elapsed time taken to perform our set of operations
            quickFindTimes[test] = System.nanoTime() - quickFindStart;

            long quickUnionStart = System.nanoTime();
            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                quickUnion.union(p, q);
            }

            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                quickUnion.isConnected(p, q);
            }
            quickUnionTimes[test] = System.nanoTime() - quickUnionStart;

            long weightedQuickUnionStart = System.nanoTime();
            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                weightedQuickUnion.union(p, q);
            }

            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                weightedQuickUnion.isConnected(p, q);
            }
            weightedQuickUnionTimes[test] = System.nanoTime() - weightedQuickUnionStart;

            long weightedQuickUnionPathCompressionStart = System.nanoTime();
            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                weightedQuickUnionPathCompression.union(p, q);
            }

            for (int i = 0; i < size; i++) 
            {
                int p = random.nextInt(size);
                int q = random.nextInt(size);
                weightedQuickUnionPathCompression.isConnected(p, q);
            }
            weightedQuickUnionPathCompressionTimes[test] = System.nanoTime() - weightedQuickUnionPathCompressionStart;

            // Calculate connected components for each class
            quickFindConnectedCounts[test] = countConnectedComponents(quickFind.getIntegerArray());
            quickUnionConnectedCounts[test] = countConnectedComponents(quickUnion.getParentArray());
            weightedQuickUnionConnectedCounts[test] = countConnectedComponents(weightedQuickUnion.getParentArray());
            weightedQuickUnionPathCompressionConnectedCounts[test] = countConnectedComponents(weightedQuickUnionPathCompression.getParentArray());
        }

        // Print timings and connected components
        printTimings(quickFindTimes, "QuickFind");
        printTimings(quickUnionTimes, "QuickUnion");
        printTimings(weightedQuickUnionTimes, "WeightedQuickUnion");
        printTimings(weightedQuickUnionPathCompressionTimes, "WeightedQuickUnionPathCompression");

        printConnectedCounts(quickFindConnectedCounts, "QuickFind");
        printConnectedCounts(quickUnionConnectedCounts, "QuickUnion");
        printConnectedCounts(weightedQuickUnionConnectedCounts, "WeightedQuickUnion");
        printConnectedCounts(weightedQuickUnionPathCompressionConnectedCounts, "WeightedQuickUnionPathCompression");
    }

    /******************************************************************************
     * Method: countConnectedComponents: Increments a count whenever a connection
     * has been made. Used to test 20 average connections amongst the set of
     * algorithms.
     *
     * Input: int[] array.
     *
     * Output: The number of connected components.
     *
    ******************************************************************************/
    public static int countConnectedComponents(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) 
        {
            if (i == array[i]) 
            {
                count++;
            }
        }
        return count;
    }

    /******************************************************************************
     * Method: printTimings: Prints out the timings for the given algorithms. 
     * Additionally, iterates through the array of times and prints each timing 
     * along with a test number. For each timing, it prints the test number 
     * (starting from 1) and the time in nanoseconds. For example, 
     * "Test 1: 123456 nanoseconds." Additionally, calculates the average of
     * these timings.
     * 
     * Input: long[] times, String label.
     *
     * Output: Printed timings.
     *
    ******************************************************************************/
    public static void printTimings(long[] times, String label) 
    {
        System.out.println("Timings for " + label + ":");
        for (int i = 0; i < times.length; i++) 
        {
            System.out.println("Test " + (i + 1) + ": " + times[i] + " nanoseconds");
        }
        long average = calculateTrimmedAverage(times);
        System.out.println("Trimmed average for " + label + ": " + average + " nanoseconds");
        System.out.println();
    }

    /******************************************************************************
     * Method: printConnectedCounts: Indicates the label of the connected 
     * components being displayed. Done by iterating through counts array. For each 
     * count, it prints the test number (starting from 1) and the count of 
     * connected components. For example, "Test 1: 5 connected components." 
     * Additionally, the code finds the average these counts.
     * 
     * Input: int[] counts, String label.
     *
     * Output: Printed connected counts.
     *
    ******************************************************************************/
    public static void printConnectedCounts(int[] counts, String label) 
    {
        System.out.println("Connected components for " + label + ":");
        for (int i = 0; i < counts.length; i++) 
        {
            System.out.println("Test " + (i + 1) + ": " + counts[i]);
        }
        double average = calculateTrimmedAverage(counts);
        System.out.println("Average connected components for " + label + ": " + average);
        System.out.println();
    }

    /******************************************************************************
     * Method: calculateTrimmedAverage: Sorts times in ascending order, then 
     * calculates the trimmed average. The trimmed average removes a certain number 
     * of lowest and highest values from the sorted array before 
     * calculating the average. In this case it is the lowest 5 and highest 5. The 
     * code then calculates the sum of the remaining values within this range.
     * 
     * Input: long[] times.
     *
     * Output: The trimmed averages.
     *
    ******************************************************************************/
    public static long calculateTrimmedAverage(long[] times) 
    {
        // Sort the array to remove the lowest 5 and highest 5 times
        Arrays.sort(times);
        long sum = 0;
        for (int i = 5; i < times.length - 5; i++) 
        {
            sum += times[i];
        }
        // Done to account for the removed 5 elements on either side
        return sum / (times.length - 10);
    }

    /******************************************************************************
     * Method: calculateTrimmedAverage: Similarily to the previouse code for 
     * calculateTrimmedAverage with respect to time, this does the same but
     * for the counts.
     * 
     * Input: int[] counts.
     *
     * Output: The count averages.
     *
    ******************************************************************************/
    public static double calculateTrimmedAverage(int[] counts) 
    {
        // Sort the array to remove the lowest 5 and highest 5 counts
        Arrays.sort(counts);
        double sum = 0;
        for (int i = 5; i < counts.length - 5; i++) {
            sum += counts[i];
        }
        return sum / (counts.length - 10);
    }
}