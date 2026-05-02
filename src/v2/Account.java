package v2;

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
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Withdraw
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
