
package vella_btree;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/****************************
 ***Class Name: FileScan
 ***Author: Devin Vella
 ****************************
 ***Purpose: The purpose of this class is to scan the file and save each word 
 ***from the file into an array and return it to main.
 **************************** 
 ***Date: 11/1/2018
 ****************************/ 
public class FileScan 
{
    //create string array to hold all words from text file
    private String [] tokens;

    /****************************
    ***Method Name: FileScan
    ***Author: Devin Vella
    ****************************
    ***Purpose: The purpose of this method is to scan the file and save each word 
    ***from the file into an array and return it to main.  
    ****************************
    ***Return Value:
    ***tokens
    ***Date: 11/1/2018
    ****************************/
    public String [] FileScan()
    {
        //catch if build fails
        try
        {
            //make and diplay interface so user can choice a file
            JFileChooser choice = new JFileChooser();
            
            //If user clicks the cancel option then end program
            int answer = choice.showOpenDialog(choice);
            if (answer == JFileChooser.CANCEL_OPTION) 
            {
                System.exit(0);
            }
            
            //save file to variable
            File fileName = choice.getSelectedFile();
            
            //scan file and save data
            Scanner file = new Scanner(fileName);
            
            //initiate value
            String wholeFile = "";
           
            //Save data to string
            while(file.hasNextLine())
            {
                //save each line until there are no more lines
                String lineOut = file.nextLine();
                
                //save all lines to one string
                wholeFile += lineOut + " ";
            }
            
            //make sure the file does not seperate uppercase and lowercase characters
            wholeFile = wholeFile.toUpperCase();
            
            //remove all commas inbetween digits
            wholeFile = wholeFile.replaceAll(",","");
            
            //replace punctuation with blank spaces
            wholeFile = wholeFile.replaceAll("[^a-zA-Z0-9'-]+"," ");
            
            //seperate the words by the spaces and add them to array
            tokens = wholeFile.split(" ");
        }
        catch(HeadlessException | FileNotFoundException e)
        {
            //display error message
            System.out.println("Error: Most likely the file was either entered wrong or could not be read.");
        }
        return tokens;
    }
}
