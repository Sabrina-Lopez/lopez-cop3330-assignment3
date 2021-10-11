package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.util.*;
import java.io.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
            //declare and initialize the string to compare with the user's response to whether they want a javascript and or css folder to be created
        String yesResponse = "y";

            //ask the user what they want to name their site
        System.out.print("\nSite name: ");
            //declare and initialize "siteNameInput", a variable with the Scanner class that reads the user's inputted site name from the system
        Scanner siteNameInput = new Scanner(System.in);
            //declare and initialize "siteName", a String variable to hold the user's desired name for the site
        String siteName = siteNameInput.nextLine();

            //ask the user what the author's name is
        System.out.print("Author name: ");
            //declare and initialize "authorNameInput", a variable with the Scanner class that reads the user's inputted author name from the system
        Scanner authorNameInput = new Scanner(System.in);
            //declare and initialize "authorName", a String variable to hold the user's desired name for the site
        String authorName = authorNameInput.nextLine();

            //ask the user whether they would like the program to create a javascript folder or not
        System.out.print("Do you want a folder for JavaScript (y / n)? ");
            //declare and initialize "javaScriptFolderResponseInput", a variable with the Scanner class that reads the user's inputted decision from the system
        Scanner javaScriptFolderResponseInput = new Scanner(System.in);
            //declare and initialize "javaScriptFolderResponse", a String variable to hold the user's decision on creating a javascript folder or not
        String javaScriptFolderResponse = javaScriptFolderResponseInput.nextLine();

            //ask the user whether they would like the program to create a css folder or not
        System.out.print("Do you want a folder for CSS (y / n)? ");
            //declare and initialize "cssFolderResponseInput", a variable with the Scanner class that reads the user's inputted decision from the system
        Scanner cssFolderResponseInput = new Scanner(System.in);
            //declare and initialize "cssFolderResponse", a String variable to hold the user's decision on creating a css folder or not
        String cssFolderResponse = cssFolderResponseInput.nextLine();

        createWebsiteFolder(siteName); //call the function to create the website folder and input it into the directory
        createHtmlFile(siteName, authorName); //call the function to create the html file for the website, fill it with the necessary html code, and input it into the directory

        if(javaScriptFolderResponse.equals(yesResponse)) { //if the user inputs a "y" or yes response to creating a javascript folder
            createJavaScriptFolder(siteName); //call the function to create the javascript folder and input it into the directory
        }

        if(cssFolderResponse.equals(yesResponse)) { //if the user inputs a "y" or yes response to creating a css folder
            createCssFolder(siteName); //call the function to create the css folder and input it into the directory
        }

    }

        //declare the function to create the website folder, taking in the user's site name into the parameters to create the folder using said site name
    public static void createWebsiteFolder(String siteName) {
            //declare and initialize "websiteFile", a String variable to hold the file path to the soon-to-be-created website folder
        String websiteFile = "src\\main\\java\\ex43\\website";
            //declare and initialize "websiteFolder", a variable with the File class to establish the location for the website folder
        File websiteFolder = new File (websiteFile);
            //declare and initialize "websiteFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the website folder
        boolean websiteFolderCreated = websiteFolder.mkdir();

        if(websiteFolderCreated) { //if the website folder is successfully inside the directory
            if(websiteFolder.exists()) { //if the website folder was created
                System.out.println("\nCreated: ./website"); //output to the system that the website folder has been created
            }
        }
            //declare and initialize "userWebsitePath", a String variable to hold the file path to the soon-to-be-created folder for the user's site
        String userWebsiteFile = websiteFile + "\\" + siteName;
            //declare and initialize "userWebsiteFolder", a variable with the File class to establish the location for the user's site folder
        File userWebsiteFolder = new File (userWebsiteFile);
            //declare and initialize "userWebsiteFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the user's site folder
        boolean userWebsiteFolderCreated = userWebsiteFolder.mkdir();

        if(userWebsiteFolderCreated) { //if the user's site folder is successfully inside the directory
            if(userWebsiteFolder.exists()) { //if the user's site folder was created
                System.out.println("Created: ./website/" + siteName); //output to the system that the user's site folder has been created
            }
        }
    }

        //declare the function to create the html file, taking in the user's site name into the parameters to create the file using said site name
        // and taking in the author's name to incorporate both the site and author names into the file's html code
    public static void createHtmlFile(String siteName, String authorName) throws IOException {
            //declare and initialize "htmlFile", a variable with the File class to establish the location for the html file
        File htmlFile = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\index.html");
            //declare and initialize "htmlFileCreated, a variable with the boolean datatype to create and or ensure the existence of the html file
        boolean htmlFileCreated = htmlFile.createNewFile();
            //declare and initialize "htmlFileOutput", a variable with the FileWriter class to write the html code in the html file
        FileWriter htmlFileOutput = new FileWriter(htmlFile);

        if(htmlFileCreated) { //if the html file is successfully inside the directory
            if(htmlFile.exists()) { //if the html file was created
                    //output to the newly created html file the html code, including the site name in title tags and the author name in meta tags
                htmlFileOutput.write("<!DOCTYPE html>\n<html>\n<head>\n<title> " + siteName + " </title>\n</head>\n");
                htmlFileOutput.write("<meta> " + authorName + " <meta/>\n</html>");

                System.out.println("Created: ./website/" + siteName + "/index.html"); //output to the system that the html file has been created
            }
        }

        htmlFileOutput.close(); //close the html file via ending the File Writer variable
    }

        //declare the function to create the javascript folder, taking in the user's site name into the parameters to create the folder using said site name
    public static void createJavaScriptFolder(String siteName) {
            //declare and initialize "javascriptFolder", a variable with the File class to establish the location for the javascript folder
        File javaScriptFolder = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\js");
            //declare and initialize "javaScriptFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the javascript folder
        boolean javaScriptFolderCreated = javaScriptFolder.mkdir();

        if(javaScriptFolderCreated) { //if the javascript folder is successfully inside the directory
            if(javaScriptFolder.exists()) { //if the javascript folder was created
                System.out.println("Created: ./website/" + siteName + "/js/"); //output to the system that the javascript folder has been created
            }
        }
    }

        //declare the function to create the css folder, taking in the user's site name into the parameters to create the folder using said site name
    public static void createCssFolder(String siteName) {
            //declare and initialize "cssFolder", a variable with the File class to establish the location for the css folder
        File cssFolder = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\css");
            //declare and initialize "cssFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the css folder
        boolean cssFolderCreated = cssFolder.mkdir();

        if(cssFolderCreated) { //if the css folder is successfully inside the directory
            if(cssFolder.exists()) { //if the css folder was created
                System.out.println("Created: ./website/" + siteName + "/css/"); //output to the system that the css folder has been created
            }
        }
    }
}
