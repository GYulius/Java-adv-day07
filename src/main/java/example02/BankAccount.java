// BankAccount class that provides synchronized methods for deposit and withdraw operations
package example02;

public class BankAccount {

    // Balance of the bank account
    private int balance;

    // Constructor to initialize the bank account with a given balance
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized method to deposit an amount into the account
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposits " + amount + " and the balance is " + balance);
    }

    // Synchronized method to withdraw an amount from the account
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempts to withdraw " + amount);
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " verified balance: sufficient and the balance is " + balance);
            try {
                // Simulating some processing time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdraws " + amount + " and the balance is now: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " verified balance: insufficient and the balance is " + balance);
            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amount + " due to insufficient balance");
        }
    }
}