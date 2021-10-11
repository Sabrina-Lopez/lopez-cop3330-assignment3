package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
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

        //declare "ex45InputLines", a variable with the ArrayList datatype to hold the lines of input from the "exercise45_input.txt"
        ArrayList<String> ex45InputLines = new ArrayList<>();

        //declare and initialize "ex45InputFile", a variable with the File class to take in the input from
        // "exercise45_input.txt" file into the program
        File ex45InputFile = new File("src\\main\\java\\ex45\\exercise45_input.txt");

        //declare and initialize "inputLinesInput", a variable with the Scanner class that reads the lines of input from "exercise45_input.txt"
        Scanner inputLinesInput = new Scanner(ex45InputFile);

        while(inputLinesInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextLine", a String variable to hold the next line of input from "exercise45_input.txt"
            String nextLine = inputLinesInput.nextLine();
            ex45InputLines.add(nextLine); //add the next line of input to the "ex45InputLines" ArrayList
        }

        //declare "ex45ChangedInputLines", a variable with the ArrayList datatype to hold the modified lines of input
        ArrayList<String> ex45ChangedInputLines = new ArrayList<>();

        //for "the current product (e.g., first, second, fifth) in the line of input from the "ex45InputLines" ArrayList until all the lines
        // have been modified to have 'use' instead 'utilize'"
        for (String inputLine : ex45InputLines) {
            if (inputLine.contains(utilizeVariant)) { //if the line contains a variant of "utilize"
                ex45ChangedInputLines.add(inputLine.replace(utilize, "use")); //change "utilize" to "use" and add new line of input into the "ex45ChangedInputLines" ArrayList
            } else if (inputLine.contains(utilizes)) { //if the line contains "utilizes"
                ex45ChangedInputLines.add(inputLine.replace(utilizes, "uses")); //change "utilizes" to "uses" and add new line of input into the "ex45ChangedInputLines" ArrayList
            } else if (inputLine.contains(utilized)) { //if the line contains "utilized"
                ex45ChangedInputLines.add(inputLine.replace(utilized, "used")); //change "utilized" to "used" and add new line of input into the "ex45ChangedInputLines" ArrayList
            } else if (inputLine.contains(utilizing)) { //if the line contains "utilizing"
                ex45ChangedInputLines.add(inputLine.replace(utilizing, "using")); //change "utilizing" to "using" and add new line of input into the "ex45ChangedInputLines" ArrayList
            }
            else { //if the line doesn't contain a variant of "utilize"
                ex45ChangedInputLines.add(inputLine); //add the line as a new line of input into the "ex45ChangedInputLines" ArrayList
            }
        }

        //output to the user the question of what output name they want for their output file
        System.out.print("\nWhat is the output name? ");

        //declare and initialize "outputFileNameInput", a variable with the Scanner class that reads the user's desired output file name
        Scanner outputFileNameInput = new Scanner(System.in);

        //declare and initialize "outputFileName", a String variable to hold the user's desired output file name
        String outputFileName = outputFileNameInput.nextLine();

        //declare and initialize "ex45OutputFile", a variable with the File class to create and print out the modified input lines to the user's output file
        File ex45OutputFile = new File("src\\main\\java\\ex45\\" + outputFileName + ".txt");

        //declare and initialize "ex45OutputFileCreated", a variable with the boolean datatype to create and or ensure the existence of the output file
        boolean ex45OutputFileCreated = ex45OutputFile.createNewFile();

        //declare and initialize "ex45OutputFileOutput", a variable with the FileWriter class to write the modified input lines into the created output file
        FileWriter ex45OutputFileOutput = new FileWriter(ex45OutputFile);

        if(ex45OutputFileCreated) { //if the output file has been created
            //for "the current product (e.g., first, second, fifth) in the line of output from the "ex45OutputLines" ArrayList until all the lines
            // have been outputted to the newly created output file
            for (String ex45ChangedInputLine : ex45ChangedInputLines) {
                ex45OutputFileOutput.write(ex45ChangedInputLine + "\n"); //output to the output file the next line from the modified input lines ArrayList
            }
            ex45OutputFileOutput.close(); //close the output file via ending the File Writer variable
        }
    }
}