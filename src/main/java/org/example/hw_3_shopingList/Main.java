package org.example.hw_3_shopingList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] masOfProducts = new String[5];
        Integer[] masOfCosts = new Integer[5];
        Integer[] masOfCounts = new Integer[5];

        int count = 0;
        while (sc.hasNext() && count < 5) {
            String s = sc.nextLine();
            if ("exit".equals(s)) {
                break;
            }
            count++;

            String[] parts = s.split(" ");

            if (parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            Integer productCost;
            Integer productCount;

            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < 5; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            if (!productAlreadyExists) {
                for (int i = 0; i < 5; i++) {
                    if (masOfProducts == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                    }
                }
            }
        }

        String[] sortedProducts = new String[5];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, 5);

        Arrays.sort(sortedProducts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        System.out.println(Arrays.toString(sortedProducts));

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += masOfCosts[i] * masOfCounts[i];
        }
        System.out.println(sum);

        for (int j = 0; j < 3; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < 5; i++) {
                if (masOfCounts[i] > masOfCosts[indexOfMostPopularProduct]) {
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);
            masOfProducts[indexOfMostPopularProduct] = null;
            masOfCounts[indexOfMostPopularProduct] = 0;
            masOfCosts[indexOfMostPopularProduct] = 0;
        }
    }
}