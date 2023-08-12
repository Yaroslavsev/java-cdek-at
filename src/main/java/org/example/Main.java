package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        double result;

        int firstNumber = 0;
        int secondNumber = 0;

        while (!"q".equals(userInput)) {

            try {
                System.out.print("Enter first number: ");
                if (scanner.hasNextInt()) {
                    firstNumber = scanner.nextInt();
                } else {
                    System.out.println("Wrong first number input data!");
                    firstNumber = scanner.nextInt();
                    continue;
                }

                System.out.print("Enter operation (+, -, *, /, !): ");
                userInput = scanner.next();

                System.out.print("Enter second number: ");
                if (scanner.hasNextInt()) {
                    secondNumber = scanner.nextInt();
                } else {
                    System.out.println("Wrong second number input data!");
                    secondNumber = scanner.nextInt();
                    continue;
                }

                switch (userInput) {
                    case "+":
                        result = plus(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = minus(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = ymn(firstNumber, secondNumber);
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            continue;
                        }
                        result = del(firstNumber, secondNumber);
                        break;
                    case "!":
                        result = fact(firstNumber);
                        break;
                    default:
                        result = 0;
                        break;
                }

                System.out.println(result);

            } catch (InputMismatchException ex) {
                userInput = scanner.next();
                continue;
            }
        }
    }

    private static int plus(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }

    private static int minus(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }

    private static int ymn(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }

    private static int del(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }

    private static int fact(int numberOne) {
        int res = 1;
        for (int i = 1; i <= numberOne; i++) {
            res *= i;
        }
        return res;
    }
}