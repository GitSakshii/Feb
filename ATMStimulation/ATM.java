package ATM_Stimulation;

import java.util.Scanner;

public class ATM {
    public void transaction(String recipientBank, Account userAccount, String userBank, Scanner sc, Bank b) throws AccountNotFoundException, InsufficientFundsException{
        System.out.println("Recipient Account Number");
        String recipientAccountNumber = sc.next();

        System.out.println("Amount:");
        double amount = sc.nextDouble();
        b.deposit(recipientAccountNumber, amount,recipientBank);
        //if recipient bank is same as user bank no money would be deducted on transaction
        if(!recipientBank.equals(userBank))//it would only be deducted when both banks are different
        {
        b.deduct(userAccount, amount,userBank);}

    }

    //mehtod to login in atm with card number and pin
    public Account login(String bank, Scanner sc, Bank atm) throws InvalidPinException, AccountNotFoundException {

        System.out.println("Enter your card number:");
        String cardNumber = sc.next();
        Account loginAccount = null;
        for(Account account :atm.getbank(bank))
            if (account != null && account.getCardNumber() != null && account.getCardNumber().equals(cardNumber)) {
                loginAccount = account;
                break;
            }

        if(loginAccount == null)
            throw new AccountNotFoundException("Account not found");
        if(loginAccount.getBlocked()){
            throw new AccountNotFoundException("Account already blocked");
        }
        int count = 3;
        while(count > 0){
            System.out.println("Enter PIN:");
            System.out.println(count+"Attempts left");
            --count;
            int pin = sc.nextInt();
            sc.nextLine();
            if(pin==loginAccount.getPin()){
                System.out.println("Logged in as " + loginAccount.getName());
                break;
            }
        }
        if(count == 0){
            loginAccount.setBlocked();
            throw new InvalidPinException(" **********Pin incorrect 3 times.**********\n**********Your card has been blocked.**********");
        }

        return loginAccount;
    }

}
