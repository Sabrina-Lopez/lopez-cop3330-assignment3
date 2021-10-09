package ex42;

import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() throws FileNotFoundException {
        //to check that the exercise 42 input file exists
        File ex42InputFile = new File("src\\main\\java\\ex42\\exercise42_input.txt");
        assertTrue(ex42InputFile.exists());

        //declare and initialize "recordsListInput", a variable with the Scanner class that reads from the "recordsListFile"
        // file so the program reads input from "exercise42_input.txt"
        Scanner recordsListInput = new Scanner(ex42InputFile); //create scanner to take in the list of records

        while(recordsListInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another record to read in"
            //declare and initialize "nextRecord", a String variable to hold the next line of input, or record, read from the input file
            String nextRecord = recordsListInput.nextLine();

            int recordLength = nextRecord.length(); //length of the record string or nextRecord

            boolean recordHasComma = nextRecord.contains(","); //determine whether the record string has a comma or not

            if(recordHasComma) { //if the record string has a comma

                int commaCounter = 0; //declare and initialize comma counter to see how many commas are in the record string

                for(int i = 0; i < recordLength; i++) { //loop till the end of the current record
                    //if the current record has a comma that is between two non-comma characters
                    if((nextRecord.charAt(i) == ',') && (nextRecord.charAt(i-1) != ',') && (nextRecord.charAt(i+1) != ',')) {
                        commaCounter++; //comma counter increments

                        //if the character before the comma is a letter
                        boolean charBeforeCommaIsAlpha = (((nextRecord.charAt(i - 1) >= 'A') || (nextRecord.charAt(i - 1) >= 'a')) && ((nextRecord.charAt(i - 1) <= 'Z') || (nextRecord.charAt(i - 1) <= 'z')));

                        //if the character after the comma is a letter
                        boolean charAfterCommaIsAlpha = (((nextRecord.charAt(i + 1) >= 'A') || (nextRecord.charAt(i + 1) >= 'a')) && ((nextRecord.charAt(i + 1) <= 'Z') || (nextRecord.charAt(i + 1) <= 'z')));

                        //if the character after the comma is a number
                        boolean charAfterCommaIsDigit = ((nextRecord.charAt(i+1) >= '0') && (nextRecord.charAt(i+1) <= '9'));

                        if(commaCounter == 1) { //if the comma counter currently equals 1
                            assertTrue(charBeforeCommaIsAlpha);
                            assertTrue(charAfterCommaIsAlpha);
                        }
                        else if(commaCounter == 2) { //if the comma counter currently equals 2
                            assertTrue(charBeforeCommaIsAlpha);
                            assertTrue(charAfterCommaIsDigit);
                        }
                        else { //if the comma counter is still 0 or greater than 2
                            fail();
                        }
                    }
                }
            }
            else { //if the record string doesn't have a comma
                fail();
            }
        }
    }
}