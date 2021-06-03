import java.util.*;
class Ticket 
{
    String source,destination;
    int PNR;
    int no_of_passengers;
    String passenger_name;
    int seatno;
    int train_no;
    
    
    Ticket()
    {     
    }
    
    Ticket(int PNR,String source,String destination,String passenger_name,int seatno,int train_no)
    {
        this.source=source;
        this.destination=destination;
        this.passenger_name=passenger_name;
        this.seatno=seatno;
        this.train_no=train_no;
        this.PNR=PNR;
    }
    static int generate_PNR()
    {
        Random rand = new Random();
        return rand.nextInt(100000);
    }
   @Override
   public String toString()
   {
       return "\nPNR: "+PNR+"\nSource: "+source+"\nDestination: "+destination+"\nPassenger Name: "+passenger_name+"\nTrain no: "+train_no+"\nSeatno= "+seatno;
   }
}