package FinalOOPLab;

import java.util.Scanner;

class TablePrinter {
    synchronized void print2Table() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 x " + i + " = " + (2 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    synchronized void print5Table() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread extends Thread {
    TablePrinter tablePrinter;
    int tableNumber;

    MyThread(TablePrinter tablePrinter, int tableNumber) {
        this.tablePrinter = tablePrinter;
        this.tableNumber = tableNumber;
    }

    public void run() {
        if (tableNumber == 2) {
            tablePrinter.print2Table();
        } else if (tableNumber == 5) {
            tablePrinter.print5Table();
        }
    }
}

class DaemonThread extends Thread {
    public void run() {
        try {
            while (true) {
                System.out.println("Daemon thread is running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TablePrinter tablePrinter = new TablePrinter();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create 5 threads");
            System.out.println("2. Print 2's table");
            System.out.println("3. Print 5's table");
            System.out.println("4. Demonstrate daemon thread");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        Thread t = new Thread(() -> {
                            System.out.println(Thread.currentThread().getName() + " is running");
                        });
                        t.start();
                    }
                    break;
                case 2:
                    new MyThread(tablePrinter, 2).start();
                    break;
                case 3:
                    new MyThread(tablePrinter, 5).start();
                    break;
                case 4:
                    DaemonThread daemonThread = new DaemonThread();
                    daemonThread.setDaemon(true);
                    daemonThread.start();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println("Main thread ending, daemon thread will also end if it is a daemon.");
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
