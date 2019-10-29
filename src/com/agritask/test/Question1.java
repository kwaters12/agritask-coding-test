package com.agritask.test;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Math Expression (Only addition and multiplication, no parentheses):");

        String expression =  userInput.nextLine();
        System.out.println("User math expression is: " + evaluateExpression(expression));


    }

    public static Integer evaluateExpression(String expression) throws Exception {
        int returnValue = 0, position = -1;
        String prevChar = "";
        char[] operators = new char[0];
        int[] digits = new int[0];
        String expressionModified = expression.replaceAll("\\s+", "");

        for (int i = 0; i < expressionModified.length(); i++) {
            char c = expressionModified.charAt(i);
            if (c == '+') {
                System.out.println("PLUS");
                operators[i] = '+';
                returnValue = Math.addExact(returnValue, c);
            } else if (c == '*') {
                System.out.println("Times")
                operators[i] = '*';
                prevChar = "Digit";
            } else if (Character.isDigit(c)) {
                System.out.println(c);
                operators[i] = c;

            }
        }

        return returnValue;
    }

}
