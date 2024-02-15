package flightReservation;

//Class representing Customer Information
public class Customer {
    private String name;
    private int age;
    private int ticketNo;
    private int seatno;

    public Customer(String name, int age, int ticketNo,int seatno) {
        this.name = name;
        this.age = age;
        this.ticketNo = ticketNo;
        this.seatno=seatno;
    }

    public String getName() {
        return name;
    }


    public int getTicketNo() {
        return ticketNo;
    }

    public int getSeatno() {
        return seatno;
    }

    public void display(Flight f) {
        System.out.println("    Ticket");
        System.out.println("Ticket Number : " + getTicketNo());
        System.out.println("Name: " + getName());
        //It would provide the flight details of the customer(like departure from ,destination and Flight Number)
        if(f!=null) f.display();
    }
   //Method containing a Customer details
    public void displaycustomers() {

        System.out.println("Ticket Number : " + getTicketNo());
        System.out.println("Name: " + getName());

    }

}