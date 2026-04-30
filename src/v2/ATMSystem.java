// Version 2 - OOP ATM System

import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Account object
        Account account = new Account(1234, 1000.0);

        int attempts = 0;
        boolean isAuth = false;

        // PIN verification
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = input.nextInt();

            if (account.checkPin(enteredPin)) {
                isAuth = true;
                break;
            } else {
                System.out.println("Incorrect PIN");
                attempts++;
            }
        }

        if (!isAuth) {
            System.out.println("Too many incorrect attempts. Exiting...");
            return;
        }

        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: " + account.getBalance());

            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amount = input.nextDouble();
                account.deposit(amount);

            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amount = input.nextDouble();
                account.withdraw(amount);

            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");

            } else {
                System.out.println("Invalid option.");
            }

        } while (choice != 4);

        input.close();
    }
}
