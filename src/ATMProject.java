import java.util.Scanner;

public class ATMProject {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int PIN = 1234;
        int enteredPin;
        int attempts = 0;
        double balance = 1000.0;

        boolean isAuth = false;

        // PIN verification
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            enteredPin = input.nextInt();

            if (enteredPin == PIN) {
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
                System.out.println("Current Balance: " + balance);

            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double deposit = input.nextDouble();

                if (deposit > 0) {
                    balance += deposit;
                    System.out.println("Deposit successful. New Balance: " + balance);
                } else {
                    System.out.println("Invalid amount.");
                }

            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double withdraw = input.nextDouble();

                if (withdraw > 0 && withdraw <= balance) {
                    balance -= withdraw;
                    System.out.println("Withdrawal successful. New Balance: " + balance);
                } else {
                    System.out.println("Invalid amount or insufficient balance.");
                }

            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM.");

            } else {
                System.out.println("Invalid option.");
            }

        } while (choice != 4);

        input.close();
    }
}
