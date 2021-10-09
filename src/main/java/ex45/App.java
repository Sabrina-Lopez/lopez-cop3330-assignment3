package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        String utilized = "utilized";
        String utilize = "utilize";
        String utilizes = "utilizes";
        String utilizing = "utilizing";

        ArrayList<String> ex45InputLines = new ArrayList<>();

        File ex45InputFile = new File("src\\main\\java\\ex45\\exercise45_input.txt");

        Scanner inputLinesInput = new Scanner(ex45InputFile);

        while(inputLinesInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            String nextLine = inputLinesInput.nextLine();
            ex45InputLines.add(nextLine);
        }

        ArrayList<String> ex45ChangedInputLines = new ArrayList<>();

        for (String inputLine : ex45InputLines) {
            if (inputLine.contains(utilize)) {
                ex45ChangedInputLines.add(inputLine.replace(utilize, "use"));
            } else if (inputLine.contains(utilizes)) {
                ex45ChangedInputLines.add(inputLine.replace(utilizes, "uses"));
            } else if (inputLine.contains(utilized)) {
                ex45ChangedInputLines.add(inputLine.replace(utilized, "used"));
            } else if (inputLine.contains(utilizing)) {
                ex45ChangedInputLines.add(inputLine.replace(utilizing, "using"));
            }
            else {
                ex45ChangedInputLines.add(inputLine);
            }
        }

        System.out.print("\nWhat is the output name? "); //ask the user for the output file name
        Scanner outputFileNameInput = new Scanner(System.in); //scan the output file name
        String outputFileName = outputFileNameInput.nextLine();

        File ex45OutputFile = new File("src\\main\\java\\ex45\\" + outputFileName + ".txt");
        boolean ex45OutputFileCreated = ex45OutputFile.createNewFile();
        FileWriter ex45OutputFileOutput = new FileWriter(ex45OutputFile);

        if(ex45OutputFileCreated) {
            for (String ex45ChangedInputLine : ex45ChangedInputLines) {
                ex45OutputFileOutput.write(ex45ChangedInputLine + "\n");
            }
            ex45OutputFileOutput.close();
        }
    }
}