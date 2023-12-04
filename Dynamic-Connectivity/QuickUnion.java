public class QuickUnion 
{
    private int[] parentArray;
    
    /******************************************************************************
     * Method: Constructor: Takes in the length of an array, and initializes it.
     *
     * Input: int lengthOfParent.
     *
     * Output: The initialized array.
     *
    ******************************************************************************/
    public QuickUnion(int lengthOfParent)
    {
        parentArray = new int[lengthOfParent];
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
        for (int i = 0; i < parentArray.length; i++) 
        {
            parentArray[i] = i;
        }
    }
    
    /******************************************************************************
     * Method: union: Different to Quick Find, in order to union an inputted p
     * and q we find their roots and compare those values within the array.
     *
     * Input: int p, int q.
     *
     * Output: Union of p and q.
     *
    ******************************************************************************/
    public void union(int p, int q)
    {
        parentArray[root(p)] = parentArray[root(q)];
    }

    /******************************************************************************
     * Method: isConnected: Checks whether p and q are in the same set. Done via
     * taking their roots and checking whether those are equivocal.
     *
     * Input: int p, int q.
     *
     * Output: True or false value depending on connection of p and q.
     *
    ******************************************************************************/
    public boolean isConnected(int p, int q) 
    {
        boolean result = false;
        if (root(p) == root(q))
        {
            return result = true;
        }
        return result;
    }

    /******************************************************************************
     * Method: root: Finds the root, done by entering a while loop that continues 
     * as long as the element at the result index in the parentArray is not equal to 
     * result. This loop effectively traverses the parent pointers until it reaches 
     * the root of the component. Then, sets the value of result to that of the
     * array at index result.
     *
     * Input: int value.
     *
     * Output: The root.
     *
    ******************************************************************************/
    public int root(int value)
    {
        int result = value;
        while (parentArray[result] != result) 
        {
            result = parentArray[result];
        }
        return result;
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
        for (int i = 0; i < parentArray.length; i++) 
        {
            System.out.print(parentArray[i] + " ");
        }
        System.out.println();
    }

    /******************************************************************************
     * Method: getParentArray: Accessor method to return the array to the user.
     *
     * Input: None.
     *
     * Output: parentArray.
     *
    ******************************************************************************/
    public int[] getParentArray() 
    {
        return parentArray;
    }
}