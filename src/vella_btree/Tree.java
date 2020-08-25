
package vella_btree;

/****************************
 ***Class Name: Tree
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to create a node from input and add 
 ***and sort it alphabetically into a binary tree.
 **************************** 
 ***Date: 11/1/2018
 ****************************/ 
public class Tree extends BTree 
{
    //declare variables
    public TreeNode root = null;
    private String myPrint = "";
    
    /***************************
    ***Method Name: addNode
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to create a node from input and then add it to binary tree.   
    ****************************
    ***Method Inputs: input
    ****************************
    ***Date: 11/1/2018
    ****************************/
    public void addNodes(String input)
    {
        //create tree node
        TreeNode newNode = new TreeNode(input);
            
        // if there is no root yet set newNode as the root
        if(root==null)
        {
            root = newNode;
        }
        //If there is a root use leftRightSort to find were the value needs to go
        else
        {
            leftRightSort(root, newNode);
        }   
    }
    
    /***************************
    ***Method Name: leftRightSort
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to sort the newNode alphabetically.   
    ****************************
    ***Method Inputs:
    ***currentNode, newNode
    ****************************
    ***Date: 11/1/2018
    ****************************/
    private void leftRightSort(TreeNode currentNode, TreeNode newNode)
    {
        //currentNode represents the node we are looking at
        //check if input is on left or right side of tree by comparing parent to new node alphabetically
        if(currentNode.input.compareTo(newNode.input)>0)
        {
            //if there is no value in left child set newNode as the left child
            if(currentNode.leftChild == null)
            {
                currentNode.leftChild = newNode;
            }
            //if there is a value in left child run the method again with left child as current node
            else
            {    
                leftRightSort(currentNode.leftChild, newNode);
            }
        }    
        else if(currentNode.input.compareTo(newNode.input)<0)
        {
            //if there is no value in right child set newNode as the right child
            if(currentNode.rightChild == null)
            {
                currentNode.rightChild = newNode;
            }
            //if there is a value in right child run the method again with right child as current node
            else
            {
                leftRightSort(currentNode.rightChild, newNode);
            }                       
        }
        else
        {
            //add word to node
            currentNode.input += "\n" + newNode.input;
        }
    }
    
    /***************************
    ***Method Name: printOutput
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to print out the data in binary tree.   
    ****************************
    ***Date: 11/1/2018
    ****************************/
    public void printOutput()
    {
        String output;
        traverseTree(root);
        output = myPrint;
        System.out.print(output);
    }
    
    /***************************
    ***Method Name: traverseTree
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to traverse the tree and set myPrint to the input.   
    ****************************
    ***Method Inputs: currentNode
    ****************************
    ***Date: 11/1/2018
    ****************************/
    private void traverseTree(TreeNode currentNode)
    {
        //set left most node to current node
        if(currentNode.leftChild!=null)
        {
            //set leftchild to current node
            traverseTree(currentNode.leftChild);
        }    
        
        //record current node
        myPrint += currentNode.printOut()+"\n";
        
        //check right node of parent   
        if(currentNode.rightChild!=null)
        {
            //set rightchild to current node
            traverseTree(currentNode.rightChild);             
        }
        //return current node to parent node after execution
    }
}