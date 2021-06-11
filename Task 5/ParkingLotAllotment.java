public class ParkingLotAllotment extends ParkingLot
{
    ParkingLotAllotment(){}
    CouponSystem cs=new CouponSystem();
    static int[] allot_slot(int type)
    {   
        int a[]=new int[]{-1,-1};
        if(type==1)
        {   
            for(int i=0;i<floors;i++)
            {
                for(int j=(bus_slots+car_slots);j<slots;j++)
                {   
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i+1;
                        a[1]=j+1;
                        return a;
                    }
                }
            }
        }
        else if(type==2)
        {
            for(int i=0;i<floors;i++)
            {
                for(int j=car_slots;j<(bus_slots+car_slots);j++)
                {
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i+1;
                        a[1]=j+1;
                        return a;
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<floors;i++)
            {
                for(int j=0;j<car_slots;j++)
                {
                    if(parking[i][j]==0)
                    {
                        parking[i][j]=1;
                        a[0]=i+1;
                        a[1]=j+1;
                        return a;
                    }
                }
            } 
        }
        return a;
    }
    void parking_allotment(String vehicle_plate_no,int type,String in_time)
    {
        Vehicle v;
        int f=0;
        ParkingReservation pr=new ParkingReservation();
        if(pr.check_reserved(vehicle_plate_no))
        {
            f=1;
        }
        else
        {
            int a[]=allot_slot(type);
            if(a[0]==-1 || a[1]==-1)
            {
                System.out.println("Sorry no parking slots Available!!!");
            }
            else
            {
                v=new Vehicle(vehicle_plate_no,type,a[0],a[1]);
                parked_vehicles.add(v);
                f=1;
                
            }
        }
        if(f==1)
        {
            ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).in_time=in_time;
            ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).couponcode=cs.generate_couponcode();
            System.out.println("Parking Slot Alllocated!!!\nFloor No: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).floor_no+"\nSlot No: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).slot_no+"\nCoupon code: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).couponcode);
        }
    }
}
