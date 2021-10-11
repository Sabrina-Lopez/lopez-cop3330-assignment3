package ex43;

import org.junit.Test;
import java.io.*;
import java.io.IOException;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void main() throws IOException {

            //declare and initialize "siteName", a String variable to hold an example name for the site
        String siteName = "userSiteName";
            //declare and initialize "siteName", a String variable to hold an example name for the author
        String authorName = "userAuthorName";

            //declare and initialize "websiteFile", a String variable to hold the file path to the soon-to-be-created website folder
        String websiteFile = "src\\main\\java\\ex43\\website";
            //declare and initialize "websiteFolder", a variable with the File class to establish the location for the website folder
        File websiteFolder = new File (websiteFile);
            //declare and initialize "websiteFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the website folder
        boolean websiteFolderCreated = websiteFolder.mkdir();
        assertTrue(websiteFolderCreated); //assert whether the website folder was created or not

            //declare and initialize "userWebsitePath", a String variable to hold the file path to the soon-to-be-created folder for the user's site
        String userWebsiteFile = websiteFile + "\\" + siteName;
            //declare and initialize "userWebsiteFolder", a variable with the File class to establish the location for the user's site folder
        File userWebsiteFolder = new File (userWebsiteFile);
            //declare and initialize "userWebsiteFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the user's site folder
        boolean userWebsiteFolderCreated = userWebsiteFolder.mkdir();
        assertTrue(userWebsiteFolderCreated); //assert whether the user's site folder was created or not

            //declare and initialize "htmlFile", a variable with the File class to establish the location for the html file
        File htmlFile = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\index.html");
            //declare and initialize "htmlFileCreated, a variable with the boolean datatype to create and or ensure the existence of the html file
        boolean htmlFileCreated = htmlFile.createNewFile();
        assertTrue(htmlFileCreated); //assert whether the html file was created or not
            //declare and initialize "htmlFileOutput", a variable with the FileWriter class to write the html code in the html file
        FileWriter htmlFileOutput = new FileWriter(htmlFile);
        if(htmlFile.exists()) { //if the html file was created
            //output to the newly created html file the html code, including the site name in title tags and the author name in meta tags
            htmlFileOutput.write("<!DOCTYPE html>\n<html>\n<head>\n<title> " + siteName + " </title>\n</head>\n");
            htmlFileOutput.write("<meta> " + authorName + " <meta/>\n</html>");
        }
        htmlFileOutput.close(); //close the html file via ending the File Writer variable
        long htmlFileLength = htmlFile.length(); //declare and initialize "htmlFileLength" with the long datatype to find length of html file
        assertTrue(htmlFileLength != 0); //assert true if the html file is not empty, false if otherwise

            //declare and initialize "javascriptFolder", a variable with the File class to establish the location for the javascript folder
        File javaScriptFolder = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\js");
            //declare and initialize "javaScriptFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the javascript folder
        boolean javaScriptFolderCreated = javaScriptFolder.mkdir();
        assertTrue(javaScriptFolderCreated); //assert whether the javascript folder was created or not

            //declare and initialize "cssFolder", a variable with the File class to establish the location for the css folder
        File cssFolder = new File ("src\\main\\java\\ex43\\website\\" + siteName + "\\css");
            //declare and initialize "cssFolderCreated, a variable with the boolean datatype to create and or ensure the existence of the css folder
        boolean cssFolderCreated = cssFolder.mkdir();
        assertTrue(cssFolderCreated); //assert whether the css folder was created or not
    }
}