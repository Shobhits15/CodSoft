import java.util.Scanner;

public class ATMSystem {

    // BankAccount Class
    public static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            }
            return false;
        }

        public double checkBalance() {
            return balance;
        }
    }

    // ATM Class
    public static class ATM {
        private BankAccount bankAccount;
        private Scanner scanner;

        public ATM(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
        }

        public void withdraw() {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (bankAccount.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f.%n", amount);
            } else {
                System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
            }
        }

        public void deposit() {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            if (bankAccount.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f.%n", amount);
            } else {
                System.out.println("Deposit failed. Amount must be greater than zero.");
            }
        }

        public void checkBalance() {
            double balance = bankAccount.checkBalance();
            System.out.printf("Your current balance is: $%.2f%n", balance);
        }

        public void run() {
            while (true) {
                displayMenu();
                System.out.print("Select an option (1-4): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        withdraw();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        atm.run();
        scanner.close();
    }
}
