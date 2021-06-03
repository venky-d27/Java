import java.util.ArrayList;

public class Withheld{
    int PNR,no_of_passengers;
    String source,destination;
    ArrayList<String> passengers=new ArrayList<>();
    Withheld(){}
    Withheld(int PNR,String[] passenger,int no_of_passengers,String source,String destination)
    {
        int k=0;
        this.PNR=PNR;
        this.no_of_passengers=no_of_passengers;
        this.source=source;
        this.destination=destination;
        
        for(String i: passenger)
        {
            passengers.add(i);
        }
    
    }
    

}
