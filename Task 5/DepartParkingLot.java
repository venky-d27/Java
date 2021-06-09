public class DepartParkingLot 
{
    String licence_plate_no;
    String out_time;
    DepartParkingLot(){}
    void deallocate_slot(int floor,int slot)
    {
        ParkingLot.parking[floor-1][slot-1]=0;
        
    }
    int depart_vehicle(String vehicle_plate_no,String out_time)
    {   
        for(int i=0;i<ParkingLot.parked_vehicles.size();i++)
        {
            if((ParkingLot.parked_vehicles.get(i).vehicle_plate_no.equals(vehicle_plate_no)) && ParkingLot.parked_vehicles.get(i).alive==1)
            {
                FeeCollection f=new FeeCollection();
                ParkingLot.parked_vehicles.get(i).out_time=out_time;
                ParkingLot.parked_vehicles.get(i).parking_fee=ParkingLot.parked_vehicles.get(i).reserve_fee+f.calculate_fee(ParkingLot.parked_vehicles.get(i).vehicle_type, ParkingLot.parked_vehicles.get(i).in_time, out_time);
                System.out.println("Thanks For Coming!!!\n Your Bill\n"+ParkingLot.parked_vehicles.get(i).toString());
                deallocate_slot(ParkingLot.parked_vehicles.get(i).floor_no,ParkingLot.parked_vehicles.get(i).slot_no);
                ParkingLot.parked_vehicles.get(i).alive=0;
                // System.out.print(ParkingLot.parking[ParkingLot.parked_vehicles.get(i).floor_no][ParkingLot.parked_vehicles.get(i).slot_no]);
                return 0;
            }   
        }
        return -1;
    }
}
