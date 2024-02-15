package flightReservation;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        ReservationSystem r=new ReservationSystem();
      while(true){
          //Main Menu
          System.out.println("      Menu");
          System.out.println("   1.Add Flight");
          System.out.println("   2.Reserve Flight");
          System.out.println("   3.Cancel flight");
          System.out.println("   4.Flight List");
          System.out.println("   5.Passenger list of a flight");
          System.out.println("   Choose an option:");
          int ch=sc.nextInt();
          switch (ch){
              case 1:
                  //Adding Flight 
                  r.addFlight(sc);
                  System.out.println("Press any key..");
                  sc.nextLine();
                  break;
              case 2:
                  //Reserving Flight
                  r.reserveFlight(sc);
                  System.out.println("Press any key..");
                  sc.nextLine();
                  break;
              case 3:
                  //Cancel Flight
                  r.cancelFlight(sc);
                  System.out.println("Press any key..");
                  sc.nextLine();
                  break;
              case 4:
                  //Displays Flight List
                  r.flightList();
                  System.out.println("Press any key..");
                  sc.nextLine();
                  break;
              case 5:
                  //Displays Customers list for a particular Flight
                  r.CustomerList(sc);
                  System.out.println("Press any key..");
                  sc.nextLine();
                  break;
              default:
                  System.out.println("Enter valid choice");
                  break;

          }

      }
    }
}
