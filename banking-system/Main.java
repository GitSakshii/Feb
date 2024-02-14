 package bankingSystem;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        BankingSystem b=new BankingSystem();
        int id=100;//for geting a unique transaction for each transaction being made
        while(true) {
            System.out.println("  Menu");
            System.out.println("1.Add Account");
            System.out.println("2.Deposit ");
            System.out.println("3.Withdraw ");
            System.out.println("4.Transfer Money");
            System.out.println("5.Transaction History:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    b.Addaccount(sc);
                    break;
                case 2:
                    b.deposit(sc,id++);
                    break;
                case 3:
                    b.withdraw(sc,id++);
                    break;
                case 4:
                    b.transfer(sc,id++);
                    break;
                case 5:
                    b.transactionhistory(sc);
                   break;
            }
        }

    }
}
