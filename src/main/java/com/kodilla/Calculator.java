package com.kodilla;
import java.util.Scanner;
public class Calculator {

    public static void main(String[] args) {

        System.out.print("Podaj liczbe: ");
        int previousResult = getInt();
        String ifEnd;
        boolean ifWrongOperation;
        do {
            int newResult = 0;
            ifWrongOperation = false;
            System.out.print("Podaj dzialanie (* / - +): ");
            String operation = getString();
            System.out.print("Podaj kolejna liczbe: ");
            int secondNumber = getInt();

            switch (operation) {
                case "+":
                    newResult = previousResult + secondNumber;
                    break;
                case "-":
                    newResult = previousResult - secondNumber;
                    break;
                case "*":
                    newResult = previousResult * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        ifWrongOperation = true;
                        System.out.println("Nie moge podzielic przez 0.");
                    } else {
                        newResult = previousResult / secondNumber;
                    }
                    break;
                default:
                    ifWrongOperation = true;
                    System.out.println("Nieprawidlowa operacja.");
            }

            if (!ifWrongOperation) {
                System.out.println(
                        previousResult + " " + operation + " " + secondNumber + " = " + newResult
                );
                previousResult = newResult;
            }
            System.out.println("Czy chcesz zakonczyc program? [t/n]");
            ifEnd = getString();
        } while (!ifEnd.equals("t"));
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    public static String getString() {
        return new Scanner(System.in).next();
    }
}
