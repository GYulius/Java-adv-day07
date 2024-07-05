package example02;

// Main class to demonstrate concurrent access to a bank account
public class Main {
    public static void main(String[] args) {
        // Initial balance of the bank account
        int balance = 100;

        // Creating a BankAccount object with the initial balance
        BankAccount account = new BankAccount(balance);

        // Creating three threads to perform operations on the bank account
        Thread t1 = new Thread(() -> {
            // Thread 1 attempts to withdraw 80 units
            account.withdraw(80);
        }, "Client 1");

        Thread t2 = new Thread(() -> {
            // Thread 2 attempts to withdraw 80 units
            account.withdraw(80);
        }, "Client 2");

        Thread t3 = new Thread(() -> {
            // Thread 3 deposits 30 units
            account.deposit(30);
        }, "Client 3");

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();

        // Waiting for all threads to finish execution
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}