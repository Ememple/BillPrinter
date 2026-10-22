package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductLoader {
    public static ArrayList<Product> loadProducts(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./products.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                products.add(new Product(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2])));

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return products;
    }
}
