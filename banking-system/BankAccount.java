package bankingSystem;

import java.util.ArrayList;
import java.util.List;

//Class representing Bank Account
public class BankAccount {
    private String accountNumber;
    private double balance;
    //List containing transaction details for each account
    List<transaction> transactions;
    public BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }
    //Function to access account number using obj
    public String getAccountNumber() {
        return accountNumber;
    }
    //Function to access balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public  void addtransaction(transaction transaction)
    {
        transactions.add(transaction);
    }
    public void display()
    {
        System.out.println("Account Number: "+getAccountNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("Transaction History:");
        for(transaction t:transactions){
            if(t!=null){
                System.out.println(t.getTransactionId()+" ,"+t.getTransactionType()+t.getAmount());
            }
        }
    }
}
