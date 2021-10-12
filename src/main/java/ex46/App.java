package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.*;

public class App {
    public static void main(String[] args) throws IOException {

        //declare and initialize "wordInputFile", a variable with the File class to get words/input from the file
        File wordInputFile = new File("src\\main\\java\\ex46\\exercise46_input.txt");

        //declare "wordsList", a variable with the ArrayList datatype to hold the different words from the "exercise46_input.txt" file
        ArrayList<String> wordsList = new ArrayList<>();

        //initialize the first index of the arraylist of words
        wordsList.add(0, null);

        //declare and initialize "wordsInput", a variable with the Scanner class that reads the lines of input from "exercise46_input.txt"
        Scanner wordsInput = new Scanner(wordInputFile);

        while(wordsInput.hasNext()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextWord", a String variable to hold the next word from "exercise46_input.txt"
            String nextWord = wordsInput.next();

            //declare and initialize flag to check if the scanned word is unique to the other words currently in the words ArrayList
            int validNewWord = 0; //new word initialized to be a unique word

            //for "the current product (e.g., first, second, fifth) in the word from the words ArrayList until all the words
            // have been compared to the new word to ensure the new word is unique
            for (String s : wordsList) {
                if (nextWord.equals(s)) { //if the newly scanned word equals a word in the words ArrayList
                    validNewWord = 1; //the new word is not unique
                    break; //stop the for loop as the new word has shown to not be unique in comparison to another word in the words ArrayList
                }
            }

            if(validNewWord == 0) { //if the new word is still unique after being compared to all the current words in the words ArrayList
                wordsList.add(nextWord); //add the new word to the list of unique words
            }
        }

        wordsList.remove(0); //remove the initial null at the start of the words ArrayList
        wordsInput.close(); //close the input file via ending the Scanner variable

        //declare and initialize "wordsAppended", a String variable to hold the lines of the input file as a single string
        String wordsAppended = wordsAppendedFunction(wordInputFile);

        //declare and initialize "wordOccurrences", a variable with the ArrayList datatype to hold the number of times each word occurs in the input file
        ArrayList<Integer> wordOccurrences = new ArrayList<>();

        //for "the current product (e.g., first, second, fifth) in the word from the words ArrayList until all the words
        // have had their number of occurrences in the input file found and stored in the word occurrences ArrayList
        for (String s : wordsList) {
            //count the number of occurrences of the current word from the words ArrayList and store it into the word Occurrences ArrayList
            wordOccurrences.add(StringUtils.countMatches(wordsAppended, s));
        }

        //bubble sort to sort the values of the word occurrences ArrayList from least to greatest, shifting the words in the indexes
        // of the words ArrayList simultaneously to ensure the word and its number occurrences are in the same index between the two different ArrayLists
        if(wordsList.size() > 1) { //if the number of words in the ArrayList is greater than 1

            //nested for "the current product (e.g., first, second, fifth) in the word from the words ArrayList until all the word occurrence values
            // have had their number of occurrences sorted from least to greatest with their respective words shifted along with them
            for (int i = 0; i < (wordsList.size() - 1); i++) {
                for (int j = 0; j < (wordsList.size() - i - 1); j++) {
                    if ((wordOccurrences.get(j)) > (wordOccurrences.get(j + 1))) { //if the current word occurrence value is greater than the next occurrence value
                        //declare and initialize a temp variable to store the current word occurrence value
                        String tempWord = wordsList.get(j);

                        //declare and initialize a temp variable to store the current word corresponding with the word occurrence value
                        int tempNumOccurrences = wordOccurrences.get(j);

                        //swap the two words between their respective indexes
                        wordsList.set(j, wordsList.get(j + 1));
                        wordsList.set((j + 1), tempWord);

                        //swap the two word occurrence values between their respective indexes
                        wordOccurrences.set(j, wordOccurrences.get(j + 1));
                        wordOccurrences.set((j + 1), tempNumOccurrences);
                    }
                }
            }
        }

        //nested for "the current word (e.g., first, second, fifth) from the words ArrayList until all the words and
        // their respective number of occurrences, as asterisks/stars, are printed backwards out to the system for the user
        for(int i = (wordsList.size() - 1); i >= 0 ; i--) {
            System.out.print("\n" + wordsList.get(i) + ": "); //output to the user the current word

            for(int j = 0; j < wordOccurrences.get(i); j++) {
                System.out.print("* "); //output to the user the current word's number of occurrences as asterisks/stars
            }
        }

        //output to the user a newline character to create a space between the overall output and the program's exit code
        System.out.print("\n");
    }

    //declare "wordsAppendedFunction", a public static String function to append the lines of the input file into a single string
    public static String wordsAppendedFunction(File wordInputFile) throws FileNotFoundException {
        //declare and initialize "wordsAppended", a String variable to hold the lines of the input file as a single string
        String wordsAppended = null;

        //declare and initialize "wordsInput", a variable with the Scanner class that reads the lines of input from "exercise46_input.txt"
        Scanner wordsAppendedInput = new Scanner(wordInputFile);

        while(wordsAppendedInput.hasNextLine()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            //declare and initialize "nextLine", a String variable to hold the next line from "exercise46_input.txt"
            String nextLine = wordsAppendedInput.nextLine();
            wordsAppended = wordsAppended + nextLine; //add the next line from the input file to the current string
        }

        //assert true if the string is not empty, false if otherwise
        assert wordsAppended != null;

        //remove the null string from the words appended from the input file
        wordsAppended = wordsAppended.replace("null","");
        wordsAppendedInput.close(); //use the IO close method to stop the "wordsAppendedInput" Scanner and close the input file

        return wordsAppended; //return wordsAppended now that it has all the lines of the input file appended together into a single string
    }
}