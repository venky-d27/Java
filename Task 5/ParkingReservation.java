public class ParkingReservation 
{
    ParkingReservation(){}
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
        ParkingLotAllotment pla=new ParkingLotAllotment();
        int a[]=pla.allot_slot(type);
        if(a[0]!=-1 && a[1]!=-1)
        {
            ParkingLotAllotment.parking[a[0]-1][a[1]-1]=2;
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
        DepartParkingLot dpl=new DepartParkingLot();
        int f=0;
        for(int i=0;i<ParkingLot.reserved_vehicles.size();i++)
        {
            if((ParkingLot.reserved_vehicles.get(i).vehicle_plate_no).equals(vehicle_plate_no) && ParkingLot.reserved_vehicles.get(i).alive==1 && ParkingLot.reserved_vehicles.get(i).reservation_status==1)
            {
                System.out.println("Reservation Cancelled Successfully");
                ParkingLot.reserved_vehicles.get(i).reservation_status=0;
                dpl.deallocate_slot(ParkingLot.reserved_vehicles.get(i).floor_no, ParkingLot.reserved_vehicles.get(i).slot_no);
                f=1;
            }   
        }
        if(f==0)
        {
            System.out.println("No such Vehicle Plate Number!!! Kindly Check!!!");
        }
    }
}
