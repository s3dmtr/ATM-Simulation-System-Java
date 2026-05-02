import javax.swing.JOptionPane;

public class ATMSystemGUI {

    public static void main(String[] args) {

        // Create Account object
        Account account = new Account(1234, 1000.0);

        int attempts = 0;
        boolean isAuth = false;

        // PIN verification
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
                JOptionPane.showMessageDialog(null, "Incorrect PIN");
                attempts++;
            }
        }

        if (!isAuth) {
            JOptionPane.showMessageDialog(null, "Too many incorrect attempts. Exiting...");
            return;
        }

        int choice;

        do {
            String menu = """
                    --- ATM Menu ---
                    1. Check Balance
                    2. Deposit
                    3. Withdraw
                    4. Exit
                    """;

            String inputChoice = JOptionPane.showInputDialog(menu + "\nChoose an option:");

            if (inputChoice == null) {
                return;
            }

            choice = Integer.parseInt(inputChoice);

            if (choice == 1) {
                JOptionPane.showMessageDialog(null,
                        "Current Balance: " + account.getBalance());

            } else if (choice == 2) {
                String inputAmount = JOptionPane.showInputDialog("Enter amount to deposit:");

                if (inputAmount == null) return;

                double amount = Double.parseDouble(inputAmount);
                account.deposit(amount);

            } else if (choice == 3) {
                String inputAmount = JOptionPane.showInputDialog("Enter amount to withdraw:");

                if (inputAmount == null) return;

                double amount = Double.parseDouble(inputAmount);
                account.withdraw(amount);

            } else if (choice == 4) {
                JOptionPane.showMessageDialog(null, "Thank you for using the ATM.");

            } else {
                JOptionPane.showMessageDialog(null, "Invalid option.");
            }

        } while (choice != 4);
    }
}
