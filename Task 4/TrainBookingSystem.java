import java.util.*;

class TrainBookingSystem
{
    public static void main(String args[])
    {
    String source,destination;
    int no_of_passengers;
    Scanner sc=new Scanner(System.in);
    int c;
    int pnr;
    System.out.println("Welecome to our Ticket Booking System");
    do
    {
    System.out.println("\nEnter your choice:\n1.Book Ticket\n2.Cancel Ticket\n3.View Occupancy Chart\n4.Inquiry\n5.Exit");
    c=sc.nextInt();
    Display d=new Display();
    switch(c)
    {
    case 1:
        System.out.println("Enter the following details:");
        System.out.println("Source");
        source=sc.next();
        System.out.println("Destination");
        destination=sc.next();
        System.out.println("No of passengers");
        no_of_passengers=sc.nextInt();
        String[] passengers=new String[no_of_passengers];
        System.out.println("Enter Passengers names");
        for(int i=0;i<no_of_passengers;i++)
        {
            passengers[i]=sc.next();
        }
        TicketBooking t=new TicketBooking(source,destination,no_of_passengers);
        t.bookticket(passengers); 
        // d.display();
        break;
    case 2:
        System.out.println("Enter PNR:");
        pnr=sc.nextInt();
        CancelTicket ct=new CancelTicket();
        ct.cancel(pnr);
        // d.display();
        break;
    case 3:
        d.OccupancyChart();
        break;
    case 4:
        System.out.println("Enter PNR:");
        pnr=sc.nextInt();
        d.display(pnr);
    case 5: break;
    default: System.out.println("Wrong Choice!!!"); 
    }
    
    }while(c!=5);
    }
}