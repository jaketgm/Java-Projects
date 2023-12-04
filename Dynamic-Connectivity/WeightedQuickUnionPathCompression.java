public class WeightedQuickUnionPathCompression
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
    public WeightedQuickUnionPathCompression(int size)
    {
        parentArray = new int[size];
        lengthOfRoot = new int[size];
        initializeArray(size);
    }

    /******************************************************************************
     * Method: initializeArray: Initializes the data within the arrays.
     *
     * Input: None.
     *
     * Output: Filled arrays with data.
     *
    ******************************************************************************/
    private void initializeArray(int size)
    {
        for (int i = 0; i < size; i++)
        {
            parentArray[i] = i;
            lengthOfRoot[i] = 1; // Initialize the size of each tree to 1
        }
    }

    /******************************************************************************
     * Method: union: In order to union an inputted p
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
     * as long as root is not equal to parentArray[root]. The path compression 
     * part happens when the method updates the parent of the current element 
     * (parentArray[root]) to be the grandparent (parentArray[parentArray[root]]) 
     * of the element. This effectively makes the element's parent point directly to 
     * the root, reducing the depth of the tree.
     *
     * Input: int value.
     *
     * Output: The root.
     *
    ******************************************************************************/
    public int root(int value)
    {
        int root = value;
        while (root != parentArray[root])
        {
            parentArray[root] = parentArray[parentArray[root]]; // Path compression
            root = parentArray[root];
        }
        return root;
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
