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
        //declare and initialize "gson", a variable of the Gson class to enable the implementation of the Json Parse
        Gson gson = new GsonBuilder().create();
        File jsonFile = new File("src\\main\\java\\ex44\\exercise44_input.json");
        JsonParse jsonParse = gson.fromJson(Files.readString(jsonFile.toPath()), JsonParse.class);

        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();

        for (ProductDetails product : jsonParse.products) {
            productNames.add(product.name);
            productPrices.add(product.price);
            productQuantities.add(product.quantity);
        }

        Scanner userProductNameInput = new Scanner(System.in);
        int validProductName = 1;

        while(validProductName == 1) {
            System.out.print("\nWhat is the product name? ");
            String userProductName = userProductNameInput.next();

            for(int i = 0; i < productNames.size(); i++) {
                if (userProductName.equals(productNames.get(i))) {
                    validProductName = 0;
                    System.out.printf("\nName: %s\nPrice: %.2f\nQuantity: %d\n", productNames.get(i), productPrices.get(i), productQuantities.get(i));
                    break;
                }
            }

            if(validProductName == 1) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    public static class ProductDetails {
        String name;
        double price;
        int quantity;
    }

    public static class JsonParse {
        List<ProductDetails> products;
    }
}