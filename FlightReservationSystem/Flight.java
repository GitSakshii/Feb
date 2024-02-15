package flightReservation;

import java.util.ArrayList;
import java.util.List;

//Class Representing a Flight
public class Flight {
    private int flightNumber;
    private String departureCity;
    private String destinationCity;
    private int availableSeats;
    //List of Customers who have booked the Flight
    List<Customer> customers;
    public Flight(int flightNumber,String departureCity,String destinationCity,int availableSeats){
        this.flightNumber=flightNumber;
        this.departureCity=departureCity;
        this.destinationCity=destinationCity;
        this.availableSeats=availableSeats;
        this.customers=new ArrayList<>();
    }
    public int getFlightNumber(){
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }
    public void addCustomer(Customer c){
        customers.add(c);
    }
    public void setAvailableSeats(int s){
        this.availableSeats=s;
    }
    //Method to provide the number of seats booked in the flight
    public int getnoofcustomers(){
        return customers.size();
    }
    public String getDestinationCity(){return destinationCity;}
    public int getAvailableSeats(){return availableSeats;}
    public void display(){
        System.out.println("Flight Number: "+getFlightNumber());
        System.out.println("Departure : "+getDepartureCity());
        System.out.println("Destination : "+getDestinationCity());
    }

}
