import java.util.*;

class BankAccount {
    double accountNumber;
    String accountHolder;
    double balance;
    String accountType;
    static int accountCount = 0;

    public BankAccount(double accountNumber, String accountHolder, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        accountCount++;
    }

    public void deposit(double num) {
        this.balance += num;
        System.out.println("New Balance: " + this.balance);
    }

    public void withdrawal(double num) {
        if (this.balance - num < 0) {
            System.out.println("Insufficient balance");
        } else {
            this.balance -= num;
            System.out.println("New Balance: " + this.balance);
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);

    }
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(20, "Jakia", 2000, "Wide");
        BankAccount acc2 = new BankAccount(30, "Tasnim", 5000, "Within");

        acc1.deposit(537460);
        acc2.withdrawal(122631);

        acc1.display();
        acc2.display();
    }
}

