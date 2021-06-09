import java.util.*;
import java.text.*;
public class FeeCollection 
{
    FeeCollection(){}
    long calculate_time_period(String in_time,String out_time)
    {
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
        Date date1,date2;
        try
        {
            date1 = simpleDateFormat.parse(in_time);
            date2 = simpleDateFormat.parse(out_time);

            long milliSeconds= Math.abs(date2.getTime() - date1.getTime());
            long hours= (milliSeconds / (60 * 60 * 1000))% 24;
            long minutes = (milliSeconds / (60 * 1000)) % 60;
            long seconds= (milliSeconds / 1000) % 60;
            if(minutes>0)
            {
                hours+=1;
            }
            return hours;
        }
        catch(Exception e)
        {
            System.out.println("Entered Date format is Wrong!!!\nEnter Date in HH:MM:SS format!!!");
        }
        return -1;
    }

    public double calculate_fee(String type,String in_time,String out_time)
    {   
        long hours=calculate_time_period(in_time, out_time);
        if(hours>-1)
        {
            double fee;
            if(type=="Bike" && hours>0)
            {   
                fee=Bike.first_hour_rate+(hours-1)*Bike.rest_hour_rate;
            }
            else if(type=="Bus" && hours>0)
            {
                fee=Bus.first_hour_rate+(hours-1)*Bus.rest_hour_rate;
            }
            else if(type=="Car" && hours>0)
            {
                fee=Car.first_hour_rate+(hours-1)*Car.rest_hour_rate;
            }
            else
            {
                fee=0.0;
            }
            return fee;
        }
        return -1;
    }
}
