package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.util.*; //import to enable use of the Scanner class
import java.io.*; //import to enable use of the File and FileWriter classes as well as the close and write file methods

public class App {
    //incorporate the "throws IOException" for any file input and or output exceptions
    public static void main(String[] args) throws IOException {

        //declare "namesList", a variable with the ArrayList datatype to hold the list of names from "exercise41_input.txt",
        // or the input file
        ArrayList<String> namesList = new ArrayList<>();

        //declare and initialize "namesUnorderedListFile", a variable with the File class to find and incorporate the
        // "exercise41_input.txt" file into the program to scan for input
        File namesUnorderedListFile = new File("src\\main\\java\\ex41\\exercise41_input.txt");

        //declare and initialize "namesListInput", a variable with the Scanner class that reads from the "namesUnorderedListFile"
        // file so the program reads input from "exercise41_input.txt"
        Scanner namesListInput = new Scanner(namesUnorderedListFile);

        while(namesListInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextName", a String variable to hold the next line of input, or name, read from the input file
            String nextName = namesListInput.nextLine();

            //add the next name, or "nextName", to the ArrayList of currently scanned names, or "namesList"
            namesList.add(nextName);
        }

        //use Collections.sort() method to alphabetically sort/order "namesList"
        Collections.sort(namesList);

        //use the IO close method to stop the "namesListInput" Scanner and close the input file
        namesListInput.close();

        //declare and initialize "namesOrderedListFile", a variable with the File class to find and incorporate
        // the "exercise41_output.txt" file, or output file, into the program to print the ordered list of names
        File namesOrderedListFile = new File("src\\main\\java\\ex41\\exercise41_output.txt");

        //declare and initialize "namesListOutput", a variable with the FileWriter class to write output to the "namesOrderedListFile"
        // file so the program prints in "exercise41_output.txt"
        FileWriter namesListOutput = new FileWriter(namesOrderedListFile);

        //use the IO write method to print the top of the text-based table into the output file
        namesListOutput.write("\nTotal of " + namesList.size() + " names: \n");
        namesListOutput.write("------------------------\n");

        //for "the current name (e.g., first, second, fifth) in the "namesList" ArrayList until all the names have been printed"
        for (String s : namesList) {
            //print the list of records to the output file and into the text-based table
            namesListOutput.write(s); //use the IO write method to print the current name from the ArrayList and into the output file
            namesListOutput.write("\n"); //use the IO write method to print a newline character into the output file
        }

        //use the IO close method to stop the "namesListOutput" FileWriter and close the output file
        namesListOutput.close();

    }
}
