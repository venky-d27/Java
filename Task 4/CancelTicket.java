import java.util.*;
class CancelTicket {
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
    }

}