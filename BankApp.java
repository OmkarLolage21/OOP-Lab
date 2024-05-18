package FinalOOPLab;

import java.util.Scanner;

class WithdrawalException extends Exception {
    public WithdrawalException(String message) {
        super(message);
    }
}

class BankAccounts {
    private double balance;

    public BankAccounts(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws WithdrawalException {
        if (amount > balance) {
            throw new WithdrawalException("Insufficient funds. Cannot withdraw " + amount + ". Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Current balance: " + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccounts account = new BankAccounts(initialBalance);

        while (true) {
            System.out.print("Enter withdrawal amount (or type 'exit' to quit): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double withdrawalAmount = Double.parseDouble(input);
                account.withdraw(withdrawalAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (WithdrawalException e) {
                System.out.println("Withdrawal failed: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

