package RealEstateManager;

public class BankAccount {
    private double balance;

    public BankAccount(double balance)
    {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(balance < amount) {
            throw new InsufficientFundsException("Insufficient funds! Please find a transcaction within your budget.");
        }
        else {
            balance -= amount;
        }
    }
}
