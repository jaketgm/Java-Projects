/******************************************************************************
 * @author Jake Brockbank
 * Nov 27th, 2023 (Revitalized)
 * This program takes the users input for a specified calculation, 
 * it then performs this calculation, and provides the user with the results.
******************************************************************************/

import java.util.Scanner;

/******************************************************************************
 * Method: Calculations (Driver): 
 * 
 * - This program takes the users input for a specified calculation, 
 * it then performs this calculation, and provides the user with the results.
 *
 * Input: None.
 *
 * Output: The result based off inputs.
 *
******************************************************************************/
public class Calculations 
{
    // Constants
    private static final double PI = 3.14159; // Value of PI
    private static final double AREA_PER_BAG = 112; // Area covered by one bag of grass seeds
    private static final int MONEY_PER_BAG = 14; // Cost per bag of grass seeds

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        // Read top-left coordinates of the rectangle from user
        int[] topLeft = readCoordinates(scan, "Enter the top-left coordinates for the rectangular portion, as (X,Y): ");
        // Read bottom-right coordinates of the rectangle from user
        int[] bottomRight = readCoordinates(scan, "Enter the bottom-right coordinates for the rectangular portion, as (X,Y): ");
        
        // Read radius for the circular portion from user
        System.out.print("Enter the radius for the circle portion: ");
        double radius = scan.nextDouble();

        // Calculate the perimeter of the circular portion
        double circlePerim = calculateCirclePerimeter(radius);
        // Calculate the area of the circular portion
        double circleArea = calculateCircleArea(radius);

        // Calculate the length and width of the rectangle
        double rectLength = bottomRight[0] - topLeft[0];
        double rectWidth = topLeft[1] - bottomRight[1];

        // Calculate the perimeter of the rectangular portion
        double rectPerim = calculateRectanglePerimeter(rectLength, rectWidth, radius);
        // Calculate the area of the rectangular portion
        double rectArea = rectLength * rectWidth;

        // Calculate the total perimeter (rectangle + circle)
        double totalPerimeter = rectPerim + circlePerim;
        // Calculate the total area (rectangle + circle)
        double totalArea = rectArea + circleArea;

        // Output the total perimeter needed for fencing
        System.out.println("You will need " + totalPerimeter + " meters of fence around this field.");
        // Output the total area to be covered with grass
        System.out.println("You have to cover " + totalArea + " square meters with grass.");

        // Calculate the number of bags of grass seeds needed
        int nbBags = calculateNumberOfBags(totalArea);
        // Calculate the total cost for the seeds
        int totalCost = nbBags * MONEY_PER_BAG;

        // Output the number of bags needed
        System.out.println("You will need " + nbBags + " bags of grass seeds for this.");
        // Output the total cost for the seeds
        System.out.println("The total cost for seeds will be $" + totalCost + " before tax.");
    }

    // Method to read coordinates input by the user
    private static int[] readCoordinates(Scanner scanner, String prompt) 
    {
        System.out.print(prompt);
        String input = scanner.nextLine();
        String[] parts = input.substring(1, input.length() - 1).split(",");
        return new int[] { Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()) };
    }

    // Method to calculate the perimeter of a circle
    private static double calculateCirclePerimeter(double radius) 
    {
        return 2 * PI * radius * 3 / 4;
    }

    // Method to calculate the area of a circle
    private static double calculateCircleArea(double radius) 
    {
        return PI * radius * radius * 3 / 4;
    }

    // Method to calculate the perimeter of a rectangle
    private static double calculateRectanglePerimeter(double length, double width, double radius) 
    {
        return 2 * (length + width) - (2 * radius);
    }

    // Method to calculate the number of bags needed based on the area
    private static int calculateNumberOfBags(double area) 
    {
        return (int) Math.ceil(area / AREA_PER_BAG);
    }
}