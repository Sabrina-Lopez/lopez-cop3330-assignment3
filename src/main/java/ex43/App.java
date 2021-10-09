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
        String yesResponse = "y";

        System.out.print("\nSite name: "); //ask the user for the name of the site
        Scanner siteNameInput = new Scanner(System.in); //scan the name of the site
        String siteName = siteNameInput.nextLine();

        System.out.print("Author name: "); //ask the user for the name of the author
        Scanner authorNameInput = new Scanner(System.in); //scan the name of the author
        String authorName = authorNameInput.nextLine();

        System.out.print("Do you want a folder for JavaScript (y / n)? "); //ask the user whether they want a javascript folder or not
        Scanner javaScriptFolderResponseInput = new Scanner(System.in); //scan the user's response
        String javaScriptFolderResponse = javaScriptFolderResponseInput.nextLine();

        System.out.print("Do you want a folder for CSS (y / n)? "); //ask the user whether they want a css folder or not
        Scanner cssFolderResponseInput = new Scanner(System.in); //scan the user's response
        String cssFolderResponse = cssFolderResponseInput.nextLine();

        createWebsiteFolder(siteName);
        createHtmlFile(siteName, authorName);

        if(javaScriptFolderResponse.equals(yesResponse)) {
            createJavaScriptFile(siteName);
        }

        if(cssFolderResponse.equals(yesResponse)) {
            createCssFile(siteName);
        }

    }

    public static void createWebsiteFolder(String siteName) {
        String websitePath = "src\\main\\java\\ex43\\website";
        File websiteFolder = new File (websitePath);
        boolean websiteFolderCreated = websiteFolder.mkdir();

        if(websiteFolderCreated) {
            if(!websiteFolder.exists()) {
                System.out.println("\nCreated: ./website");
            }
            else {
                System.out.println("\nThat folder exists.");
            }
        }

        String userWebsitePath = websitePath + "\\" + siteName;
        File userWebsiteFolder = new File (userWebsitePath);
        boolean userWebsiteFolderCreated = userWebsiteFolder.mkdir();

        if(userWebsiteFolderCreated) {
            if(!userWebsiteFolder.exists()) {
                System.out.println("Created: ./website/" + siteName);
            }
            else {
                System.out.println("That folder exists.");
            }
        }

    }
    public static void createHtmlFile(String siteName, String authorName) throws IOException {
        File htmlFile = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\index.html");
        boolean htmlFileCreated = htmlFile.createNewFile();
        FileWriter htmlFileOutput = new FileWriter(htmlFile);

        if(htmlFileCreated) {
            if(!htmlFile.exists()) {
                htmlFileOutput.write("<!DOCTYPE html>\n<html>\n<head>\n<title> " + siteName + " </title>\n</head>\n");
                htmlFileOutput.write("<meta> " + authorName + " <meta/>\n</html>");
                htmlFileOutput.close();

                System.out.println("Created: ./website/" + siteName + "/index.html");
            }
            else {
                System.out.println("That file exists.");
            }
        }

    }

    public static void createJavaScriptFile(String siteName) {
        File javaScriptFile = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\js");
        boolean javaScriptFileCreated = javaScriptFile.mkdir();

        if(javaScriptFileCreated) {
            if(!javaScriptFile.exists()) {
                System.out.println("Created: ./website/" + siteName + "/js/");
            }
            else {
                System.out.println("That file exists.");
            }
        }
    }

    public static void createCssFile(String siteName) {
        File cssFile = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\css");
        boolean cssFileCreated = cssFile.mkdir();

        if(cssFileCreated) {
            if(!cssFile.exists()) {
                System.out.println("Created: ./website/" + siteName + "/css/");
            }
            else {
                System.out.println("That file exists.");
            }
        }
    }
}
