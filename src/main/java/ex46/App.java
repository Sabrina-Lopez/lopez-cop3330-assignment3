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

        File wordInputFile = new File("src\\main\\java\\ex46\\exercise46_input.txt");

        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add(0, null);
        Scanner wordsInput = new Scanner(wordInputFile);

        while(wordsInput.hasNext()) { // while "Scanner hasNextLine boolean method to know if the input file has another name to read in"
            String nextWord = wordsInput.next();
            int validNewWord = 0;
            for (String s : wordsList) {
                if (nextWord.equals(s)) {
                    validNewWord = 1;
                    break;
                }
            }

            if(validNewWord == 0) {
                wordsList.add(nextWord);
            }
        }

        wordsList.remove(0);
        wordsInput.close();

        String wordsAppended = wordsAppendedFunction(wordInputFile);

        ArrayList<Integer> wordOccurrences = new ArrayList<>();

        for (String s : wordsList) {
            wordOccurrences.add(StringUtils.countMatches(wordsAppended, s));
        }

        if(wordsList.size() > 1) {
            for (int i = 0; i < (wordsList.size() - 1); i++) {
                for (int j = 0; j < (wordsList.size() - i - 1); j++) {
                    if ((wordOccurrences.get(j)) > (wordOccurrences.get(j + 1))) {
                        String tempWord = wordsList.get(j);
                        int tempNumOccurrences = wordOccurrences.get(j);

                        wordsList.set(j, wordsList.get(j + 1));
                        wordOccurrences.set(j, wordOccurrences.get(j + 1));

                        wordsList.set((j + 1), tempWord);
                        wordOccurrences.set((j + 1), tempNumOccurrences);
                    }
                }
            }
        }

        for(int i = (wordsList.size() - 1); i >= 0 ; i--) {
            System.out.print("\n" + wordsList.get(i) + ": ");

            for(int j = 0; j < wordOccurrences.get(i); j++) {
                System.out.print("* ");
            }
        }

        System.out.print("\n");
    }

    public static String wordsAppendedFunction(File wordInputFile) throws FileNotFoundException {
        String wordsAppended = null;
        Scanner wordsAppendedInput = new Scanner(wordInputFile);

        while(wordsAppendedInput.hasNextLine()) {
            String nextLine = wordsAppendedInput.nextLine();
            wordsAppended = wordsAppended + nextLine;
        }

        assert wordsAppended != null;
        wordsAppended = wordsAppended.replace("null","");
        wordsAppendedInput.close();

        return wordsAppended;
    }
}