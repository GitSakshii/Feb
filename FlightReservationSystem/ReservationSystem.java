package flightReservation;

import java.util.*;

public class ReservationSystem {
   //List containing the Information of Flights
    List<Flight>flights;

    public ReservationSystem(){
        this.flights=new ArrayList<>();
    }
    //Method to add Flight
    public void addFlight(Scanner sc){
        sc.nextLine();
        System.out.println("Enter Flight Number");
        int fno=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Departure City");
        String from=sc.nextLine();
        System.out.println("Enter Destination City");
        String to=sc.nextLine();
        System.out.println("Number of seats");
        int seats=sc.nextInt();
        sc.nextLine();
        Flight f=new Flight(fno,from,to,seats);
        flights.add(f);
        System.out.println("Flight Added");
    }
    //Method to reserve Flight
    public void reserveFlight(Scanner sc){
            try {
                sc.nextLine();
                System.out.println("Enter Passenger Name:");
                String name = sc.nextLine();//Taking Input
                System.out.println("Enter Age:");
                int age = sc.nextInt();
                System.out.println("Enter flight number ");
                int fno = sc.nextInt();
                int checkflight=0;
                sc.nextLine();
                System.out.println("Enter Seat Number");
                int seat = sc.nextInt();
                if(seat<1)throw new ReservationException.InvalidSeatNumber();//To handle negetive value
                sc.nextLine();
                sc.nextLine();
                for (Flight f : flights) {
                    for (Customer cus : f.customers) {
                        if (cus.getSeatno() == seat) throw new ReservationException.InvalidSeatNumber();
                    }
                    if (f.getFlightNumber() == fno) {
                        checkflight=1;
                        int availableseats = f.getAvailableSeats();
                        if(availableseats==0)throw new ReservationException.FullyBookedFlights();
                        if (availableseats >0) {
                            int seatno = f.getnoofcustomers();
                            Customer c = new Customer(name, age, seatno + 1, seat);
                            f.addCustomer(c);
                            f.setAvailableSeats(availableseats - 1);
                            System.out.println("Your Flight has been booked");
                            c.display(f);
                        }
                    }
                }
                if(checkflight==0)throw new ReservationException.NonExistentFlight();
            }catch (ReservationException.InvalidSeatNumber|ReservationException.NonExistentFlight|ReservationException.FullyBookedFlights e){
                System.out.println(e.getMessage());
            }




    }
    //Method to Cancel Flight
    public void cancelFlight(Scanner sc){
        try {
            System.out.println("Enter Flight Number");
            int fno = sc.nextInt();
            sc.nextLine();
            int checkFlight = 0;
            System.out.println("Enter ticket Number");
            int n = sc.nextInt();
            sc.nextLine();
            int found = 0;
            for (Flight f : flights) {
                if (f.getFlightNumber() == fno) {
                    checkFlight=1;
                    for (Customer c : f.customers) {
                        if (c.getTicketNo() == n) {
                            f.customers.remove(c);
                            found = 1;
                            System.out.println("Flight Cancelled Successfully!!");
                            break;
                        }
                    }

                }

            }
            if(checkFlight==0)throw new ReservationException.NonExistentFlight();
            if (found == 0) throw new ReservationException.InvalidTicketNo();

        }catch (ReservationException.NonExistentFlight | ReservationException.InvalidTicketNo e){
            System.out.println(e.getMessage());

        }

    }
    public void flightList()
    {
        for(Flight f:flights){
            f.display();
            System.out.println();
        }
    }
    public void CustomerList(Scanner sc){
        System.out.println("Enter flight no");
        int fno= sc.nextInt();
        for(Flight f:flights){
            if(f.getFlightNumber()==fno)
            {
                for(Customer c:f.customers){
                    c.displaycustomers();
                }
            }
        }

    }
}
