import java.util.*;
public class ParkingLot 
{
    static int[][] parking;
    static int car_slots,bus_slots,bike_slots,slots,floors;
    Coupon cs=new Coupon();
    ParkingLot(){}
    ParkingLot(int slots,int floors)
    {
        this.slots=slots;
        this.floors=floors;
        parking=new int[floors][slots];
        car_slots=(int)(Car.slots_required*slots);
        bus_slots=(int)(Bus.slots_required*slots);
        bike_slots=slots-(car_slots+bus_slots);
    }
    static ArrayList<Vehicle> parked_vehicles=new ArrayList<Vehicle>();
    static ArrayList<Vehicle> reserved_vehicles=new ArrayList<Vehicle>();
    boolean check_reserved(String vehicle_plate_no)
    {
        for(int i=0;i<ParkingLot.reserved_vehicles.size();i++)
        {
            if(ParkingLot.reserved_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)==true)
            {
                ParkingLot.parked_vehicles.add(ParkingLot.reserved_vehicles.get(i));
                ParkingLot.parking[ParkingLot.reserved_vehicles.get(i).floor_no-1][ParkingLot.reserved_vehicles.get(i).slot_no-1]=1;
                ParkingLot.reserved_vehicles.remove(i);
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
            ParkingLot.reserved_vehicles.add(v);
            if(type==1)
            {
                ParkingLot.reserved_vehicles.get(ParkingLot.reserved_vehicles.size()-1).reserve_fee=Bike.reserve_rate;
            }
            else if(type==2)
            {
                ParkingLot.reserved_vehicles.get(ParkingLot.reserved_vehicles.size()-1).reserve_fee=Bus.reserve_rate;
            }
            else
            {
                ParkingLot.reserved_vehicles.get(ParkingLot.reserved_vehicles.size()-1).reserve_fee=Car.reserve_rate;
            }
            System.out.println("Reserved Successfully\n"+"Reservation Fee: "+ParkingLot.reserved_vehicles.get(ParkingLot.reserved_vehicles.size()-1).reserve_fee);
            ParkingLot.reserved_vehicles.get(ParkingLot.reserved_vehicles.size()-1).reservation_status=1;
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
            ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).in_time=in_time;
            ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).couponcode=cs.generate_couponcode();
            System.out.println("Parking Slot Alllocated!!!\nFloor No: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).floor_no+"\nSlot No: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).slot_no+"\nCoupon code: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).couponcode);
        }
    }
    void deallocate_slot(int floor,int slot)
    {
        ParkingLot.parking[floor-1][slot-1]=0;
    }

    void depart_vehicle(String vehicle_plate_no,String out_time,String couponcode)
    {   
        Coupon cs=new Coupon();
        int f1=0;
        double fee=0.0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if((ParkingLot.parked_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)) && ParkingLot.parked_vehicles.get(i).alive==1)
            {
                Entrance f=new Entrance();
                ParkingLot.parked_vehicles.get(i).out_time=out_time;
                if(!couponcode.equals("-1"))
                {
                    ParkingLot.parked_vehicles.get(i).discount= f.applycoupon(couponcode,ParkingLot.parked_vehicles.get(i).in_time, out_time,ParkingLot.parked_vehicles.get(i).vehicle_type);
                }
                fee=f.calculate_fee(ParkingLot.parked_vehicles.get(i).vehicle_type, ParkingLot.parked_vehicles.get(i).in_time, out_time);
                if(fee>-1)
                {
                ParkingLot.parked_vehicles.get(i).parking_fee=ParkingLot.parked_vehicles.get(i).reserve_fee+fee-ParkingLot.parked_vehicles.get(i).discount;
                deallocate_slot(ParkingLot.parked_vehicles.get(i).floor_no,ParkingLot.parked_vehicles.get(i).slot_no);
                ParkingLot.parked_vehicles.get(i).alive=0;
                ParkingLot.parked_vehicles.get(i).reservation_status=0;
                
                System.out.println("Thanks For Coming!!!\n Your Bill\n"+ParkingLot.parked_vehicles.get(i).toString());
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
}
/* 
Sir Made the Changes
Objects & Methods:
1. Vehicle (implements Bus,Car,Bike)
2. ParkingLot
    a. Reserving Slots
    b. Dereserving Slots
    c. Allocating Slots
    d. Deallocating Slots
3. Coupon
    a. Generate Coupon
    b. Apply Coupon
4. DisplayBoard
    a. Print Allocation chart
5. SummaryReport
    a. Report for Vehicle Type Car
    b. Report for Vehicle Type Bike
    c. Report for Vehicle Type Bus
6. Entrance
    a.Calculate parking fee
    b.Calculate Discount



*/