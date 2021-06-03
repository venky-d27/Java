import java.util.*;
class TicketBooking extends Ticket
{   ArrayList<Object> t1=new ArrayList<Object>( Arrays.asList("A","B","C","D","E"));
    ArrayList<String> t2=new ArrayList<String>( Arrays.asList("X","Y","C"));
    Withheld w;
    TicketBooking(String source,String destination,int no_of_passengers)
    {
        super.source=source;
        super.destination=destination;
        super.no_of_passengers=no_of_passengers;    
    }
    TicketBooking()
    {}
    Ticket ticket1,ticket2;
    int bookSeat1() 
    {
        for (int i = 0; i < 8; i++) 
        {
            if (Train.seats1[i] == 0)
            {
                Train.seats1[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
    int bookSeat2() 
    {
        for (int i = 0; i < 8; i++) 
        {
            if (Train.seats2[i] == 0)
            {
                Train.seats2[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
    void bookticket(String passengers[])
    {   
        // System.out.println(source+" "+destination+" sd");
        boolean a,b,c,d;
        int s1,s2;
        a=t1.contains(source);
        b=t2.contains(source);
        c=t1.contains(destination);
        d=t2.contains(destination);
        
        if(b && c && destination.charAt(0)!='C')
        {
            if(passengers.length>Train.available_seat1 || passengers.length>Train.available_seat2)
            {
                System.out.println("Sorry!!! Tickets not available");
                System.out.println("Only "+Train.available_seat1+" tickets available in Train 1");
                System.out.println("and Only "+Train.available_seat2+" tickets available in Train 2");
            }
            else
            {
                super.PNR=generate_PNR();
                for(int i=1;i<=no_of_passengers;i++)
                {
                    s1=bookSeat1();
                    s2=bookSeat2();
                    ticket1=new Ticket(PNR,source,"C",passengers[i-1],s1,1);
                    // System.out.println(ticket1);
                    Train.train1.add(ticket1);
                    System.out.print(Train.train1.get(i-1).toString());
                    ticket2=new Ticket(PNR,"C",destination,passengers[i-1],s2,2);
                    Train.train2.add(ticket2);
                    System.out.print(Train.train2.get(i-1).toString());
                    
                }
                Train.available_seat1-=no_of_passengers;
                Train.available_seat2-=no_of_passengers;
                // seat[0]=no_of_passengers;
                // seat[1]=no_of_passengers;
            }
            
        }
        else if(a&&c)
        {
            if(passengers.length>Train.available_seat1)
            {
                if(Train.w1<=0)
                {
                System.out.println("Sorry!!! Tickets not available");
                System.out.println("Only "+Train.available_seat1+" tickets available in Train 1"); 
                }
                else
                {
                super.PNR=generate_PNR();
                w=new Withheld(PNR,passengers,no_of_passengers,source,destination);
                Train.withheld1.add(w);
                // System.out.println(no_of_passengers);
                }
            }
            else
            {
                super.PNR=generate_PNR();
                for(int i=1;i<=no_of_passengers;i++)
                {   
                    s1=bookSeat1();
                    ticket1=new Ticket(PNR,source,destination,passengers[i-1],s1,1);
                    Train.train1.add(ticket1);
                    System.out.print(Train.train1.get(i-1).toString());
                    System.out.println(Train.train1+"\n"+Train.train2);
                    
                }
                Train.available_seat1-=no_of_passengers;

            }
        }
        else if(b&&d)
        {
            if(passengers.length>Train.available_seat2)
            {
                if(Train.w2<=0)
                {
                System.out.println("Sorry!!! Tickets not available");
                System.out.println("Only "+Train.available_seat2+" tickets available in Train 1"); 
                }
                else
                {
                super.PNR=generate_PNR();
                w=new Withheld(PNR,passengers,no_of_passengers,source,destination);
                Train.withheld2.add(w);
                // System.out.println(no_of_passengers);
                }
            }
            else
            {
                super.PNR=generate_PNR();
                
                for(int i=1;i<=no_of_passengers;i++)
                {  
                    s2=bookSeat2();
                    ticket2=new Ticket(PNR,source,destination,passengers[i-1],s2,2);
                    // System.out.println(ticket2);
                    Train.train2.add(ticket2);
                    System.out.print(Train.train2.get(i-1).toString());

                }
                Train.available_seat2-=no_of_passengers;
            }
        }
        else
        {
            System.out.println("No Trains available for the given route");
        }
        
    }  
   
}
