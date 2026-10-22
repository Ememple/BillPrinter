package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Product> loadProducts(){
        ArrayList<Product> products = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./products.txt"));
            String line;
            while ((line = br.readLine()) != null) {

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return products;
    }
}
