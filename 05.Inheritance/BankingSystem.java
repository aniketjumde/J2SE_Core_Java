import java.util.*;

class Account {
    private String accountholder;
    private double balance;

    public void setAccountholder(String accountholder) {
        this.accountholder = accountholder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " Deposited. New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " Withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or Invalid Withdrawal Amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingAccount extends Account {
    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = (getBalance() * interestRate) / 100;
        deposit(interest);
        System.out.println("Interest Applied. New Balance: " + getBalance());
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void checkOverDraftLimit() {
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class BankingSystem 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("=====================================");
        System.out.println("       Welcome to the Bank!          ");
        System.out.println("=====================================");
        System.out.println("1. Open Savings Account");
        System.out.println("2. Open Current Account");
        System.out.print("Select an option (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (choice == 1) {
            SavingAccount sa = new SavingAccount();
            System.out.print("Enter Account Holder Name: ");
            sa.setAccountholder(sc.nextLine());
            System.out.print("Enter Initial Balance: ");
            sa.setBalance(sc.nextDouble());
            sc.nextLine(); // Fix: Consume the newline
            System.out.print("Enter Interest Rate (%): ");
            sa.setInterestRate(sc.nextDouble());
            sc.nextLine(); // Fix: Consume the newline
            account = sa;
            System.out.println("\nSavings Account Created Successfully!");
        } else if (choice == 2) {
            CurrentAccount ca = new CurrentAccount();
            System.out.print("Enter Account Holder Name: ");
            ca.setAccountholder(sc.nextLine());
            System.out.print("Enter Initial Balance: ");
            ca.setBalance(sc.nextDouble());
            sc.nextLine(); // Fix: Consume the newline
            System.out.print("Enter Overdraft Limit: ");
            ca.setOverdraftLimit(sc.nextDouble());
            sc.nextLine(); // Fix: Consume the newline
            account = ca;
            System.out.println("\nCurrent Account Created Successfully!");
        } else {
            System.out.println("Invalid choice! Exiting...");
            sc.close();
            System.exit(0);
        }

        while (true) {
            System.out.println("\n=====================================");
            System.out.println("            Main Menu");
            System.out.println("=====================================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            if (account instanceof SavingAccount) {
                System.out.println("4. Apply Interest");
            }
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).applyInterest();
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for banking with us! Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

