/******************************************************************************
 * @author Jake Brockbank
 * Nov 29th, 2023 (Revitalized)
 * This program is designed to manage a class of students and their marks.
 * It will calculate the average of each student, the average of each quiz,
 * and the number of quizzes above average for each student.
******************************************************************************/

import java.text.DecimalFormat;

/******************************************************************************
 * Method: QuizManagement (Driver): 
 * 
 * - This program is designed to manage a class of students and their marks.
 * It will calculate the average of each student, the average of each quiz,
 * and the number of quizzes above average for each student.
 *
 * Input: None.
 *
 * Output: The average of each student, the average of each quiz, and the 
 * number of quizzes above average for each student.
 *
******************************************************************************/
public class QuizManagement 
{
    public static void main(String[] args) 
    {
        Student[] classlist = new Student[5];
        for (int i = 0; i < classlist.length; i++)
            classlist[i] = new Student(10);

        // Add marks to students
        addStudentMarks(classlist);

        DecimalFormat fmt = new DecimalFormat("0.00");

        // Print student averages
        for (int i = 0; i < classlist.length; i++) 
        {
            System.out.println("Student " + (i + 1) + ": " + classlist[i]);
            System.out.println("\tAverage: " + fmt.format(classlist[i].getAverage()));
        }

        double[] quizAverages = calculateQuizAverages(classlist);

        // Print quiz averages
        System.out.println("Quiz Averages:");
        for (int i = 0; i < quizAverages.length; i++)
            System.out.println("Quiz " + (i + 1) + ": " + fmt.format(quizAverages[i]));

        // Print count of quizzes above average for each student
        for (int i = 0; i < classlist.length; i++) 
        {
            System.out.println("Student " + (i + 1) + " has " + 
                                classlist[i].countAboveAverage(quizAverages) + 
                                " quizzes above average.");
        }
    }

    /******************************************************************************
     * Method: addStudentMarks: 
     * 
     * - This method adds marks to the students.
     *
     * Input: Student[] classlist.
     *
     * Output: The added students marks to classlist.
     *
    ******************************************************************************/
    private static void addStudentMarks(Student[] classlist) 
    {
        // Sample data for adding marks to students
        int[][] marks = {
            {80, 75, 90, 79},
            {66, 76, 90, 84},
            {90, 100, 60, 65},
            {50, 100, 75, 70},
            {85, 85, 85, 100}
        };

        for (int i = 0; i < classlist.length; i++) 
        {
            for (int mark : marks[i]) 
                classlist[i].addMark(mark);
        }
    }

    /******************************************************************************
     * Method: calculateQuizAverages: 
     * 
     * - This method calculates the quiz averages.
     *
     * Input: Student[] classlist.
     *
     * Output: The calculated quiz averages.
     *
    ******************************************************************************/
    private static double[] calculateQuizAverages(Student[] classlist) 
    {
        double[] averages = new double[4]; // Assuming 4 quizzes
        for (int i = 0; i < averages.length; i++) 
        {
            double total = 0;
            for (Student student : classlist)
                total += student.getMark(i);
            averages[i] = total / classlist.length;
        }
        return averages;
    }
}