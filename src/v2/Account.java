public class Account {

    // Attributes (Encapsulation)
    private int pin;
    private double balance;

    // Constructor
    public Account(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    // Check PIN
    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New Balance: " + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }
}
