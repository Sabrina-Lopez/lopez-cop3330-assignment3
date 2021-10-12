package ex45;

import org.junit.Test;
import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() throws IOException {
        //to check that the exercise 45 text input file exists
        File ex45InputFile = new File("src\\main\\java\\ex45\\exercise45_input.txt");
        assertTrue(ex45InputFile.exists()); //assert true is the file does exist

        long inputFileLength = ex45InputFile.length(); //declare and initialize "inputFileLength" with the long datatype to find length of txt input file
        assertTrue(inputFileLength != 0); //assert true if the txt file is not empty, false if otherwise

        //declare "ex45InputLines", a variable with the ArrayList datatype to hold the lines of input from the "exercise45_input.txt"
        ArrayList<String> ex45InputLines = new ArrayList<>();

        //declare and initialize "ex45InputFile", a variable with the File class to take in the input from
        // "exercise45_input.txt" file into the program
        ex45InputFile = new File("src\\main\\java\\ex45\\exercise45_input.txt");

        //declare and initialize "inputLinesInput", a variable with the Scanner class that reads the lines of input from "exercise45_input.txt"
        Scanner inputLinesInput = new Scanner(ex45InputFile);

        while(inputLinesInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextLine", a String variable to hold the next line of input from "exercise45_input.txt"
            String nextLine = inputLinesInput.nextLine();
            ex45InputLines.add(nextLine); //add the next line of input to the "ex45InputLines" ArrayList
        }

        //declare and initialize "utilized", a String variable to compare if the input file contains a variant of "utilize"
        String utilizeVariant = "utiliz";

        //declare and initialize "utilized", a String variable to compare if the input file contains "utilized"
        String utilized = "utilized";

        //declare and initialize "utilize", a String variable to compare if the input file contains "utilize"
        String utilize = "utilize";

        //declare and initialize "utilizes", a String variable to compare if the input file contains "utilizes"
        String utilizes = "utilizes";

        //declare and initialize "utilizing", a String variable to compare if the input file contains "utilizing"
        String utilizing = "utilizing";

        //declare "ex45ChangedInputLines", a variable with the ArrayList datatype to hold the modified lines of input
        ArrayList<String> ex45ChangedInputLines = App.utilizeWordRemover(utilizeVariant, utilize, utilized, utilizes, utilizing, ex45InputLines);

        //for "the current product (e.g., first, second, fifth) in the line of modified input from the "ex45ChangedInputLines" ArrayList until all the lines
        // have been checked to have no instances of a variation of the word "utilize"
        for(int i = 0; i < ex45ChangedInputLines.size(); i++) {
            assertFalse(ex45ChangedInputLines.contains(utilizeVariant)); //assert false if there is a variation of the word "utilize" in the line of modified input
        }

    }
}