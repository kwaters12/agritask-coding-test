package com.agritask.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {
    public static void getInput() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Math Expression (Only addition and multiplication, no parentheses):");

        String expression =  userInput.nextLine();
        System.out.println("The evaluated math expression is: " + evaluateExpression(expression));
        getInput();
    }

    public static void main(String[] args) {
        getInput();
    }


    public static Integer evaluateExpression(String expression) throws IllegalArgumentException {
        int returnValue, skip = 0;
        List<String> operators = new ArrayList();
        List<String> digits = new ArrayList();
        String str = expression.replaceAll("\\s+", "");

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (skip > 0) {
                skip--;
            } else {
                if (c == '+') {
                    operators.add("+");
                } else if (c == '*') {
                    operators.add("*");
                } else if (Character.isDigit(c)) {
                    int j = i + 1;
                    skip = 0;

                    digits.add(Character.toString(c));
                    while (j < str.length()) {
                        if (Character.isDigit(str.charAt(j))) {
                            j++;
                            skip += 1;
                            digits.set(digits.size() - 1, str.substring(i, j));
                        } else {
                            break;
                        }
                    }

                }
            }
        }

        returnValue = Integer.parseInt(digits.get(0));

        if (operators.size() != digits.size() - 1) {
            throw new IllegalArgumentException("Too many operators have been provided");
        }

        for (int k = 0; k < digits.size() - 1; k++) {

            if (k < operators.size() && operators.get(k) == "*") {
                returnValue *= Integer.parseInt(digits.get(k+1));
            } else if (k < operators.size() && operators.get(k) == "+") {
                returnValue += Integer.parseInt(digits.get(k+1));
            }
        }

        return returnValue;
    }

}
