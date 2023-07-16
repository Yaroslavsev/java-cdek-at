package org.example.hw_3_shoppingList;

public class Statistics {

    public void printSum(Integer[] masOfCosts, Integer[] masOfCounts) {
        Statistics statistics = new Statistics();
        long sum = statistics.countSum(masOfCosts, masOfCounts);
        System.out.println(sum);
    }

    private long countSum(Integer[] masOfCosts, Integer[] masOfCounts) {
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += (long) masOfCosts[i] * masOfCounts[i];
        }
        return sum;
    }

    public int countTopProduct(Integer[] masOfCounts) {
        int indexOfMostPopularProduct = 0;
        for (int i = 0; i < 5; i++) {
            if (masOfCounts[i] > masOfCounts[indexOfMostPopularProduct]) {
                indexOfMostPopularProduct = i;
            }
        }
        return indexOfMostPopularProduct;
    }
}