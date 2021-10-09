package ex41;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() throws FileNotFoundException {
        //to check that the exercise 41 input file exists
        File ex41InputFile = new File("src\\main\\java\\ex41\\exercise41_input.txt");
        assertTrue(ex41InputFile.exists());

        //declare and initialize "namesListInput", a variable with the Scanner class that reads from the "namesListFile"
        // file so the program reads input from "exercise42_input.txt"
        Scanner namesListInput = new Scanner(ex41InputFile); //create scanner to take in the list of names

        while(namesListInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextName", a String variable to hold the next line of input, or name, read from the input file
            String nextName = namesListInput.nextLine();

            int nameLength = nextName.length(); //length of the name string or nextName

            boolean nameHasComma = nextName.contains(","); //determine whether the name string has a comma or not

            if(nameHasComma) { //if the name string has a comma

                int commaCounter = 0; //declare and initialize comma counter to see how many commas are in the name string

                for(int i = 0; i < nameLength; i++) { //loop till the end of the current name
                    //if the current name has a comma that is between two non-comma characters
                    if((nextName.charAt(i) == ',') && (nextName.charAt(i-1) != ',') && (nextName.charAt(i+1) != ',')) {
                        commaCounter++; //comma counter increments
                        assertEquals(1, commaCounter);
                    }
                }
            }
            else { //if the name string doesn't have a comma
                fail();
            }
        }

        //to check that the exercise 41 output file exists
        File ex41OutputFile = new File("src\\main\\java\\ex41\\exercise41_output.txt");
        assertTrue(ex41OutputFile.exists());

        //to check if the exercise 41 tests' results in a non-empty output file
        assertTrue(ex41OutputFile.length() != 0);
    }
}