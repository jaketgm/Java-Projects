public class WeightedQuickUnion
{
    private int[] parentArray;
    private int[] lengthOfRoot;

    /******************************************************************************
     * Method: Constructor: Takes in the size of an array, and initializes it.
     * Alongside another array of the lengths of roots.
     *
     * Input: int size.
     *
     * Output: The initialized arrays.
     *
    ******************************************************************************/
    public WeightedQuickUnion(int size)
    {
        parentArray = new int[size];
        lengthOfRoot = new int[size];
        initializeArray();
    }

    /******************************************************************************
     * Method: initializeArray: Initializes the data within the arrays.
     *
     * Input: None.
     *
     * Output: Filled arrays with data.
     *
    ******************************************************************************/
    private void initializeArray() 
    {
        for (int i = 0; i < parentArray.length; i++) 
        {
            parentArray[i] = i;
            lengthOfRoot[i] = 1;
        }
    }

    /******************************************************************************
     * Method: union: Different to Quick Union, in order to union an inputted p
     * and q we ensure that the larger component becomes the parent of the 
     * smaller component, which helps keep the tree structure balanced and 
     * improves the overall efficiency of the data structure.
     *
     * Input: int p, int q.
     *
     * Output: Union of p and q.
     *
    ******************************************************************************/
    public void union(int p, int q) 
    {
        int rootOfP = root(p);
        int rootOfQ = root(q);
        if (rootOfP == rootOfQ)
            return;
    
        if (lengthOfRoot[rootOfP] > lengthOfRoot[rootOfQ]) 
        {
            parentArray[rootOfQ] = rootOfP;
            lengthOfRoot[rootOfP] += lengthOfRoot[rootOfQ];
        } 
        else 
        {
            parentArray[rootOfP] = rootOfQ;
            lengthOfRoot[rootOfQ] += lengthOfRoot[rootOfP];
        }
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
            result = true;
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
        while (value != parentArray[value])
        {
            value = parentArray[value];
        }
        return value;
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
            System.out.print(lengthOfRoot[i] + " ");
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