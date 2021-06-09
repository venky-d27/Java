public class ParkingReservation 
{
    ParkingReservation(){}
    void reserve_slot(String vehicle_plate_no,int type)
    {   
        ParkingLotAllotment pla=new ParkingLotAllotment();
        pla.parking_allotment(vehicle_plate_no, type,"00:00:00");
        try
        {
            if(type==1)
            {
                ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).reserve_fee=Bike.reserve_rate;
            }
            else if(type==2)
            {
                ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).reserve_fee=Bus.reserve_rate;
            }
            else
            {
                ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).reserve_fee=Car.reserve_rate;
            }
            System.out.println("Reservation Fee: "+ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).reserve_fee);
            ParkingLot.parked_vehicles.get(ParkingLot.parked_vehicles.size()-1).reservation_status=1;
        }
        catch(Exception e){}
    }
    void dereserve(String vehicle_plate_no)
    {
        DepartParkingLot dpl=new DepartParkingLot();
        int f=0;
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if((ParkingLot.parked_vehicles.get(i).vehicle_plate_no).equals(vehicle_plate_no) && ParkingLot.parked_vehicles.get(i).alive==1 && ParkingLot.parked_vehicles.get(i).reservation_status==1)
            {
                System.out.println("Reservation Cancelled Successfully");
                ParkingLot.parked_vehicles.get(i).alive=0;
                ParkingLot.parked_vehicles.get(i).reservation_status=0;
                dpl.deallocate_slot(ParkingLot.parked_vehicles.get(i).floor_no, ParkingLot.parked_vehicles.get(i).slot_no);
                f=1;
            }   
        }
        if(f==0)
        {
            System.out.println("No such Vehicle Plate Number!!! Kindly Check!!!");
        }
    }
}
