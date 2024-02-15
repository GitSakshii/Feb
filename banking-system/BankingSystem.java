
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
            if(amount<0)throw new BankException.NegativeAmountException();
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
            throw new BankException.NonExistenceAccountException();
        }catch (BankException.NonExistenceAccountException e){
            System.out.println(e.getMessage());
        }catch (BankException.NegativeAmountException e)
        {
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
                        throw new BankException.InsufficientFundsException();

                    }
                    b.setBalance(balance - amount);
                    transaction t = new transaction(id, "Withdrawal, -", amount);
                    b.addtransaction(t);
                    System.out.println("Cash Withdrawn Successfully");
                    return;
                }
            }
            throw new BankException.NonExistenceAccountException();
        }catch (BankException.InsufficientFundsException e){
            System.out.println(e.getMessage());

        }
        catch (BankException.NonExistenceAccountException e){
            System.out.println(e.getMessage());
        }


    }

    //Function to transfer money
    public void transfer(Scanner sc,int id){
        try {
            sc.nextLine();
            System.out.println("Transfer From: Account Number ");
            String from = sc.nextLine();
            System.out.println("Transfer into: Account Number ");
            String to = sc.nextLine();
            if(from == null || to == null||from.length()!=12||to.length()!=12)throw new BankException.InvalidAccountException();
            
            System.out.println("Enter Amount");
            double amount = sc.nextInt();
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(from)) {
                    double balance = b.getBalance();
                    if (balance < amount) {
                        throw new BankException.InsufficientFundsException();
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
        }catch (BankException.InvalidAccountException e){
        System.out.println(e.getMessage());}
        catch (BankException.InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
    //Function for viewing transaction history of an account
    void transactionhistory(Scanner sc)
    {
        try {
            sc.nextLine();
            System.out.println("Enter Account Number ");
            String acc = sc.nextLine();
            if(acc.length()!=12)throw new BankException.InvalidAccountException();
            boolean found = false;
            for (BankAccount b : Accounts) {
                if (b.getAccountNumber().equals(acc)) {
                    b.display();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new BankException.NonExistenceAccountException();
            }
        }catch (BankException.NonExistenceAccountException e){
            System.out.println(e.getMessage());
        }
        catch (BankException.InvalidAccountException e)
        {
            System.out.println(e.getMessage());
        }
    }

}



