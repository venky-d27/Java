class CancelTicket {
    TicketBooking t=new TicketBooking();
    void cancel(int pnr)
    {   int f=0,i=0;
        // System.out.println(Train.train1.size()+" "+Train.train1);
        while(i<Train.train1.size())
        {   
            // System.out.println(Train.train1.get(i).PNR+" "+pnr);
            if(Train.train1.get(i).PNR==pnr)
            {
                Train.seats1[Train.train1.get(i).seatno-1]=0;
                Train.train1.remove(i);
                Train.available_seat1+=1;
                f=1;
                i-=1;
            }
            i+=1;
        }
        i=0;
        while(i<Train.train2.size())
        {
            if(Train.train2.get(i).PNR==pnr)
            {
                Train.seats2[Train.train2.get(i).seatno-1]=0;
                Train.train2.remove(i);
                Train.available_seat2+=1;
                f=1;
                i-=1;
            }
            i+=1;
        }
        
        if(f==0)
        {
            System.out.println("Invalid!!! Check PNR Number");
        }
        else{
            System.out.println("Ticket Cancelled Successfully");
        }
        book_withheld_tickets();
    }
    void book_withheld_tickets()
    {
        for(int i=0;i<Train.withheld1.size();i++)
        {
           String a[]=new String[Train.withheld1.get(i).passengers.size()];
            for(int k=0;k<Train.withheld1.get(i).passengers.size();k++)
            {
                a[k]=Train.withheld1.get(i).passengers.get(k);
                System.out.println(a[k]);
            }
            t=new TicketBooking(Train.withheld1.get(i).source,Train.withheld1.get(i).destination,Train.withheld1.get(i).no_of_passengers);
            t.bookticket(a);
        }
        for(int i=0;i<Train.withheld2.size();i++)
        {
           String a[]=new String[Train.withheld2.get(i).passengers.size()];
            for(int k=0;k<Train.withheld2.get(i).passengers.size();k++)
            {
                a[k]=Train.withheld2.get(i).passengers.get(k);
                System.out.println(a[k]);
            }
            t=new TicketBooking(Train.withheld2.get(i).source,Train.withheld2.get(i).destination,Train.withheld2.get(i).no_of_passengers);
            t.bookticket(a);
        }
    }

}