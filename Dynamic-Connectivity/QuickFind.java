public class QuickFind 
{
    private int[] integerArray;

    /******************************************************************************
     * Method: Constructor: Takes in the length of an array, and initializes it.
     *
     * Input: int lengthOfArray.
     *
     * Output: The initialized array.
     *
    ******************************************************************************/
    public QuickFind(int lengthOfArray) 
    {
        integerArray = new int[lengthOfArray];
        initializeArray();
    }

    /******************************************************************************
     * Method: initializeArray: Initializes the data within the array.
     *
     * Input: None.
     *
     * Output: Filled array with data.
     *
    ******************************************************************************/
    private void initializeArray() 
    {
        for (int i = 0; i < integerArray.length; i++) 
        {
            integerArray[i] = i;
        }
    }

    /******************************************************************************
     * Method: find: Takes in a value p, and returns the value of the array at that
     * value, similarily finding the id of p.
     *
     * Input: int p.
     *
     * Output: The value of the array at p.
     *
    ******************************************************************************/
    public int find(int p) 
    {
        return integerArray[p];
    }

    /******************************************************************************
     * Method: isConnected: Checks whether two inputted values p and q are 
     * connected. In order to be connected they must effectively be in the same set
     * i.e. have the same values at their respective indicies within the array.
     *
     * Input: int p, int q.
     *
     * Output: True or false value depending on connection.
     *
    ******************************************************************************/
    public boolean isConnected(int p, int q) 
    {
        boolean result = false;
        if (integerArray[p] == integerArray[q])
        {
            result = true;
        }
        return result;
    }

    /******************************************************************************
     * Method: union: This method effectively adds two values to the same set. I.e.
     * starting by checking whether their values are equal or not at their
     * respective indicies within the array, if they happen to not be equal, then
     * we instantiate a loop to change the id of all elements in the set with idP to 
     * idQ alongside another check to see if the value of the increment i in the array
     * is equal to that of the idP, if so we set i to idQ. Note, if the initial check
     * returns false, i.e. idP is equal to idQ we need not union them as they already
     * belong to the same set.
     *
     * Input: int p, int q.
     *
     * Output: Union of p and q.
     *
    ******************************************************************************/
    public void union(int p, int q) 
    {
        int idP = integerArray[p];
        int idQ = integerArray[q];
        if (idP != idQ) 
        {
            // Change the id of all elements in the set with idP to idQ
            for (int i = 0; i < integerArray.length; i++) 
            {
                if (integerArray[i] == idP) 
                {
                    integerArray[i] = idQ;
                }
            }
        }
    }

    /******************************************************************************
     * Method: printInstanceData: Simple print method to visualize the data
     * to the user.
     *
     * Input: None.
     *
     * Output: Printed instance data.
     *
    ******************************************************************************/
    public void printInstanceData() 
    {
        for (int i = 0; i < integerArray.length; i++) 
        {
            System.out.print(integerArray[i] + " ");
        }
        System.out.println();
    }

    /******************************************************************************
     * Method: getIntegerArray: Accessor method to return the array to the user.
     *
     * Input: None.
     *
     * Output: integerArray.
     *
    ******************************************************************************/
    public int[] getIntegerArray() 
    {
        return integerArray;
    }
}