package ex46;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() throws FileNotFoundException {
        //to check that the exercise 45 text input file exists
        File ex46InputFile = new File("src\\main\\java\\ex46\\exercise46_input.txt");
        assertTrue(ex46InputFile.exists()); //assert true is the file does exist

        long inputFileLength = ex46InputFile.length(); //declare and initialize "inputFileLength" with the long datatype to find length of txt input file
        assertTrue(inputFileLength != 0); //assert true if the txt file is not empty, false if otherwise

        //declare and initialize "fileLinesAppended", a String variable to hold the lines of the input file as a single string
        String fileLinesAppended = App.wordsAppendedFunction(ex46InputFile);

        //declare and initialize "fileAsStringLength", an integer variable to hold the length of the appended input file lines
        int fileAsStringLength = fileLinesAppended.length();
        assertTrue(fileAsStringLength != 0); //if the input file is not empty, then assert true, false if otherwise
    }
}