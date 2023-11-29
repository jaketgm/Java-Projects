/******************************************************************************
 * Class: Student: 
 * 
 * - This class is designed to manage a class of students and their marks.
 *
 * Input: None.
 *
 * Output: A Student.
 *
******************************************************************************/
public class Student 
{
    private int[] marks;
    private int markCount = 0;

    /******************************************************************************
     * Method: Student: 
     * 
     * - Initizlizes a students marks.
     *
     * Input: int size.
     *
     * Output: New array of marks of an inputted size.
     *
    ******************************************************************************/
    public Student(int size) 
    {
        marks = new int[size];
    }

    /******************************************************************************
     * Method: addMark: 
     * 
     * - Adds a mark to a student.
     *
     * Input: int newMark.
     *
     * Output: Student with new mark.
     *
    ******************************************************************************/
    public void addMark(int newMark) 
    {
        if (markCount >= marks.length)
            increaseSize();
        marks[markCount++] = newMark;
    }

    /******************************************************************************
     * Method: increaseSize: 
     * 
     * - Increases the size of the array. 
     *
     * Input: None.
     *
     * Output: Array with increased size.
     *
    ******************************************************************************/
    private void increaseSize() 
    {
        int[] temp = new int[marks.length + 1];
        System.arraycopy(marks, 0, temp, 0, marks.length);
        marks = temp;
    }

    /******************************************************************************
     * Method: getMark: 
     * 
     * - Gets a mark from a student.
     *
     * Input: int index.
     *
     * Output: Mark at inputted index.
     *
    ******************************************************************************/
    public int getMark(int index) 
    {
        if (index < 0 || index >= markCount)
            throw new IllegalArgumentException("Invalid index");
        return marks[index];
    }

    /******************************************************************************
     * Method: getAverage: 
     * 
     * - Gets the average of a student.
     *
     * Input: None.
     *
     * Output: Average.
     *
    ******************************************************************************/
    public double getAverage() 
    {
        double sum = 0;
        for (int mark : marks)
            sum += mark;
        return markCount > 0 ? sum / markCount : 0;
    }

    /******************************************************************************
     * Method: countAboveAverage: 
     * 
     * - This method counts the number of quizzes above average for each student.
     *
     * Input: double[] averages.
     *
     * Output: The number of above average quizzes.
     *
    ******************************************************************************/
    public int countAboveAverage(double[] averages) 
    {
        int count = 0;
        for (int i = 0; i < markCount; i++) 
        {
            if (marks[i] > averages[i])
                count++;
        }
        return count;
    }

    /******************************************************************************
     * Method: toString: 
     * 
     * - This method prints the resulting data to the user.
     *
     * Input: None.
     *
     * Output: The String for the data.
     *
    ******************************************************************************/
    @Override
    public String toString() 
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < markCount; i++)
            result.append(marks[i]).append(" ");
        return result.toString().trim();
    }
}