package FinalOOPLab;

import java.util.Scanner;

class CounterThread extends Thread {
    private int start;
    private int end;

    public CounterThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + ": Counting numbers from " + start + " to " + end + ".....");
    }
}

public class NumberCounter {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total count of numbers: ");
        int totalCount = scanner.nextInt();

        System.out.print("Enter number of threads: ");
        int numThreads = scanner.nextInt();

        int numbersPerThread = totalCount / numThreads;
        int remainingNumbers = totalCount % numThreads;

        int start = 1;
        int end = numbersPerThread;

        System.out.println("\nStarting concurrent counting task....\n");

        CounterThread[] threads = new CounterThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            if (i == numThreads - 1) {
                end += remainingNumbers;
            }
            threads[i] = new CounterThread(start, end);
            threads[i].setName(String.valueOf(i + 1)); // Assigning thread names
            threads[i].start();

            start = end + 1;
            end += numbersPerThread;
        }
        for (CounterThread thread : threads) {
            thread.join();
        }

        System.out.println("\nAll threads have completed execution.\n");
        System.out.println("Final Result: Total count of numbers: " + totalCount);

        scanner.close();
    }
}
