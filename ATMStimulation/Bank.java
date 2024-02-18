package ATM_Stimulation;

import java.util.*;

//Class representing a bank
 public class Bank {
    public List<Account> hdfc;
    public List<Account> sbi;
    public List<Account> icici;
    Random random = new Random();
    Account account = null;

    Bank() {
        hdfc = new ArrayList<>();
        sbi = new ArrayList<>();
        icici = new ArrayList<>();
    }

     /*     hdfc card number       pin       name
      *           000000100100      1000      Customer1
      *           000000100101      1001      Customer2
      *           ...
      *      sbi  000000200200      1000      Customer1
      *           000000200201      1001      Customer2
      *           ...
      *    icici  000000300300      1000      Customer1
      *          000000300301      1001      Customer2*/
     //Adds Account to the bank
    public void Addaccount() {
        for (int i = 0; i < 10; i++) {
            String name = String.format("Customer" + (i + 1));
            int pin = 1000 + i;
            double balance = 200000 * random.nextDouble();
            String cardNumber = String.format("%012d", i + 100100);
            account = new Account(cardNumber, pin, name, balance);
            hdfc.add(account);
            cardNumber = String.format("%012d", i + 200200);
            account = new Account(cardNumber, pin, name, balance);
            sbi.add(account);
            cardNumber = String.format("%012d", i + 300300);
            account = new Account(cardNumber, pin, name, balance);
            icici.add(account);

        }
    }

    //Method to select bank list based on the user's bank
     public List<Account>getbank(String bank){
        if(bank.equals("hdfc"))return hdfc;
        if(bank.equals("sbi"))return sbi;
        return icici;
     }
     //Method to get charges according to the bank
    public double getCharges(String bank){
        if(bank.equals("hdfc"))return 0.03;
        if(bank.equals("sbi"))return 0.01;
        return 0.02;
    }
    //deposits to account

    public void deposit(String recipientcardNumber, double amount,String bank) throws AccountNotFoundException {
        Account recipientAccount = null;
        for (Account account : getbank(bank))
            if (account != null && account.getCardNumber()!= null && account.getCardNumber().equals(recipientcardNumber))
                recipientAccount = account;
        if (recipientAccount == null) { throw new AccountNotFoundException("Account of recipient does not exist");
        } recipientAccount.addBalance(amount);

    }

    //Deduct charges of transfer from account
    public void deduct(Account userAccount, double amount,String bank)throws InsufficientFundsException,AccountNotFoundException{
        Account senderAccount = null;
        for (Account account : getbank(bank))
            if (account != null && account == userAccount)
                senderAccount = account;
        if (senderAccount == null){
             throw new AccountNotFoundException("Account of recipient does not exist");
            }else
            {senderAccount.deduct(amount, getCharges(bank));}
    }

}



