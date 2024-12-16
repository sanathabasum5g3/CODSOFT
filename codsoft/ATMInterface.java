import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Currency Conversion");
        System.out.println("5. Exit");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    public void currencyConversion(double amount, String baseCurrency, String targetCurrency) {
        double conversionRate = getConversionRate(baseCurrency, targetCurrency);
        if (conversionRate != 0) {
            double convertedAmount = amount * conversionRate;
            System.out.println(amount + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Invalid currency selection.");
        }
    }

    private double getConversionRate(String baseCurrency, String targetCurrency) {
        if (baseCurrency.equalsIgnoreCase("USD") && targetCurrency.equalsIgnoreCase("EUR")) {
            return 0.85;
        } else if (baseCurrency.equalsIgnoreCase("EUR") && targetCurrency.equalsIgnoreCase("USD")) {
            return 1.18;
        } else if (baseCurrency.equalsIgnoreCase("USD") && targetCurrency.equalsIgnoreCase("INR")) {
            return 74.5;
        } else if (baseCurrency.equalsIgnoreCase("INR") && targetCurrency.equalsIgnoreCase("USD")) {
            return 0.013;
        } else {
            return 0;
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        boolean exit = false;

        System.out.println("Welcome to the ATM!");

        while (!exit) {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter the amount for conversion: ");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter base currency (e.g., USD, EUR, INR): ");
                    String baseCurrency = scanner.next();
                    System.out.print("Enter target currency (e.g., USD, EUR, INR): ");
                    String targetCurrency = scanner.next();
                    atm.currencyConversion(amount, baseCurrency, targetCurrency);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

