package ex44;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sabrina Lopez
 */

import java.nio.file.Files;
import java.util.*;
import java.io.*;
import com.google.gson.*;

public class App {

    public static void main(String[] args) throws Exception {
        //declare and initialize "gson", a variable of the Gson class to enable the implementation of the json parse
        Gson gson = new GsonBuilder().create();

        //declare and initialize "jsonFile", a variable with the File class to find and incorporate the
        // "exercise44_input.json" file into the program to scan for input for the purpose to taking in each unique word
        File jsonFile = new File("src\\main\\java\\ex44\\exercise44_input.json");

        //declare and initialize "jsonParse", a variable of the JsonParse class to parse the array from the external json file
        JsonParse jsonParse = gson.fromJson(Files.readString(jsonFile.toPath()), JsonParse.class);

        //declare "productNames", a variable with the ArrayList datatype to hold the list of product names from the records ArrayList
        ArrayList<String> productNames = new ArrayList<>();

        //declare "productPrices", a variable with the ArrayList datatype to hold the list of product prices from the records ArrayList
        ArrayList<Double> productPrices = new ArrayList<>();

        //declare "productQuantities", a variable with the ArrayList datatype to hold the list of product quantities from the records ArrayList
        ArrayList<Integer> productQuantities = new ArrayList<>();

        //for "the current product (e.g., first, second, fifth) in the List of ProductDetails until all the products
        // have been split into their individual components, which are then put into their own respective ArrayLists"
        for (ProductDetails product : jsonParse.products) {
            productNames.add(product.name); //place the product name into the product names ArrayList
            productPrices.add(product.price); //place the product price into the product prices ArrayList
            productQuantities.add(product.quantity); //place the product quantity into the product quantities ArrayList
        }

        //declare and initialize "userProductNameInput", a variable with the File class to find and incorporate the
        // "exercise44_input.json" file into the program to scan for input for the purpose to taking in the entire file as a string
        Scanner userProductNameInput = new Scanner(System.in);

        validProductChecker(userProductNameInput, productNames, productPrices, productQuantities);
    }

    public static void validProductChecker(Scanner userProductNameInput, ArrayList<String> productNames, ArrayList<Double> productPrices, ArrayList<Integer> productQuantities) {
        //declare and initialize "validProductName", a variable with the integer datatype to work as a flag to ensure the user's inputted product name
        // is a valid product name or, in other words, is within the json list of products that are in stock
        int validProductName = 1; //initialized as invalid till proven valid

        while(validProductName == 1) { //while the user's inputted product name is invalid
            System.out.print("\nWhat is the product name? "); //output to the user the question of what product name they are looking for
            String userProductName = userProductNameInput.next(); //store the user's inputted product name response

            //for "the current product (e.g., first, second, fifth) in the product names ArrayList until all the products
            // have been compared with the user's inputted product name to find whether the item the user is looking is in stock"
            for(int i = 0; i < productNames.size(); i++) {
                if (userProductName.equals(productNames.get(i))) { //if the user's inputted product name matches a product in the inventory
                    validProductName = 0; //the flag is changed to indicate the product is valid and to stop the while loop

                    //output to the user the name, price, and quantity of the product that they are looking for in the available stock
                    System.out.printf("\nName: %s\nPrice: %.2f\nQuantity: %d\n", productNames.get(i), productPrices.get(i), productQuantities.get(i));
                    break; //stop the for loop
                }
            }

            if(validProductName == 1) { //if the flag is never changed, meaning the user's product name did not match any of the product names in stock
                //output to the user that the item they are looking for is not in the inventory
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    //declare "ProductDetails", a public static class to store the details/components for each product in the external json file's array
    public static class ProductDetails {
        String name; //declare and store the name of the product
        double price; //declare and store the price of the product
        int quantity; //declare and store the quantity of the product
    }

    //declare "JsonParse", a public static class to store the list of ProductDetails
    public static class JsonParse {
        //declare "products", a variable of the List datatype to hold the json array and its details/components for each product (i.e., name, price, quantity)
        List<ProductDetails> products;
    }
}