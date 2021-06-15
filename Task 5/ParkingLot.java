import java.util.*;
public class ParkingLot 
{
    int[][] parking;
    int car_slots,bus_slots,bike_slots,slots,floors;
    Coupon cs=new Coupon();
    Bike bfd=new Bike();
    Bus b=new Bus();
    Car c=new Car();
    ParkingLot(){}
    ParkingLot(int slots,int floors)
    {
        this.slots=slots;
        this.floors=floors;
        parking=new int[floors][slots];
        car_slots=(int)(c.slots_required*slots);
        bus_slots=(int)(b.slots_required*slots);
        bike_slots=slots-(car_slots+bus_slots);
    }
    ArrayList<Vehicle> parked_vehicles=new ArrayList<Vehicle>();
    static ArrayList<Vehicle> reserved_vehicles=new ArrayList<Vehicle>();
    boolean check_reserved(String vehicle_plate_no)
    {
        for(int i=0;i<reserved_vehicles.size();i++)
        {
            if(reserved_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)==true)
            {
                parked_vehicles.add(reserved_vehicles.get(i));
                parking[reserved_vehicles.get(i).floor_no-1][reserved_vehicles.get(i).slot_no-1]=1;
                reserved_vehicles.remove(i);
                return true;
            }
        }
        return false;
    }
    void reserve_slot(String vehicle_plate_no,int type)
    {   
        int a[]=allot_slot(type);
        if(a[0]!=-1 && a[1]!=-1)
        {
            parking[a[0]-1][a[1]-1]=2;
            Vehicle v=new Vehicle(vehicle_plate_no, type, a[0], a[1]);
            reserved_vehicles.add(v);
            if(type==1)
            {
                reserved_vehicles.get(reserved_vehicles.size()-1).reserve_fee=bfd.reserve_rate;
            }
            else if(type==2)
            {
                reserved_vehicles.get(reserved_vehicles.size()-1).reserve_fee=b.reserve_rate;
            }
            else
            {
                reserved_vehicles.get(reserved_vehicles.size()-1).reserve_fee=c.reserve_rate;
            }
            System.out.println("Reserved Successfully\n"+"Reservation Fee: "+reserved_vehicles.get(reserved_vehicles.size()-1).reserve_fee);
            reserved_vehicles.get(reserved_vehicles.size()-1).reservation_status=1;
        }
        else
        {
            System.out.println("Sorry no slots available to reserve!!!");
        }
    }
    void dereserve(String vehicle_plate_no)
    {
        int f=0;
        for(int i=0;i<ParkingLot.reserved_vehicles.size();i++)
        {
            if((ParkingLot.reserved_vehicles.get(i).vehicle_plate_no).equals(vehicle_plate_no) && ParkingLot.reserved_vehicles.get(i).alive==1 && ParkingLot.reserved_vehicles.get(i).reservation_status==1)
            {
                System.out.println("Reservation Cancelled Successfully");
                ParkingLot.reserved_vehicles.get(i).reservation_status=0;
                deallocate_slot(ParkingLot.reserved_vehicles.get(i).floor_no, ParkingLot.reserved_vehicles.get(i).slot_no);
                f=1;
            }   
        }
        if(f==0)
        {
            System.out.println("No such Vehicle Plate Number!!! Kindly Check!!!");
        }
    }
    int[] allot_slot(int type)
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
        if(check_reserved(vehicle_plate_no))
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
            parked_vehicles.get(parked_vehicles.size()-1).in_time=in_time;
            parked_vehicles.get(parked_vehicles.size()-1).couponcode=cs.generate_couponcode();
            System.out.println("Parking Slot Alllocated!!!\nFloor No: "+parked_vehicles.get(parked_vehicles.size()-1).floor_no+"\nSlot No: "+parked_vehicles.get(parked_vehicles.size()-1).slot_no+"\nCoupon code: "+parked_vehicles.get(parked_vehicles.size()-1).couponcode);
        }
    }
    void deallocate_slot(int floor,int slot)
    {
        parking[floor-1][slot-1]=0;
    }

    void depart_vehicle(String vehicle_plate_no,String out_time,String couponcode)
    {   
        Coupon cs=new Coupon();
        int f1=0;
        double fee=0.0;
        for(int i=0;i<parked_vehicles.size();i++)
        {
            if((parked_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)) && parked_vehicles.get(i).alive==1)
            {
                BillCounter f=new BillCounter();
                parked_vehicles.get(i).out_time=out_time;
                if(!couponcode.equals("-1"))
                {
                    parked_vehicles.get(i).discount= f.applycoupon(couponcode,parked_vehicles.get(i).in_time, out_time,parked_vehicles.get(i).vehicle_type);
                }
                fee=f.calculate_fee(parked_vehicles.get(i).vehicle_type, parked_vehicles.get(i).in_time, out_time);
                if(fee>-1)
                {
                parked_vehicles.get(i).parking_fee=parked_vehicles.get(i).reserve_fee+fee-parked_vehicles.get(i).discount;
                deallocate_slot(parked_vehicles.get(i).floor_no,parked_vehicles.get(i).slot_no);
                parked_vehicles.get(i).alive=0;
                parked_vehicles.get(i).reservation_status=0;
                
                System.out.println("Thanks For Coming!!!\n Your Bill\n"+parked_vehicles.get(i).toString());
                f1=1;
                }
                // System.out.print(ParkingLot.parking[ParkingLot.parked_vehicles.get(i).floor_no][ParkingLot.parked_vehicles.get(i).slot_no]);
            }   
        
            
        }
        if(f1==0 && fee>-1.0)
            {
                System.out.println("No Vehicle With given Plate Number!!!\nKindly Check!!!");
            }
    }
    void car_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<parked_vehicles.size();i++)
        {
            if(parked_vehicles.get(i).vehicle_type=="Car")
            {
                c+=1;
                amount_collected+=parked_vehicles.get(i).parking_fee;
                discount_applied+=parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Car Summary\nNo. of Cars Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void bus_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<parked_vehicles.size();i++)
        {
            if(parked_vehicles.get(i).vehicle_type=="Bus")
            {
                c+=1;
                amount_collected+=parked_vehicles.get(i).parking_fee;
                discount_applied+=parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Bus Summary\nNo. of Bus Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void bike_summary()
    {   int c=0;
        double amount_collected=0.0,discount_applied=0.0;
        for(int i=0;i<parked_vehicles.size();i++)
        {
            if(parked_vehicles.get(i).vehicle_type=="Bike")
            {
                c+=1;
                amount_collected+=parked_vehicles.get(i).parking_fee;
                discount_applied+=parked_vehicles.get(i).discount;
            }
        }
        System.out.println("Bike Summary\nNo. of Cars Parked: "+c+"\nAmount Collected: "+amount_collected+"\nDicount Applied: "+discount_applied);
    }
    void summary(int type)
    {
        if(type==1)
        {
            bike_summary();
        }
        else if(type==2)
        {
            bus_summary();
        }
        else if(type==3)
        {
            car_summary();
        }
        else
        {
            System.out.println("Wrong Choice!!!");
        }
    }
}
