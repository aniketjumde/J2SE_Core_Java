import java.util.Scanner;
import java.util.InputMismatchException;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankingApplication {
    private double balance;

    public BankingApplication(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingApplication account = new BankingApplication(5000);

        try {
            System.out.println("Current Balance: " + account.getBalance());
            System.out.print("Enter amount to deposit: ");
            double depositAmount = sc.nextDouble();
            account.deposit(depositAmount);

            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);

            System.out.println("Remaining Balance: " + account.getBalance());
        } 
        catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter numeric values.");
        } 
        finally {
            System.out.println("Thank you for using our Banking Application!");
            sc.close();
        }
    }
}

