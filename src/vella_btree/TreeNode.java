
package vella_btree;

/****************************
 ***Class Name: TreeNode
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to create a node for the binary tree.
 ***and return it to main
 **************************** 
 ***Date: 11/1/2018
 ****************************/ 
public class TreeNode 
{
    //declare variables
    String input;
    TreeNode leftChild;
    TreeNode rightChild;
    
    /****************************
    ***Method Name: TreeNode
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to create a node for the binary tree.   
    ****************************
    ***Method Inputs: input
    ****************************
    ***Date: 11/1/2018
    ****************************/
    public TreeNode(String input)
    {
        //save input to variable in TreeNode
        this.input = input;
        
        //used to hold value of the child nodes of parent nodes
        leftChild = null;
        rightChild = null;
    }
    public String printOut()
    {
        //return to input to print out the input
        return input;
    }
}
