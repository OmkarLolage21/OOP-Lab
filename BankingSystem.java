package FinalOOPLab;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankingAccount destination, double amount);
    double getBalance();
    List<String> getTransactions();
}

abstract class BankAccount implements BankingAccount {
    protected double balance;
    protected List<String> transactions;

    public BankAccount() {
        balance = 0.0;
        transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawal: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void transfer(BankingAccount destination, double amount) {
        if (amount <= balance) {
            balance -= amount;
            destination.deposit(amount);
            transactions.add("Transfer to " + destination.getClass().getSimpleName() + " (Account Number: " + ((BankAccount) destination).getAccountNumber() + "): " + amount);
            destination.getTransactions().add("Transfer from " + this.getClass().getSimpleName() + " (Account Number: " + this.getAccountNumber() + "): " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }

    public abstract int getAccountNumber();
}

class SavingsAccount extends BankAccount {
    private static int accountCounter = 1;
    private int accountNumber;

    public SavingsAccount() {
        super();
        accountNumber = accountCounter++;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

class CheckingAccount extends BankAccount {
    private static int accountCounter = 1;
    private int accountNumber;

    public CheckingAccount() {
        super();
        accountNumber = accountCounter++;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

public class BankingSystem {
    static int accountNumberCounter = 1; // Counter for generating account numbers
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer funds");
            System.out.println("5. View transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating a new account...");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    System.out.print("Choose account type: ");
                    int accountTypeChoice = scanner.nextInt();
                    System.out.print("Enter initial deposit amount: ");
                    double initialDeposit = scanner.nextDouble();
                    BankAccount newAccount = null;
                    if (accountTypeChoice == 1) {
                        newAccount = new SavingsAccount();
                        System.out.println("Savings Account created with initial deposit: " + initialDeposit + ", Account number: " + ((SavingsAccount) newAccount).getAccountNumber());
                    } else if (accountTypeChoice == 2) {
                        newAccount = new CheckingAccount();
                        System.out.println("Checking Account created with initial deposit: " + initialDeposit + ", Account number: " + ((CheckingAccount) newAccount).getAccountNumber());
                    } else {
                        System.out.println("Invalid account type.");
                        break;
                    }
                    if (newAccount != null) {
                        newAccount.deposit(initialDeposit);
                        accounts.add(newAccount);
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accountNumber = scanner.nextInt();
                    if (accountNumber < 1 || accountNumber > accounts.size()) {
                        System.out.println("Invalid account number.");
                        break;
                    }
                    BankAccount selectedAccount = accounts.get(accountNumber - 1);
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    selectedAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Current balance: " + selectedAccount.getBalance());
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int accountNumWithdraw = scanner.nextInt();
                    if (accountNumWithdraw < 1 || accountNumWithdraw > accounts.size()) {
                        System.out.println("Invalid account number.");
                        break;
                    }
                    BankAccount selectedAccountWithdraw = accounts.get(accountNumWithdraw - 1);
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    selectedAccountWithdraw.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. Current balance: " + selectedAccountWithdraw.getBalance());
                    break;

                case 4:
                    System.out.print("Enter source account number: ");
                    int sourceAccountNumber = scanner.nextInt();
                    System.out.print("Enter destination account number: ");
                    int destinationAccountNumber = scanner.nextInt();
                    if (sourceAccountNumber < 1 || sourceAccountNumber > accounts.size() ||
                            destinationAccountNumber < 1 || destinationAccountNumber > accounts.size()) {
                        System.out.println("Invalid account number.");
                        break;
                    }
                    BankAccount sourceAccount = accounts.get(sourceAccountNumber - 1);
                    BankAccount destinationAccount = accounts.get(destinationAccountNumber - 1);
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    sourceAccount.transfer(destinationAccount, transferAmount);
                    System.out.println("Transfer successful.");
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int accountNumView = scanner.nextInt();
                    if (accountNumView < 1 || accountNumView > accounts.size()) {
                        System.out.println("Invalid account number.");
                        break;
                    }
                    BankAccount selectedAccountView = accounts.get(accountNumView - 1);
                    System.out.println("Transactions for Account " + accountNumView + ":");
                    for (String transaction : selectedAccountView.getTransactions()) {
                        System.out.println(transaction);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scanner.close();
    }
}
