
package vella_btree;

/****************************
 ***Class Name: BTree
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to scan input from a text file and 
 ***then add each word to a binary tree sorted alphabetically. Then the class 
 ***will display the data from the binary tree along with the word count.
 **************************** 
 ***Date: 11/1/2018
 ****************************/ 
public class BTree {

    public static void main(String[] args) 
    { 
        //create FileScan
        FileScan myFileScan = new FileScan();
        
        //create array of data from FileScan
        String [] list = myFileScan.FileScan();
        
        //create tree
        Tree btt = new Tree();
               
        //add each word from the array to a node
        for (int i = 0; i < list.length - 1; i++)
        {
            btt.addNodes(list[i]);
        }
        
        //print data from binary tree
        btt.printOutput();
        System.out.println("");
        System.out.println("Word Count: " + String.valueOf(list.length-1));
    }   
}