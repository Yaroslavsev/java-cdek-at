package org.example.hw_3_shoppingList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int SHOPPING_LIST_SIZE = 5;
        final int NUMBER_OF_TOP_PRODUCTS = 3;
        final int INPUT_LENGTH = 3;

        Scanner sc = new Scanner(System.in);

        String[] masOfProducts = new String[SHOPPING_LIST_SIZE];
        Integer[] masOfCosts = new Integer[SHOPPING_LIST_SIZE];
        Integer[] masOfCounts = new Integer[SHOPPING_LIST_SIZE];

        String productName;
        int productCost;
        int productCount;

        Check check = new Check(INPUT_LENGTH);
        Sort sort = new Sort(SHOPPING_LIST_SIZE);
        Statistics statistics = new Statistics();

        int count = 0;
        while (count < SHOPPING_LIST_SIZE) {
            String s = sc.nextLine();
            if ("exit".equals(s)) {
                break;
            }

            String[] parts = s.split(" ");

            if (check.checkLength(parts)) {
                continue;
            }

            productName = parts[0];

            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            if (check.isProductAlreadyExists(masOfProducts, productName)) {
                for (int i = 0; i < SHOPPING_LIST_SIZE; i++) {
                    if (productName.equals(masOfProducts[i])) {
                        masOfCosts[i] = productCost;
                        masOfCounts[i] += productCount;
                    }
                }
            }

            if (!check.isProductAlreadyExists(masOfProducts, productName)) {
                for (int i = 0; i < SHOPPING_LIST_SIZE; i++) {
                    if (masOfProducts[i] == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                        count++;
                        break;
                    }
                }
            }
        }

        sort.printSortedProducts(masOfProducts, SHOPPING_LIST_SIZE);

        statistics.printSum(masOfCosts, masOfCounts);

        for (int j = 0; j < NUMBER_OF_TOP_PRODUCTS; j++) {
            int indexOfMostPopularProduct = statistics.countTopProduct(masOfCounts);
            System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);

            masOfProducts[indexOfMostPopularProduct] = null;
            masOfCounts[indexOfMostPopularProduct] = 0;
            masOfCosts[indexOfMostPopularProduct] = 0;
        }
    }
}