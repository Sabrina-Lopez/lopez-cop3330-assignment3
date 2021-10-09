package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        //declare "recordsList", a variable with the ArrayList datatype to hold the list of records from "exercise42_input.txt", or the input file
        ArrayList<String> recordsList = new ArrayList<>();

        //declare "firstNamesList", a variable with the ArrayList datatype to hold the list of first names from the records ArrayList
        ArrayList<String> firstNamesList = new ArrayList<>();

        //declare "lastNamesList", a variable with the ArrayList datatype to hold the list of last names from the records ArrayList
        ArrayList<String> lastNamesList = new ArrayList<>();

        //declare "salariesList", a variable with the ArrayList datatype to hold the list of salaries from the records ArrayList
        ArrayList<String> salariesList = new ArrayList<>();

        //declare and initialize "recordsListFile", a variable with the File class to find and incorporate the
        // "exercise42_input.txt" file into the program to scan for input
        File recordsListFile = new File("C:\\Users\\Sabrina\\IdeaProjects\\lopez-cop3330-assignment3\\src\\main\\java\\ex42\\exercise42_input.txt");

        //declare and initialize "recordsListInput", a variable with the Scanner class that reads from the "recordsListFile"
        // file so the program reads input from "exercise42_input.txt"
        Scanner recordsListInput = new Scanner(recordsListFile); //create scanner to take in the list of records


        while(recordsListInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another record to read in"
            //declare and initialize "nextRecord", a String variable to hold the next line of input, or record, read from the input file
            String nextRecord = recordsListInput.nextLine();

            //add the next name, or "nextRecord", to the ArrayList of currently scanned records, or "recordsList"
            recordsList.add(nextRecord);
        }

        //use the IO close method to stop the "recordsListInput" Scanner and close the input file
        recordsListInput.close();

        //for "the current record (e.g., first, second, fifth) in the "recordsList" ArrayList until all the records
        // have been split into individual components, which are then put into their own respective ArrayLists"
        for (String record : recordsList) {
            //declare and initialize "recordsDetails", a variable with the String datatype to hold the separated details for the current record
            String[] recordDetails = record.split(","); //split the current record details based on comma placement

            firstNamesList.add(recordDetails[0]); //place the first name or first record detail into the first names ArrayList
            lastNamesList.add(recordDetails[1]); //place the last name or second record detail into the last names ArrayList
            salariesList.add(recordDetails[2]); //place the salary or third record detail into the salaries ArrayList
        }

        //print the top of the text-based table to the System
        System.out.println("\nLast           First           Salary");
        System.out.println("--------------------------------------------");

        //for "the current record (e.g., first, second, fifth) in the "recordsList" ArrayList until all the records have been printed"
        for(int i = 0; i < recordsList.size(); i++) {
            //print the list of records to the System and into the text-based table by printing the first name, last name, and then salary of each individual
            System.out.printf("%-15s %-15s %-15s\n", firstNamesList.get(i), lastNamesList.get(i), salariesList.get(i));
        }

    }
}