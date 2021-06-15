import java.util.*;
import java.text.*;
public class BillCounter 
{
    double first_hour_discount=0.5;
    double rest_hour_discount=0.1;
    Bike bfd=new Bike();
    Bus b=new Bus();
    Car c=new Car();
    BillCounter(){}
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
            // long seconds= (milliSeconds / 1000) % 60;
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
                fee=bfd.first_hour_rate+(hours-1)*bfd.rest_hour_rate;
            }
            else if(type=="Bus" && hours>0)
            {
                fee=b.first_hour_rate+(hours-1)*b.rest_hour_rate;
            }
            else if(type=="Car" && hours>0)
            {
                fee=c.first_hour_rate+(hours-1)*c.rest_hour_rate;
            }
            else
            {
                fee=0.0;
            }
            return fee;
        }
        return -1;
    }
    double calculate_discount(long hours,String type)
    {   
        double discount=0.0;
        if(type=="Bike")
        {
            discount=bfd.first_hour_rate*first_hour_discount+(hours-1)*bfd.rest_hour_rate*rest_hour_discount;
        }
        else if(type=="Bus")
        {
            discount=b.first_hour_rate*first_hour_discount+(hours-1)*b.rest_hour_rate*rest_hour_discount;
        }
        else
        {
            discount=c.first_hour_rate*first_hour_discount+(hours-1)*c.rest_hour_rate*rest_hour_discount;
        }
        return discount;
    }
    double applycoupon(String couponcode,String in_time,String out_time,String type)
    {
        int f=0;
	    // System.out.println("Yes");
        // System.out.println(couponcode);
        for(String i: Coupon.coupons.keySet())
        {   
            double discount;
            // System.out.println(i+" "+couponcode);
            if((i).equals(couponcode)==true)
            {
                f=1;
		        // System.out.println("yes");
                if(Coupon.coupons.get(i)==1)
                {
                    long hours=calculate_time_period(in_time, out_time);
                    discount=calculate_discount(hours,type); 
                    return discount;
                }
                else
                {
                    System.out.println("Coupon already availed!!!");
                    return 0.0;
                }
                
            }
        
        }
        if(f==0)
        {
        System.out.println("Wrong Coupon Code!!!");
        }
        return 0.0;
        
    }
    
}
