package org.example.hw_3_shoppingList;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    int shoppingListSize;

    public Sort(int shoppingListSize) {
        this.shoppingListSize = shoppingListSize;
    }

    public void printSortedProducts(String[] unsortedProducts, int shoppingListSize){
        Sort sort = new Sort(shoppingListSize);
        String[] sortedProducts = sort.sortProducts(unsortedProducts, shoppingListSize);
        System.out.println(Arrays.toString(sortedProducts));
    }

    private String[] sortProducts(String[] unsortedProducts, int shoppingListSize){
        String[] sortedProducts = new String[shoppingListSize];

        System.arraycopy(unsortedProducts, 0, sortedProducts, 0, 5);
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
        return sortedProducts;
    }
}
