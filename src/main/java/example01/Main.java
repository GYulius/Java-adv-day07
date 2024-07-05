package example01;

// Main class to demonstrate the usage of MyThread class
public class Main {

    public static void main(String[] args) {

        // Creating three MyThread objects with different thread numbers
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        MyThread thread3 = new MyThread(3);

        // Starting the three threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Sleep for 2 seconds to let the threads run
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted in main");
        }

        // Interrupting the second thread
        thread2.interrupt();

        // Waiting for all threads to finish execution
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Indicating that the main thread has finished
        System.out.println("Main finished");
    }
}