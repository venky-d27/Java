import java.util.*;
public class CouponSystem
{
    static HashMap<String,Integer> coupons=new HashMap<String,Integer>();
    String generate_couponcode()
    {
        UUID uuid=UUID.randomUUID();
        String couponcode=uuid.toString();
        coupons.put(couponcode,1);
        return couponcode;
    }
    double calculate_discount(long hours,String type)
    {   
        double discount=0.0;
        if(type=="Bike")
        {
            discount=Bike.first_hour_rate*Coupon.first_hour_discount+(hours-1)*Bike.rest_hour_rate*Coupon.rest_hour_discount;
        }
        else if(type=="Bus")
        {
            discount=Bus.first_hour_rate*Coupon.first_hour_discount+(hours-1)*Bus.rest_hour_rate*Coupon.rest_hour_discount;
        }
        else
        {
            discount=Car.first_hour_rate*Coupon.first_hour_discount+(hours-1)*Car.rest_hour_rate*Coupon.rest_hour_discount;
        }
        return discount;
    }
    double applycoupon(String couponcode,String in_time,String out_time,String type)
    {
        int f=0;
	    // System.out.println("Yes");
        // System.out.println(couponcode);
        for(String i: coupons.keySet())
        {   
            double discount;
            // System.out.println(i+" "+couponcode);
            if((i).equals(couponcode)==true)
            {
                f=1;
		        // System.out.println("yes");
                if(coupons.get(i)==1)
                {
                    FeeCollection fc=new FeeCollection();
                    long hours=fc.calculate_time_period(in_time, out_time);
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
