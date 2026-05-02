package v2;

import javax.swing.JOptionPane;

public class ATMSystemGUI {

    public static void main(String[] args) {

        // Create Account
        Account account = new Account(1234, 1000.0);

        int attempts = 0;
        boolean isAuth = false;

        // PIN Verification
        while (attempts < 3) {
            String inputPin = JOptionPane.showInputDialog("Enter your PIN:");

            if (inputPin == null) {
                return; // User pressed cancel
            }

            int enteredPin = Integer.parseInt(inputPin);

            if (account.checkPin(enteredPin)) {
                isAuth = true;
                break;
            } else {
                attempts++;
                JOptionPane.showMessageDialog(null, "Incorrect PIN");
            }
        }

        if (!isAuth) {
            JOptionPane.showMessageDialog(null, "Too many failed attempts.");
            return;
        }

        // ATM Menu Loop
        while (true) {

            String option = JOptionPane.showInputDialog(
                    "ATM Menu:\n" +
                    "1. Check Balance\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Exit\n\n" +
                    "Choose an option:"
            );

            if (option == null) {
                return;
            }

            switch (option) {

                case "1":
                    JOptionPane.showMessageDialog(null,
                            "Current Balance: " + account.getBalance());
                    break;

                case "2":
                    String depositInput = JOptionPane.showInputDialog("Enter amount to deposit:");

                    if (depositInput == null) break;

                    double depositAmount = Double.parseDouble(depositInput);

                    if (account.deposit(depositAmount)) {
                        JOptionPane.showMessageDialog(null,
                                "Deposit successful.\nNew Balance: " + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Invalid amount.");
                    }
                    break;

                case "3":
                    String withdrawInput = JOptionPane.showInputDialog("Enter amount to withdraw:");

                    if (withdrawInput == null) break;

                    double withdrawAmount = Double.parseDouble(withdrawInput);

                    if (account.withdraw(withdrawAmount)) {
                        JOptionPane.showMessageDialog(null,
                                "Withdrawal successful.\nNew Balance: " + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Invalid amount or insufficient balance.");
                    }
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null,
                            "Thank you for using the ATM.");
                    return;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid option.");
            }
        }
    }
}
