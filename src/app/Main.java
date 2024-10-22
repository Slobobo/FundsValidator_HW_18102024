package app;

import java.util.Scanner;

public class Main {

    static double balance = 3000.00;

    public static void main(String[] args) {
        try {
            balance = validateAmount(balance, getAmount());
        } catch (FundsException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static double validateAmount(double balance, double withdrawal) throws FundsException {
        if (withdrawal > balance) {
            throw new FundsException("Insufficient funds!");
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
        return balance;
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
