package flightReservation;

public class ReservationException extends Exception {

    //Class for handling Invalid Seat Number Exception
    public static class InvalidSeatNumber extends ReservationException{
        public InvalidSeatNumber(){
            System.out.println("The given List has already been taken!!");
        }
    }
    //Class for handling the case of Fully booked flight
    public static class FullyBookedFlights extends ReservationException{
        public FullyBookedFlights(){
            System.out.println("The flight has been fully booked !!");
        }
    }
    //Non-Existent Flight exception
    public static class NonExistentFlight extends ReservationException{
        public NonExistentFlight(){
            System.out.println("The Given Flight Number doer not exist!!");
        }
    }
    //Handling Invalid Ticket Number Exception
    public static class InvalidTicketNo extends ReservationException{
        public InvalidTicketNo(){
            System.out.println("Invalid ticket Number Exception!!");
        }
    }

}
