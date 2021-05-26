import java.util.*;
class Ticket
{
    String source,destination;
    int PNR;
    int no_of_passengers;
    String passenger_name;
    static int[] seats1 = new int[8];
    static int[] seats2 = new int[8];
    static int available_seat1=8;
    static int available_seat2=8;
    static HashMap<Integer,Object> p=new HashMap<Integer,Object>();
    static HashMap<String,Object> t=new HashMap<String,Object>(); 
    static HashMap<Integer,Integer> s=new HashMap<Integer,Integer>(); 
    Ticket()
    {
        for (int i = 0; i < 8; i++) 
        {
            seats1[i] = 0;
            seats2[i] = 0;
        }
            
    }
    Ticket(String source,String destination,int no_of_passengers,String passenger_name)
    {
        this.source=source;
        this.destination=destination;
        this.no_of_passengers=no_of_passengers;
        this.passenger_name=passenger_name;
        t.put("source",source);
        t.put("destination",destination);
        t.put("passenger_name",passenger_name);
        this.PNR=generate_PNR();
    }
    int generate_PNR()
    {
        Random rand = new Random();
        return rand.nextInt(100000);
    }
    void display()
    {
        System.out.println("Welcome to our Ticket Reservation Portal\n"+"source: "+source+"\nDestination: "+destination+"\nPNR: "+PNR+"\nPassenger Name: "+passenger_name);
    }
}
class TicketBooking extends Ticket
{   ArrayList<Object> t1=new ArrayList<Object>( Arrays.asList("A","B","C","D","E"));
    ArrayList<String> t2=new ArrayList<String>( Arrays.asList("X","Y","Z"));
    TicketBooking(String source,String destination,int no_of_passengers,String passenger_name)
    {
        super(source,destination,no_of_passengers,passenger_name);
    }
    int bookTrain1() 
    {
        for (int i = 0; i < 6; i++) 
        {
            if (seats1[i] == 0)
            {
                seats1[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
    int bookTrain2() 
    {
        for (int i = 0; i < 6; i++) 
        {
            if (seats2[i] == 0)
            {
                seats2[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
    void bookticket()
    {   int a,b;
        if(t1.contains(source)&&t1.contains(destination))
    {
        a=bookTrain1();
        if(a==-1)
        {
            System.out.println("No seats Available!!");
        }
        else{
            s.put(1,a);
            t.put("train",s);
            p.put(PNR,t);
            // System.out.println("Train 1\nSeat:"+a);
        }
    }
    else if(t2.contains(source)&&t2.contains(destination))
    {
        a=bookTrain2();
        if(a==-1)
        {
            System.out.println("No seats Available!!");
        }
        else{
            s.put(2,a);
            t.put("train",s);
            p.put(PNR,t);
            // System.out.println("Train 2\nSeat:"+a);
        }
    }
    else
    {
        a=bookTrain1();
        b=bookTrain2();
        if(a==-1 || b==-1)
        {
            System.out.println("No seats Available!!");
        }
        else
        {
            s.put(1,a);
            s.put(2,b);
            t.put("train",s);
            p.put(PNR,t);
            // System.out.println("Train 1\nSeat:"+a);
            // System.out.println("Train 2\nSeat:"+b);
        }
    }
    System.out.println(p);
    }
   
}
class TrainBookingSystem
{
    public static void main(String args[])
    {
    String source,destination;
    int PNR;
    int a,b;
    String passenger_name;
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the following details:");
    System.out.println("Source");
    source=sc.next();
    System.out.println("Destination");
    destination=sc.next();
    System.out.println("Passenger Name");
    passenger_name=sc.next();
    TicketBooking t=new TicketBooking(source,destination,1,passenger_name);
    t.display();
    t.bookticket();
    }
}