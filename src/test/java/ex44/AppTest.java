package ex44;

import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() {
        //to check that the exercise 44 json input file exists
        File ex44InputFile = new File("src\\main\\java\\ex44\\exercise44_input.json");
        assertTrue(ex44InputFile.exists()); //assert true is the file does exist

        long jsonFileLength = ex44InputFile.length(); //declare and initialize "jsonFileLength" with the long datatype to find length of json input file
        assertTrue(jsonFileLength != 0); //assert true if the json file is not empty, false if otherwise
    }
}