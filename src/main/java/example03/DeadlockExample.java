package example03;

public class DeadlockExample {
    public static void main(String[] args) {
        // Defining two resources as strings
        String resource1 = "Resource 1";
        String resource2 = "Resource 2";

        // Creating the first thread (t1)
        Thread t1 = new Thread(() -> {
            // Synchronizing on the first resource
            synchronized (resource1) {
                System.out.println("Thread 1 locked " + resource1);

                // Simulating some work with a sleep
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Attempting to lock the second resource
                synchronized (resource2) {
                    System.out.println("Thread 1 locked " + resource2);
                }
            }
        });

        // Creating the second thread (t2)
        Thread t2 = new Thread(() -> {
            // Synchronizing on the second resource
            synchronized (resource2) {
                System.out.println("Thread 2 locked " + resource2);

                // Simulating some work with a sleep
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Attempting to lock the first resource
                synchronized (resource1) {
                    System.out.println("Thread 2 locked " + resource1);
                }
            }
        });

        // Starting both threads
        t1.start();
        t2.start();

        // Waiting for both threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
