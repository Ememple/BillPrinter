package org.example;

import java.io.*;
import java.util.ArrayList;

public class ProductLoader {
    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> productList = new ArrayList<>();

        try (InputStream resourceInputStream = Main.class.getClassLoader().getResourceAsStream("products.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(resourceInputStream))) {

            if (resourceInputStream == null) {
                System.out.println("Product resource file could not be found.");
                return productList;
            }

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] productFields = currentLine.split(",");
                productList.add(new Product(Integer.parseInt(productFields[0]), productFields[1], Double.parseDouble(productFields[2])));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return productList;
    }
}
