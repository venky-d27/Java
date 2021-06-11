import java.util.*;
public class Coupon
{
    
    static HashMap<String,Integer> coupons=new HashMap<String,Integer>();
    String generate_couponcode()
    {
        UUID uuid=UUID.randomUUID();
        String couponcode=uuid.toString();
        coupons.put(couponcode,1);
        return couponcode;
    }
    
}
