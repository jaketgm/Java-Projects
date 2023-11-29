/******************************************************************************
 * @author Jake Brockbank
 * Nov 29th, 2023 (Revitalized)
 * This program takes the users input for a specified width, height and 
 * thickness of a peice of paper. It then calculates the maximum number of
 * folds that can be made to the paper before it is too thick to fold.
******************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

/******************************************************************************
 * Method: PaperFoldingCalculator (Driver): 
 * 
 * - This program takes the users input for a specified width, height and 
 * thickness of a peice of paper. It then calculates the maximum number of
 * folds that can be made to the paper before it is too thick to fold.
 *
 * Input: Width, height, thickness.
 *
 * Output: The result based off inputs.
 *
******************************************************************************/
public class PaperFoldingCalculator 
{
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            double width = promptForDouble(scanner, "Enter the width of the sheet: ");
            double height = promptForDouble(scanner, "Enter the height of the sheet: ");
            double thickness = promptForDouble(scanner, "Enter the thickness of the sheet: ");

            int folds = calculateMaximumFolds(width, height, thickness);
            System.out.println("The maximum number of folds is: " + folds);
        }
    }

    /******************************************************************************
     * Method: promptForDouble: 
     * 
     * - This method prompts the user for a double value.
     *
     * Input: Scanner scanner, String message.
     *
     * Output: The double value.
     *
    ******************************************************************************/
    private static double promptForDouble(Scanner scanner, String message) 
    {
        while (true) 
        {
            try 
            {
                System.out.print(message);
                return scanner.nextDouble();
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    /******************************************************************************
     * Method: calculateMaximumFolds: 
     * 
     * - This method calculates the maximum number of folds that can be made to
     * the paper before it is too thick to fold.
     *
     * Input: double width, double height, double thickness.
     *
     * Output: The max folds (int).
     *
    ******************************************************************************/
    private static int calculateMaximumFolds(double width, double height, double thickness) 
    {
        int folds = 0;
        while (thickness * 3 < width || thickness * 3 < height) 
        {
            if (width < height) 
            {
                height /= 2;
            } 
            else 
            {
                width /= 2;
            }
            thickness *= 2;
            folds++;
        }
        return folds;
    }
}