
package bankingSystem;
import java.util.*;
public class BankingSystem {
    List<BankAccount>Accounts;
    public BankingSystem()
    {
        this.Accounts=new ArrayList<>();
    }
    public void Addaccount(Scanner sc){
        sc.nextLine();
        System.out.println("Enter Account Number:");
        String accno=sc.nextLine();
        System.out.println("Enter Balance");
        int balance=sc.nextInt();
        sc.nextLine();
        BankAccount bankAccount=new BankAccount(accno,balance);
        Accounts.add(bankAccount);
    }
    //Funtion to deposit
    public void deposit(Scanner sc,int id){
        try {
            sc.nextLine();
            System.out.println("Enter Account Number");
            String accountno = sc.nextLine();
            System.out.println("Enter Amount:");
            double amount = sc.nextInt();
            System.out.println();
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(accountno)) {

                    double balance = b.getBalance();
                    b.setBalance(balance + amount);
                    transaction t = new transaction(id, "deposit, +", amount);
                    b.addtransaction(t);
                    System.out.println("Cash Deposited Successfully");
                    return;
                }
            }
            throw new BankException("Invalid Account:" + accountno);
        }catch (InputMismatchException e){
            System.out.println("Invalid input . Please Enter a valid number");
        }catch (BankException e){
            System.out.println(e.getMessage());
        }

    }
    //Function to withdraw
    public void withdraw(Scanner sc,int id){
        try {
            sc.nextLine();
            System.out.println("Enter Account Number");
            String accountno = sc.nextLine();
            System.out.println("Enter Amount to Withdraw:");
            double amount = sc.nextInt();
            System.out.println();
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(accountno)) {
                    double balance = b.getBalance();
                    if (balance < amount) {
                        throw new BankException("Not Enough Balance");

                    }
                    b.setBalance(balance - amount);
                    transaction t = new transaction(id, "Withdrawal, -", amount);
                    b.addtransaction(t);
                    System.out.println("Cash Withdrawn Successfully");
                    return;
                }
            }
            throw new BankException("Invalid Account: " + accountno);
        }catch (InputMismatchException e){
            System.out.println("Invalid input.Please enter a valid number");

        }
        catch (BankException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Invalid Account!!");

    }

    //Function to transfer money
    public void transfer(Scanner sc,int id){
        try {
            sc.nextLine();
            System.out.println("Transfer From: Account Number ");
            String from = sc.nextLine();
            System.out.println("Transfer into: Account Number ");
            String to = sc.nextLine();
            if (from == null || to == null) {
                throw new BankException("Invalid Account Number");
            }
            System.out.println("Enter Amount");
            double amount = sc.nextInt();
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(from)) {
                    double balance = b.getBalance();
                    if (balance < amount) {
                        throw new BankException("Not enough balance in your Account!!");
                    }
                    transaction t = new transaction(id, "transfer, -", amount);
                    b.addtransaction(t);
                    b.setBalance(balance - amount);
                }
            }
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(to)) {
                    double balance2 = b.getBalance();
                    b.setBalance(amount + balance2);
                    transaction t = new transaction(id, "transfer, +", amount);
                    b.addtransaction(t);
                    System.out.println("Transaction Successful!!");
                    return;
                }
            }
        }catch (InputMismatchException e){
        System.out.println("Invalid Account number.Please Enter a valid number");}
        catch (BankException e){
            System.out.println(e.getMessage());
        }
    }
    //Functio for viewing transaction history of an account
    void transactionhistory(Scanner sc)
    {
        try {
            sc.nextLine();
            System.out.println("Enter Account Number ");
            String acc = sc.nextLine();
            boolean found = false;
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(acc)) {
                    b.display();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new BankException("Account Not Found");
            }
        }catch (BankException e){
            System.out.println(e.getMessage());
        }
    }

}

