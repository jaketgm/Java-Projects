/******************************************************************************
 * @author Jake Brockbank
 * Nov 27th, 2023 (Revitalized)
 * This program is an interactive tool for calculating determinants and 
 * inverses of 2x2 and 3x3 matrices, with user inputs guiding the process.
******************************************************************************/

import java.util.Scanner;

/******************************************************************************
 * Method: Determinant (Driver): 
 * 
 * - This program is an interactive tool for calculating determinants and 
 * inverses of 2x2 and 3x3 matrices, with user inputs guiding the process.
 *
 * Input: None.
 *
 * Output: The result based off inputs.
 *
******************************************************************************/
public class Determinant 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        calculate2x2Determinant(scanner);
        calculate3x3Determinant(scanner);

        scanner.close();
    }

    /******************************************************************************
     * Method: calculate2x2Determinant: 
     * 
     * - This method calculates the determinant and inverse of a 2x2 matrix.
     *
     * Input: Scanner scanner.
     *
     * Output: The determinant and inverse of a 2x2 matrix.
     *
    ******************************************************************************/
    private static void calculate2x2Determinant(Scanner scanner) 
    {
        System.out.println("Given a 2x2 matrix of the form:");
        System.out.println("\na  b \nc  d");
        System.out.print("Enter integers a, b, c, d (to find the inverse and determinant): ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int determinant = a * d - b * c;
        System.out.println("Determinant of the matrix is: " + determinant);

        if (determinant != 0) 
        {
            double inverse = 1.0 / determinant;
            System.out.println("Inverse of the matrix is: " + inverse);
        } 
        else 
        {
            System.out.println("Inverse doesn't exist as determinant is zero.");
        }
    }

    /******************************************************************************
     * Method: calculate3x3Determinant: 
     * 
     * - This method calculates the determinant of a 3x3 matrix.
     *
     * Input: Scanner scanner.
     *
     * Output: The determinant of a 3x3 matrix.
     *
    ******************************************************************************/
    private static void calculate3x3Determinant(Scanner scanner) 
    {
        System.out.println("\nGiven a 3x3 matrix of the form:");
        System.out.println("\nx  y  z \nl  n  f \nk  e  r");
        System.out.print("Enter integers x, y, z, l, n, f, k, e, r (to find the determinant): ");

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int l = scanner.nextInt();
        int n = scanner.nextInt();
        int f = scanner.nextInt();
        int k = scanner.nextInt();
        int e = scanner.nextInt();
        int r = scanner.nextInt();

        process3x3Matrix(scanner, x, y, z, l, n, f, k, e, r);
    }

    /******************************************************************************
     * Method: process3x3Matrix: 
     * 
     * - This method processes a given 3x3 matrix and allows row/column cofactor
     * expansion selection.
     *
     * Input: Scanner scanner, int x, int y, int z, int l, int n, int f, int k, 
     * int e, int r.
     *
     * Output: The processed 3x3 matrix.
     *
    ******************************************************************************/
    private static void process3x3Matrix(Scanner scanner, int x, int y, int z, int l, int n, int f, int k, int e, int r) 
    {
        System.out.print("Choose 'row' or 'column' for cofactor expansion: ");
        String choice = scanner.next();

        switch (choice.toLowerCase()) 
        {
            case "row":
                calculateRowCofactorExpansion(scanner, x, y, z, l, n, f, k, e, r);
                break;
            case "column":
                calculateColumnCofactorExpansion(scanner, x, y, z, l, n, f, k, e, r);
                break;
            default:
                System.out.println("Invalid choice. Please choose 'row' or 'column'.");
                break;
        }
    }

    /******************************************************************************
     * Method: calculateRowCofactorExpansion: 
     * 
     * - Actually calculates the determinant of a 3x3 matrix using row cofactor
     * expansion.
     *
     * Input: Scanner scanner, int x, int y, int z, int l, int n, int f, int k, 
     * int e, int r
     *
     * Output: The calculated determinant of a given 3x3 matrix via row cofactor
     * expansion.
     *
    ******************************************************************************/
    private static void calculateRowCofactorExpansion(Scanner scanner, int x, int y, int z, int l, int n, int f, int k, int e, int r) 
    {
        System.out.print("Choose a row (1, 2, or 3) for cofactor expansion: ");
        int row = scanner.nextInt();

        double determinant = 0;
        switch (row) 
        {
            case 1:
                determinant = x * (n * r - e * f) - y * (l * r - f * k) + z * (l * e - n * k);
                break;
            case 2:
                determinant = l * (y * r - z * e) - n * (x * r - z * k) + f * (x * e - y * k);
                break;
            case 3:
                determinant = k * (y * f - z * n) - e * (x * f - z * l) + r * (x * n - y * l);
                break;
            default:
                System.out.println("Invalid row choice.");
                return;
        }

        System.out.println("Determinant of the matrix using row " + row + " cofactor expansion is: " + determinant);
    }

    /******************************************************************************
     * Method: calculateColumnCofactorExpansion: 
     * 
     * - Actually calculates the determinant of a 3x3 matrix using column cofactor
     * expansion.
     *
     * Input: Scanner scanner, int x, int y, int z, int l, int n, int f, int k, 
     * int e, int r
     *
     * Output: The calculated determinant of a given 3x3 matrix via column cofactor
     * expansion.
     *
    ******************************************************************************/
    private static void calculateColumnCofactorExpansion(Scanner scanner, int x, int y, int z, int l, int n, int f, int k, int e, int r) 
    {
        System.out.print("Choose a column (1, 2, or 3) for cofactor expansion: ");
        int column = scanner.nextInt();

        double determinant = 0;
        switch (column) 
        {
            case 1:
                determinant = x * (n * r - e * f) - l * (y * r - z * e) + k * (y * f - z * n);
                break;
            case 2:
                determinant = y * (l * r - f * k) - n * (x * r - z * k) + e * (x * f - z * l);
                break;
            case 3:
                determinant = z * (l * e - n * k) - f * (x * e - y * k) + r * (x * n - y * l);
                break;
            default:
                System.out.println("Invalid column choice.");
                return;
        }

        System.out.println("Determinant of the matrix using column " + column + " cofactor expansion is: " + determinant);
    }
}