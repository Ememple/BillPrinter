package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    public static ArrayList<BillItem> userInputForItems(){
        ArrayList<Product> products = ProductLoader.loadProducts();
        ArrayList<BillItem> billItems = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Zadejte ID");
            String input = sc.nextLine();
            for (int i = 0; i < products.size(); i++) {
                if ((Integer.parseInt(input)) == products.get(i).getId()) {
                    System.out.println("Zadejte počet");
                    input = sc.nextLine();
                    billItems.add(new BillItem(products.get(i),Integer.parseInt(input)));
                }
            }
            System.out.println("Je toto vše?");
            input = sc.nextLine();
            if (input.equals("ano"))break;
        }



        return billItems;
    }

}
