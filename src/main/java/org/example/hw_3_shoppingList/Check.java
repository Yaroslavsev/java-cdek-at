package org.example.hw_3_shoppingList;

public class Check {
    int inputLength;

    public Check(int inputLength) {
        this.inputLength = inputLength;
    }

    public boolean checkLength(String[] input) {
        if (input.length != inputLength) {
            System.out.println("Wrong number of arguments! Retry!");
            return true;
        }
        return false;
    }

    public boolean isProductAlreadyExists(String[] masOfProducts, String productName) {
        boolean productAlreadyExists = false;
        for (int i = 0; i < masOfProducts.length; i++) {
            if (productName.equals(masOfProducts[i])) {
                productAlreadyExists = true;
                break;
            }
        }
        return productAlreadyExists;
    }
}