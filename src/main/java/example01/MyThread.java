package example01;

// MyThread class extends Thread to create a custom thread
public class MyThread extends Thread {
    private int threadNumber;

    // Constructor to initialize the thread with a specific number
    public MyThread(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    // Overriding the run method to define the behavior of the thread
    @Override
    public void run() {
        System.out.println("Thread number " + threadNumber + " started");
        try {
            // Loop to print the thread number and the value of i five times
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread number: " + threadNumber + " has i = " + i);
                // Sleep for 1 second to simulate some work
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Handle interruption and exit the thread
            System.out.println("Thread number " + threadNumber + " was interrupted");
            return;
        }
        System.out.println("Thread number " + threadNumber + " terminated");
    }
}